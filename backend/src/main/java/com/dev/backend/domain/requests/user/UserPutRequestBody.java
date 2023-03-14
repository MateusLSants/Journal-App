package com.dev.backend.domain.requests.user;

import lombok.Data;

@Data 
public class UserPutRequestBody {
    private Long id;
    private String name;
    private String email;
    private String password;
}
