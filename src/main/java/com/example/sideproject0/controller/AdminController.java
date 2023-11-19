package com.example.sideproject0.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "ADMIN 컨트롤러", description = "ADMIN 페이지 API")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/index.do")
    public String index() {
        return "관리자 페이지 접근";
    }
}
