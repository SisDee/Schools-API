package com.schools.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
        allowCredentials = "false",
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}
)
@SuppressWarnings("unchecked")
@RestController
public class DefaultController {

    @GetMapping("/")
    ResponseEntity<String> home(){
        ResponseEntity<String> greetings = new ResponseEntity<String>("hello Dineo", HttpStatus.OK);
        return  greetings;
    }


    @GetMapping("/new")
    ResponseEntity<String> test(){
        ResponseEntity<String> greetings = new ResponseEntity<String>("<marquee><Hello world</marquee>", HttpStatus.OK);
        return  greetings;
    }

    @GetMapping("/greetings")
    ResponseEntity<String> greetings(){
        ResponseEntity<String> greetings = new ResponseEntity<String>("hello world part 2",HttpStatus.OK);
        return  greetings;
    }
}

