package com.example.springboottestpractice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

    @Value("${test.phase}")
    private String PHASE;

    @GetMapping("/phase")
    public String getPhaseName(){
        return PHASE;
    }
}
