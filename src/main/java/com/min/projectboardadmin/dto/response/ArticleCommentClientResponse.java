package com.min.projectboardadmin.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.min.projectboardadmin.dto.ArticleDto;
import com.min.projectboardadmin.dto.security.ArticleCommentDto;
import lombok.Getter;

import java.util.List;

public class ArticleCommentClientResponse {

    @JsonProperty("_embedded")
    Embedded2 embedded;
    @JsonProperty("page")
    Page2 page;

    private ArticleCommentClientResponse(){}

    protected ArticleCommentClientResponse(Embedded2 embedded, Page2 page) {
        this.embedded = embedded;
        this.page = page;
    }

    public static ArticleCommentClientResponse empty() {
        return new ArticleCommentClientResponse(
                new Embedded2(List.of()),
                new Page2(1, 0, 1, 0)
        );
    }

    public static ArticleCommentClientResponse of(List<ArticleCommentDto> articleComments) {
        return new ArticleCommentClientResponse(
                new Embedded2(articleComments),
                new Page2(articleComments.size(), articleComments.size(), 1, 0)
        );
    }

    public List<ArticleCommentDto> articleComments() { return this.embedded.getArticleComments(); }

}

@Getter
class Embedded2 {
    List<ArticleCommentDto> articleComments;

    public Embedded2(List<ArticleCommentDto> articleComments) {
        this.articleComments = articleComments;
    }
}

@Getter
class Page2{
    int size;
    long totalElements;
    int totalPages;
    int number;

    public Page2(int size, long totalElements, int totalPages, int number) {
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
    }
}
