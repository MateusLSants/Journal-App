package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dev.backend.domain.News;
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
        News news = News.builder()
                    .title(newsPostRequestBody.getTitle())
                    .content(newsPostRequestBody.getContent())
                    .author(newsPostRequestBody.getAuthor())
                    .dateCreated(newsPostRequestBody.getDateCreated())
                    .dateUpadte(newsPostRequestBody.getDateUpadte())
                    .build();

        return repository.save(news);
    }

    public void delete(long id) {
        repository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(NewsPutRequestBody newsPutRequestBody) {
        News savedNews = findByIdOrThrowBadRequestException(newsPutRequestBody.getId());
        newsPutRequestBody.setDateUpadte(new Date());
        News news = News.builder()
                    .id(savedNews.getId())
                    .title(newsPutRequestBody.getTitle())
                    .content(newsPutRequestBody.getContent())
                    .author(newsPutRequestBody.getAuthor())
                    .dateCreated(savedNews.getDateCreated())
                    .dateUpadte(newsPutRequestBody.getDateUpadte())
                    .build();

        repository.save(news);
    }

}
