package com.example.sideproject0.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum RoleType {
    ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

    private final String value;

    public static RoleType fromCode(String dbdata) {
        return Arrays.stream(RoleType.values())
                .filter(v -> v.getValue().equals(dbdata))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("권한 타입에 %s가 존재하지 않습니다.", dbdata)));
    }
}
