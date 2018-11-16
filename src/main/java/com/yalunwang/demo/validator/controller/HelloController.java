package com.yalunwang.demo.validator.controller;


import com.summer.boot.validator.annotation.NotEmpty;
import com.yalunwang.demo.validator.request.DemoRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lili on 2018/11/10.
 */
@RestController
public class HelloController {

    @RequestMapping("/hi")
    public String hi(@NotEmpty String name){
        return "hi"+name;
    }
    @RequestMapping("/hi1")
    public String hi1(@RequestBody DemoRequest request){
        return "hi"+request.getName();
    }

    @RequestMapping("/hi2")
    public String hi2(@RequestBody  List<DemoRequest> request){
        return "hi"+request.get(0).getName();
    }

}
