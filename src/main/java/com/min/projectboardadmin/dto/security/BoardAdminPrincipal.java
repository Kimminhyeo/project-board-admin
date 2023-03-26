package com.min.projectboardadmin.dto.security;

import com.min.projectboardadmin.domain.constant.RoleType;
import com.min.projectboardadmin.dto.AdminAccountDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class BoardAdminPrincipal implements UserDetails, OAuth2User {
    private String username;
    private String password;
    Collection<? extends GrantedAuthority> authorities;
    private String email;
    private String nickname;
    private String memo;

    Map<String, Object> oAuth2Attributes;

    protected BoardAdminPrincipal(){}

    private BoardAdminPrincipal(String username, String password, Collection<? extends GrantedAuthority> authorities, String email, String nickname, String memo, Map<String, Object> oAuth2Attributes){
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
        this.oAuth2Attributes = oAuth2Attributes;
    }

    public static BoardAdminPrincipal of(String username, String password, Set<RoleType> roleTypes, String email, String nickname, String memo) {
        return BoardAdminPrincipal.of(username, password, roleTypes, email, nickname, memo, Map.of());
    }

    public static BoardAdminPrincipal of(String username, String password, Set<RoleType> roleTypes, String email, String nickname, String memo, Map<String, Object> oAuth2Attributes) {

        return new BoardAdminPrincipal(
                username,
                password,
                roleTypes.stream()
                        .map(RoleType::getRoleName)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toUnmodifiableSet()),
                email,
                nickname,
                memo,
                oAuth2Attributes);
    }

    public static BoardAdminPrincipal from(AdminAccountDto dto){
        return BoardAdminPrincipal.of(
                dto.getUserId(),
                dto.getUserPassword(),
                dto.getRoleTypes(),
                dto.getEmail(),
                dto.getNickname(),
                dto.getMemo()
        );
    }

    public AdminAccountDto toDto(){
        return AdminAccountDto.of(
                username,
                password,
                authorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .map(RoleType::valueOf)
                        .collect(Collectors.toUnmodifiableSet()),
                email,
                nickname,
                memo
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2Attributes;
    }
    @Override
    public String getName() {
        return username;
    }

}
