package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.backend.domain.models.News;
import com.dev.backend.domain.requests.news.NewsPostRequestBody;
import com.dev.backend.domain.requests.news.NewsPutRequestBody;
import com.dev.backend.exception.BadRequestException;
import com.dev.backend.mapper.NewsMapper;
import com.dev.backend.repository.NewsRepository;

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
                .orElseThrow(() -> new BadRequestException("News not found"));             
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
