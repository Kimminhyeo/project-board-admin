package com.min.projectboardadmin.dto;

import com.min.projectboardadmin.domain.AdminAccount;
import com.min.projectboardadmin.domain.constant.RoleType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class AdminAccountDto {
    private String userId;
    private String userPassword;
    Set<RoleType> roleTypes;
    private String email;
    private String nickname;
    private String memo;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

    protected AdminAccountDto(){}
    private AdminAccountDto(
                           String userId,
                           String userPassword,
                           Set<RoleType> roleTypes,
                           String email,
                           String nickname,
                           String memo,
                           LocalDateTime createdAt,
                           String createdBy,
                           LocalDateTime modifiedAt,
                           String modifiedBy) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.roleTypes = roleTypes;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }
    public static AdminAccountDto of(
                                    String userId,
                                    String userPassword,
                                    Set<RoleType> roleTypes,
                                    String email,
                                    String nickname,
                                    String memo) {
        return AdminAccountDto.of(userId, userPassword, roleTypes, email, nickname, memo, null, null, null, null);
    }
    public static AdminAccountDto of(
                                    String userId,
                                    String userPassword,
                                    Set<RoleType> roleTypes,
                                    String email,
                                    String nickname,
                                    String memo,
                                    LocalDateTime createdAt,
                                    String createdBy,
                                    LocalDateTime modifiedAt,
                                    String modifiedBy) {
        return new AdminAccountDto(userId, userPassword, roleTypes, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static AdminAccountDto from(AdminAccount entity) {
        return new AdminAccountDto(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getRoleTypes(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public AdminAccount toEntity() {
        return AdminAccount.of(
                userId,
                userPassword,
                roleTypes,
                email,
                nickname,
                memo
        );
    }
}
