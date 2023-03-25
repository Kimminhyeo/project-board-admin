package com.min.projectboardadmin.dto.properties;

import lombok.Getter;

@Getter
public class Board{
    String url;

    public Board(String url) {
        this.url = url;
    }
}
