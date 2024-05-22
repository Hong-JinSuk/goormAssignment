package com.goorm.tricountapi.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String loginId;
    private String password;
}
