package com.holanswide.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/9/19
 */

@RestController
public class Hello {
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
    @GetMapping("/sorry")
    public String error() {
        return "sorry,we are not prepared enough now XD";
    }
}
