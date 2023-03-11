package com.rana.pilot.controller;

import com.rana.pilot.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorld {

    @Autowired
    private HelloWorldService helloWorldService;


    @Value("${todo_base_url}")
    public String postManBaseUrl;




    @GetMapping("/hello")
    public String test() throws InterruptedException {
//       RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        ResponseEntity<String> restResponse=restTemplate.getForEntity(postManBaseUrl+"/helloworld", String.class);
//        String res=restResponse.getBody().toString();


       // return "hello Dear Munish, from Minal";
        return helloWorldService.test();
    }
}
