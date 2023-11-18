package com.example.sideproject0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index.do")
    public String index() {
        return "index";
    }
}
