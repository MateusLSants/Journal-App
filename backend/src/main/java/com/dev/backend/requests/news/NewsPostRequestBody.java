package com.dev.backend.requests.news;

import java.util.Date;

import com.dev.backend.domain.User;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class NewsPostRequestBody {
    private String title;
    private String content;
    private Date dateCreated;
    private Date dateUpdate;
    @ManyToOne
    private User author;

}
