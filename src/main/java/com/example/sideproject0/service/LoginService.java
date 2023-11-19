package com.example.sideproject0.service;

import com.example.sideproject0.dto.UserDto;
import com.example.sideproject0.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface LoginService {
    public User getLoginUserByUserId(String userId);
    public UserDto signUp(Map<String, Object> paramMap);
    public UserDto signIn(Map<String, Object> paramMap);
}
