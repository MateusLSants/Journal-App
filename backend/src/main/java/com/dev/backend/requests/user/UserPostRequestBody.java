package com.dev.backend.requests.user;

import lombok.Data;

@Data
public class UserPostRequestBody {
    private String name;
    private String email;
    private String password;
}
