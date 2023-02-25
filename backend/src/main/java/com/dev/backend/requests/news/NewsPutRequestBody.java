package com.dev.backend.requests.news;


import java.util.Date;

import com.dev.backend.domain.User;

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
