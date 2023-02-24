package com.dev.backend.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dev.backend.domain.User;
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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario not found"));
    }

    public User save(UserPostRequestBody userPostRequestBody) {
        User user = User.builder()
                    .name(userPostRequestBody.getName())
                    .email(userPostRequestBody.getEmail())
                    .password(userPostRequestBody.getPassword())
                    .build();

        return repository.save(user);
    }

    public void delete(long id) {
        repository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(UserPutRequestBody userPutRequestBody) {
        User savedUSer = findByIdOrThrowBadRequestException(userPutRequestBody.getId());
        User user = User.builder()
                    .id(savedUSer.getId())
                    .name(userPutRequestBody.getName())
                    .email(userPutRequestBody.getEmail())
                    .password(userPutRequestBody.getPassword())
                    .build();

        repository.save(user);

        
    }
}
