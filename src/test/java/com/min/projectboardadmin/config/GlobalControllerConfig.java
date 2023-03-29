package com.min.projectboardadmin.config;

import com.min.projectboardadmin.domain.constant.RoleType;
import com.min.projectboardadmin.dto.AdminAccountDto;
import com.min.projectboardadmin.service.AdminAccountService;
import com.min.projectboardadmin.service.VisitCounterService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@TestConfiguration
public class GlobalControllerConfig {

    @MockBean
    private VisitCounterService visitCounterService;

    @BeforeTestMethod
    public void securitySetup(){
        given(visitCounterService.visitCount())
                .willReturn(0L);
    }

}
