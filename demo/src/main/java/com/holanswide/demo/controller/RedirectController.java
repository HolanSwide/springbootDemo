package com.holanswide.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/9/23
 */

@Controller
public class RedirectController {
    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }
}
