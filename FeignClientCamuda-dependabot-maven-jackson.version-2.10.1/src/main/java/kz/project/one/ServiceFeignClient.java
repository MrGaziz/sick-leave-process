package kz.project.one;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ServiceFeignClient",url = "http://192.168.10.157:6060")
public interface ServiceFeignClient {
        @GetMapping("/employee/search/user/{id}")
        ResponseEntity<Example> byUsername(@PathVariable String id);
}
