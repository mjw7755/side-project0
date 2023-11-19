package com.example.sideproject0.service;

import com.example.sideproject0.dto.UserDto;
import com.example.sideproject0.entity.User;
import com.example.sideproject0.repository.UserRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private final ObjectMapper mapper = new ObjectMapper();

    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getLoginUserByUserId(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        return user.orElse(null);
    }

    //회원가입 서비스
    @Override
    public UserDto signUp(Map<String, Object> paramMap) {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        User user = new User();
        
        user = mapper.convertValue(paramMap, User.class);

        user = userRepository.save(user);

        return UserDto.of(user);
    }

    //로그인 서비스
    @Override
    public UserDto signIn(Map<String, Object> paramMap) {

        Optional<User> user = userRepository.findByUserIdAndPassword((String) paramMap.get("userId"), (String) paramMap.get("password"));

        assert user.orElse(null) != null;

        return UserDto.of(user.orElse(null));
    }
}
