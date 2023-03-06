package com.dev.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.domain.News;
import com.dev.backend.requests.news.NewsPostRequestBody;
import com.dev.backend.requests.news.NewsPutRequestBody;
import com.dev.backend.service.NewsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService services;

    @GetMapping
    public ResponseEntity<List<News>> list() {
        return ResponseEntity.ok(services.findAll());
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<News> findById(@PathVariable long id) {
        return ResponseEntity.ok(services.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<News> save(@RequestBody @Valid NewsPostRequestBody newsPostRequestBody) {
        return new ResponseEntity<>(services.save(newsPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        services.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody NewsPutRequestBody newsPutRequestBody) {
        services.replace(newsPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
