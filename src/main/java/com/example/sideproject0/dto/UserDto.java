package com.example.sideproject0.dto;

import com.example.sideproject0.constant.RoleType;
import com.example.sideproject0.constant.UserStatus;

import java.time.LocalDateTime;

public record UserDto(
        Long uniqId
        , String userId
        , String username
        , String password
        , UserStatus status
        , String email
        , RoleType roleType
        , LocalDateTime createDate
        , LocalDateTime updateDate
) {

    // factory method of 선언
    public static UserDto of(Long uniqId, String userId, String username, String password, UserStatus status, String email, RoleType roleType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new UserDto(uniqId, userId, username, password, status, email, roleType, createdAt, updatedAt);
    }

    // security에서 사용할 팩토리 메서드
    public static UserDto of(String userId) {
        return new UserDto(
                null, userId, null, null, null, null, null, null, null
        );
    }

}
