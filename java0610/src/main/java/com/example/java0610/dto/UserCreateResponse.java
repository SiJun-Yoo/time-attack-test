package com.example.java0610.dto;

import com.example.java0610.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserCreateResponse {
    private Long id;

    public static UserCreateResponse from(User user) {
        Long id = user.getId();
        return new UserCreateResponse(id);
    }
}
