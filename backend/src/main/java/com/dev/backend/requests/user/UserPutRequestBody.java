package com.dev.backend.requests.user;

import lombok.Data;

@Data 
public class UserPutRequestBody {
    private Long id;
    private String name;
    private String email;
    private String password;
}
