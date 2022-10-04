package com.songhao.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/get")
    public Map get(){
        HashMap<Object, Object> result = new HashMap<>();
        result.put("1","hello");
        return  result;
    }
}
