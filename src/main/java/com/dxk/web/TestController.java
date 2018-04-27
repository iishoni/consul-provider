package com.dxk.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

}
