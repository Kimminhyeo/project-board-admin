package com.min.projectboardadmin.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
public class ArticleDto {
    Long id;
    UserAccountDto userAccount;
    String title;
    String content;
    Set<String> hashtags;
    LocalDateTime createdAt;
    String createdBy;
    LocalDateTime modifiedAt;
    String modifiedBy;

    private ArticleDto(){}

    protected ArticleDto(Long id, UserAccountDto userAccount, String title, String content, Set<String> hashtags, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        this.id = id;
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
        this.hashtags = hashtags;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }

    public static ArticleDto of(Long id, UserAccountDto userAccount, String title, String content, Set<String> hashtags, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleDto(id, userAccount, title, content, hashtags, createdAt, createdBy, modifiedAt, modifiedBy);
    }
}
