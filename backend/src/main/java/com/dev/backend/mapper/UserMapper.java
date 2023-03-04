package com.dev.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dev.backend.domain.User;
import com.dev.backend.requests.user.UserPostRequestBody;
import com.dev.backend.requests.user.UserPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract User toUser(UserPostRequestBody userPostRequestBody);
    
    public abstract User toUser(UserPutRequestBody userPutRequestBody);
}
