package com.example.springboottestpractice;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OperationController {

    private final Adder adder;

    @PostMapping("/add")
    public Integer add(@RequestBody AddRequest request){
        return adder.add(request.getA(), request.getB());
    }
}
