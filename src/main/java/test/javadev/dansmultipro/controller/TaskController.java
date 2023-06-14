package test.javadev.dansmultipro.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class TaskController {
    final public static String API_URL="http://dev3.dansmultipro.co.id/api/recruitment";

    @GetMapping("/jobs")
    public ResponseEntity<Object> getJobList() {

        ResponseEntity<Object> responseEntity = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            responseEntity = restTemplate.getForEntity(API_URL+"/positions.json", Object.class);
            responseEntity = ResponseEntity.ok(responseEntity.getBody());
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        }
        return responseEntity;
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Object> getJobDetail(@PathVariable("id") String id){
        ResponseEntity<Object> responseEntity = null;
        RestTemplate restTemplate = new RestTemplate();
        try{
            responseEntity = restTemplate.getForEntity(API_URL+"/positions/" + id, Object.class);
            responseEntity = ResponseEntity.ok( responseEntity.getBody());
        }catch(Exception e){
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        }
        return responseEntity;
    }
}
