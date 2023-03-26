package com.min.projectboardadmin.dto.response;

import com.min.projectboardadmin.domain.constant.RoleType;
import com.min.projectboardadmin.dto.AdminAccountDto;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class AdminAccountResponse {

    String userId;
    String roleTypes;
    String email;
    String nickname;
    String memo;
    LocalDateTime createdAt;
    String createdBy;

    private AdminAccountResponse(){
    }

    protected AdminAccountResponse(String userId, String roleTypes, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy) {
        this.userId = userId;
        this.roleTypes = roleTypes;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public static AdminAccountResponse of(String userId, String roleTypes, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy) {
        return new AdminAccountResponse(userId, roleTypes, email, nickname, memo, createdAt, createdBy);
    }

    public static AdminAccountResponse from(AdminAccountDto dto) {
        return AdminAccountResponse.of(
                dto.getUserId(),
                dto.getRoleTypes().stream()
                        .map(RoleType::getDescription)
                        .collect(Collectors.joining(", ")),
                dto.getEmail(),
                dto.getNickname(),
                dto.getMemo(),
                dto.getCreatedAt(),
                dto.getCreatedBy()
        );
    }
}
