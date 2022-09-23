package com.holanswide.demo.controller;

import com.alibaba.fastjson.JSON;
import com.holanswide.demo.services.UserMapperImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/9/19
 */

@RestController
public class Hello {
    @Autowired
    UserMapperImp userMapperImp;

    @GetMapping("/all")
    public String getAll() {
        return JSON.toJSONString(userMapperImp.queryUserAll());
    }

    @GetMapping("up")
    public void changeByName(@RequestParam("name") String name) {
        userMapperImp.updateUserByName(name);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/sorry")
    public String error() {
        return "sorry,we are not prepared enough now XD";
    }
}
