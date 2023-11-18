package com.example.sideproject0.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "API 컨트롤러", description = "로그인 API")
@RestController
@RequestMapping("/api/v1/")
public class ApiController {

    @GetMapping("/test.do")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test");
    }
}
