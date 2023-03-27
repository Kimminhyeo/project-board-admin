package com.min.projectboardadmin.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.min.projectboardadmin.dto.ArticleDto;
import com.min.projectboardadmin.dto.UserAccountDto;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleResponse {

    Long id;
    UserAccountDto userAccount;
    String title;
    String content;
    LocalDateTime createdAt;

    private ArticleResponse(){}

    protected ArticleResponse(Long id, UserAccountDto userAccount, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static ArticleResponse of(Long id, UserAccountDto userAccount, String title, String content, LocalDateTime createdAt) {
        return new ArticleResponse(id, userAccount, title, content, createdAt);
    }

    public static ArticleResponse withContent(ArticleDto dto) {
        return ArticleResponse.of(dto.getId(), dto.getUserAccount(), dto.getTitle(), dto.getContent(), dto.getCreatedAt());
    }

    public static ArticleResponse withoutContent(ArticleDto dto) {
        return ArticleResponse.of(dto.getId(), dto.getUserAccount(), dto.getTitle(), null, dto.getCreatedAt());
    }
}
