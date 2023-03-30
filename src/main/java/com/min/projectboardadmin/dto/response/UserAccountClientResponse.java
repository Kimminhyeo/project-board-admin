package com.min.projectboardadmin.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.min.projectboardadmin.dto.UserAccountDto;
import lombok.Getter;

import java.util.List;

public class UserAccountClientResponse {
    @JsonProperty("_embedded")
    Embedded3 embedded;
    @JsonProperty("page")
    Page3 page;

    private UserAccountClientResponse(){}

    protected UserAccountClientResponse(Embedded3 embedded, Page3 page) {
        this.embedded = embedded;
        this.page = page;
    }

    public static UserAccountClientResponse empty() {
        return new UserAccountClientResponse(
                new Embedded3(List.of()),
                new Page3(1, 0, 1, 0)
        );
    }

    public static UserAccountClientResponse of(List<UserAccountDto> userAccounts) {
        return new UserAccountClientResponse(
                new Embedded3(userAccounts),
                new Page3(userAccounts.size(), userAccounts.size(), 1, 0)
        );
    }

    public List<UserAccountDto> userAccounts() { return this.embedded.getUserAccounts(); }

}

@Getter
class Embedded3 {
    List<UserAccountDto> userAccounts;

    public Embedded3() {
    }

    public Embedded3(List<UserAccountDto> userAccounts) {
        this.userAccounts = userAccounts;
    }
}

@Getter
class Page3{
    int size;
    long totalElements;
    int totalPages;
    int number;

    public Page3() {
    }

    public Page3(int size, long totalElements, int totalPages, int number) {
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
    }
}