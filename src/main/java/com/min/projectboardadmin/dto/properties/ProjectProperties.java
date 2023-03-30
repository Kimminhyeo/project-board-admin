package com.min.projectboardadmin.dto.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@ConfigurationProperties("project")
public class ProjectProperties {

    @Value("${project.board.url}")
    String url;
}
