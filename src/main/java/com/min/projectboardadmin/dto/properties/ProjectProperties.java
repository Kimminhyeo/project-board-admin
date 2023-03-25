package com.min.projectboardadmin.dto.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties("project")
public class ProjectProperties {

    Board board;

    public ProjectProperties(Board board) {
        this.board = board;
    }
}
