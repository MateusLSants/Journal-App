package com.dev.backend.requests.news;

import java.util.Date;

import com.dev.backend.domain.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewsPostRequestBody {
    @NotNull(message = "title cannot be null")
    @NotEmpty(message = "title cannot be empty")
    private String title;
    @NotNull(message = "content cannot be null")
    @NotEmpty(message = "content cannot be empty")
    private String content;
    @NotNull(message = "author cannot be null")
    @NotEmpty(message = "author cannot be empty")
    private User author;
    private Date dateCreated;
    private Date dateUpadte;
}
