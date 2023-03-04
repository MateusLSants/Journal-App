package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dev.backend.domain.News;
import com.dev.backend.mapper.NewsMapper;
import com.dev.backend.repository.NewsRepository;
import com.dev.backend.requests.news.NewsPostRequestBody;
import com.dev.backend.requests.news.NewsPutRequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsService {
    
    private final NewsRepository repository;

    public List<News> findAll() {
        return repository.findAll();
    }

    public News findByIdOrThrowBadRequestException(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "News not found"));             
    }
    
    public News save(NewsPostRequestBody newsPostRequestBody) {
        newsPostRequestBody.setDateCreated(new Date());
        return repository.save(NewsMapper.INSTANCE.toNews(newsPostRequestBody));
    }

    public void delete(long id) {
        repository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(NewsPutRequestBody newsPutRequestBody) {
        newsPutRequestBody.setDateUpadte(new Date());
        News savedNews = findByIdOrThrowBadRequestException(newsPutRequestBody.getId());
        News news = NewsMapper.INSTANCE.toNews(newsPutRequestBody);
        news.setId(savedNews.getId());
        repository.save(news);
    }

}
