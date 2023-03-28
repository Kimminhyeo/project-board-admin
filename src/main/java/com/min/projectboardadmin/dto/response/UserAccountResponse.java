package com.min.projectboardadmin.dto.response;

import com.min.projectboardadmin.dto.UserAccountDto;

import java.time.LocalDateTime;

public class UserAccountResponse {

    String userId;
    String email;
    String nickname;
    String memo;
    LocalDateTime createdAt;
    String createdBy;

    private UserAccountResponse() {
    }

    protected UserAccountResponse(String userId, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }


    public static UserAccountResponse of(String userId, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy) {
        return new UserAccountResponse(userId, email, nickname, memo, createdAt, createdBy);
    }

    public static UserAccountResponse from(UserAccountDto dto) {
        return UserAccountResponse.of(
                dto.getUserId(),
                dto.getEmail(),
                dto.getNickname(),
                dto.getMemo(),
                dto.getCreatedAt(),
                dto.getCreatedBy()
        );
    }
}
