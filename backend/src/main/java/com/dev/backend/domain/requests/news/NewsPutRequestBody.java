package com.dev.backend.domain.requests.news;


import java.util.Date;

import com.dev.backend.domain.models.User;

import lombok.Data;

@Data
public class NewsPutRequestBody {
    private Long id;
    private String title;
    private String content;
    private User author;
    private Date dateCreated;
    private Date dateUpadte;

}
