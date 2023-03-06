package com.dev.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.backend.domain.User;
import com.dev.backend.exception.BadRequestException;
import com.dev.backend.mapper.UserMapper;
import com.dev.backend.repository.UserRepository;
import com.dev.backend.requests.user.UserPostRequestBody;
import com.dev.backend.requests.user.UserPutRequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByIdOrThrowBadRequestException(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }

    public User save(UserPostRequestBody userPostRequestBody) {
        return repository.save(UserMapper.INSTANCE.toUser(userPostRequestBody));
    }

    public void delete(long id) {
        repository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(UserPutRequestBody userPutRequestBody) {
        User savedUSer = findByIdOrThrowBadRequestException(userPutRequestBody.getId());
        User user = UserMapper.INSTANCE.toUser(userPutRequestBody);
        user.setId(savedUSer.getId());
        repository.save(user);

        
    }
}
