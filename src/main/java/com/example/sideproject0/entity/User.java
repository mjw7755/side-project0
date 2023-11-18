package com.example.sideproject0.entity;

import com.example.sideproject0.constant.RoleType;
import com.example.sideproject0.constant.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name="USER")
@Getter
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uniq_id")
    private Long uniqId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

}
