package com.dev.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dev.backend.domain.News;
import com.dev.backend.requests.news.NewsPostRequestBody;
import com.dev.backend.requests.news.NewsPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class NewsMapper {
    public static final NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    public abstract News toNews(NewsPostRequestBody newsPostRequestBody);
    
    public abstract News toNews(NewsPutRequestBody newsPutRequestBody);
}
