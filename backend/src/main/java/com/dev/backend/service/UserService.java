package com.dev.backend.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.backend.domain.models.User;
import com.dev.backend.domain.requests.user.UserPostRequestBody;
import com.dev.backend.domain.requests.user.UserPutRequestBody;
import com.dev.backend.exception.BadRequestException;
import com.dev.backend.mapper.UserMapper;
import com.dev.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByIdOrThrowBadRequestException(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }

    public User save(UserPostRequestBody userPostRequestBody) {
        userPostRequestBody.setPassword(passwordEncoder.encode(userPostRequestBody.getPassword()));
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
