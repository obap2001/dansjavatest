package test.javadev.dansmultipro.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TaskController {
    private final RestTemplate restTemplate;
    public TaskController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
    }
    @GetMapping("/jobs")

    public ResponseEntity<String> getJobList() {
        String apiUrl = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";

        ResponseEntity<String> responseEntity = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            responseEntity = restTemplate.getForEntity(apiUrl, String.class);
            responseEntity = ResponseEntity.ok(responseEntity.getBody());
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        }
        return responseEntity;
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<String> getJobDetail(@PathVariable("id") String id){
        String apiUrl = "http://dev3.dansmultipro.co.id/api/recruitment/positions/" + id;
        ResponseEntity<String> responseEntity = null;
        RestTemplate restTemplate = new RestTemplate();
        try{
            responseEntity = restTemplate.getForEntity(apiUrl, String.class);
            responseEntity = ResponseEntity.ok( responseEntity.getBody());
        }catch(Exception e){
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        }
        return responseEntity;
    }
}
