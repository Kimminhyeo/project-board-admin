package com.min.projectboardadmin.dto.websocket;

import lombok.Getter;

@Getter
public class WebSocketMessage {

    String content;

    private WebSocketMessage(){}

    protected WebSocketMessage(String content) {
        this.content = content;
    }

    public static WebSocketMessage of(String content) {
        return new WebSocketMessage(content);
    }
}
