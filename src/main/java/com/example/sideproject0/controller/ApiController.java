package com.example.sideproject0.controller;

import com.example.sideproject0.dto.UserDto;
import com.example.sideproject0.entity.User;
import com.example.sideproject0.security.jwt.JwtTokenUtil;
import com.example.sideproject0.service.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "로그인 API 컨트롤러", description = "로그인 관련 API 모음")
@RestController
@RequestMapping("/login")
public class ApiController {

    private final LoginService loginService;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public ApiController(LoginService loginService, JwtTokenUtil jwtTokenUtil) {
        this.loginService = loginService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("/test.do")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test");
    }

    @PostMapping("/signUp.do")
    public ResponseEntity<?> signUp(@RequestParam Map<String, Object> paramMap) {
        UserDto userdto = loginService.signUp(paramMap);

        return ResponseEntity.ok().body(userdto);
    }

    @PostMapping("/signIn.do")
    public ResponseEntity<?> signIn(@RequestParam Map<String, Object> paramMap) {
        UserDto userdto = loginService.signIn(paramMap);

        // 로그인 아이디나 비밀번호가 틀린 경우
        if(userdto == null) {
            return ResponseEntity.ok("로그인 아이디 또는 비밀번호가 틀렸습니다.");
        }

        String jwtToken = jwtTokenUtil.createToken(userdto.userId());

        return ResponseEntity.ok().body(jwtToken);
    }

    @GetMapping("/getUserInfo.do")
    public String userInfo(Authentication auth) {
        if(auth == null) {
            return "로그인 되지 않았습니다.";
        }
        User user = loginService.getLoginUserByUserId(auth.getName());

        return String.format("userId : %s\nusername : %s\nrole : %s",
                user.getUserId(), user.getUsername(), user.getRoleType().name());
    }
}
