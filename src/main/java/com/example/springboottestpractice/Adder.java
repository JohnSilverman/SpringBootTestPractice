package com.example.springboottestpractice;

import org.springframework.stereotype.Component;

@Component
public class Adder {

    public Integer add(Integer a, Integer b){
        return a + b;
    }
}
