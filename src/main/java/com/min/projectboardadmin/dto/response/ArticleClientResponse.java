package com.min.projectboardadmin.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.min.projectboardadmin.dto.ArticleDto;
import lombok.Getter;

import java.util.List;

public class ArticleClientResponse {
    @JsonProperty("_embedded")
    Embedded embedded;
    @JsonProperty("page")
    Page page;

    private ArticleClientResponse(){}

    protected ArticleClientResponse(Embedded embedded, Page page) {
        this.embedded = embedded;
        this.page = page;
    }

    public static ArticleClientResponse empty() {
        return new ArticleClientResponse(
                new Embedded(List.of()),
                new Page(1, 0, 1, 0)
        );
    }

    public static ArticleClientResponse of(List<ArticleDto> articles) {
        return new ArticleClientResponse(
                new Embedded(articles),
                new Page(articles.size(), articles.size(), 1, 0)
        );
    }

    public List<ArticleDto> articles() {
        return this.embedded.getArticles();
    }
}

@Getter
class Embedded {
    List<ArticleDto> articles;

    public Embedded(List<ArticleDto> articles) {
        this.articles = articles;
    }
}

@Getter
class Page{
    int size;
    long totalElements;
    int totalPages;
    int number;

    public Page(int size, long totalElements, int totalPages, int number) {
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
    }
}
