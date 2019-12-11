package kz.project.one;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TestService {
    @Autowired
    ServiceFeignClient serviceFeignClient;
    @PostConstruct
    public  void test() {

        System.out.println(serviceFeignClient.byUsername("n.sandibekova").getStatusCode());
        System.out.println(serviceFeignClient.byUsername("yeabdrahmetova").getStatusCode());
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8060/rest")
                .asyncResponseTimeout(10000)
                .build();

         client.subscribe("HrInitiator")
                 .lockDuration(1000)
                 .handler((externalTask, externalTaskService) -> {
                     try {
                         String hrInitiator = externalTask.getVariable("HrInitiator");
                         Example initiatorProfiles = serviceFeignClient.byUsername(hrInitiator).getBody();

                         String hrUserId = initiatorProfiles.getEmail();
                         Map<String, Object> newVars2 = new HashMap<>();
                         newVars2.put("hrId", hrUserId);
                         externalTaskService.complete(externalTask, newVars2);
                         externalTaskService.complete(externalTask);
                     }catch (Exception e){
                         externalTaskService.handleFailure(externalTask,e.getMessage(),"error",0,0);
                     }
                 });

        client.subscribe("initiator")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {

                    String initiatorUserId =externalTask.getVariable("initiator");

                    Example initiatorProfile = serviceFeignClient.byUsername(initiatorUserId).getBody();

                    String teamLeadUserId = initiatorProfile.getTeamlead();
                    Map<String,Object> newVars = new HashMap<>();
                    newVars.put("teamLeadUserId",teamLeadUserId);
                    externalTaskService.complete(externalTask,newVars);

                    externalTaskService.complete(externalTask);
                })
                .open();
    }
}
