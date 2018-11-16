package com.yalunwang.demo.validator.request;


import com.summer.boot.validator.annotation.NotEmpty;

import java.util.List;

/**
 * Created by lili on 2018/11/11.
 */
public class DemoRequest {

    @NotEmpty
    private String name;
    @NotEmpty
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
