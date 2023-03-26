package com.min.projectboardadmin.dto;

import com.min.projectboardadmin.domain.constant.RoleType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class UserAccountDto {
    private String userId;
    private String email;
    private String nickname;
    private String memo;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    protected UserAccountDto(){}
    private UserAccountDto(
                           String userId,
                           String email,
                           String nickname,
                           String memo,
                           LocalDateTime createdAt,
                           String createdBy,
                           LocalDateTime modifiedAt,
                           String modifiedBy) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }
    public static UserAccountDto of(
                                    String userId,
                                    String email,
                                    String nickname,
                                    String memo) {
        return UserAccountDto.of(userId, email, nickname, memo, null, null, null, null);
    }
    public static UserAccountDto of(
                                    String userId,
                                    String email,
                                    String nickname,
                                    String memo,
                                    LocalDateTime createdAt,
                                    String createdBy,
                                    LocalDateTime modifiedAt,
                                    String modifiedBy) {
        return new UserAccountDto(userId, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }
}
