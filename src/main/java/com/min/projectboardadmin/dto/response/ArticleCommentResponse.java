package com.min.projectboardadmin.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.min.projectboardadmin.dto.ArticleCommentDto;
import com.min.projectboardadmin.dto.UserAccountDto;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleCommentResponse {

    Long id;
    UserAccountDto userAccount;
    String content;
    LocalDateTime createdAt;

    private ArticleCommentResponse(){}

    protected ArticleCommentResponse(Long id, UserAccountDto userAccount, String content, LocalDateTime createdAt) {
        this.id = id;
        this.userAccount = userAccount;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static ArticleCommentResponse of(Long id, UserAccountDto userAccount, String content, LocalDateTime createdAt) {
        return new ArticleCommentResponse(id, userAccount, content, createdAt);
    }

    public static ArticleCommentResponse of(ArticleCommentDto dto) {
        return ArticleCommentResponse.of(dto.getId(), dto.getUserAccount(), dto.getContent(), dto.getCreatedAt());
    }
}
