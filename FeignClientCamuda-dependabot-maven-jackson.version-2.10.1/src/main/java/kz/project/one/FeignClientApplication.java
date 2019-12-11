package kz.project.one;

import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient

public class FeignClientApplication {
    private final static Logger LOGGER = Logger.getLogger(FeignClientApplication.class.getName());
   @Autowired
    TestService testService;

    public static void main(String... args) {
        SpringApplication.run(FeignClientApplication.class,args);

    }
}












