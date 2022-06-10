package com.example.java0610.dto;

import com.example.java0610.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDeleteResponse {
    private Long id;

    public static UserDeleteResponse from(Long id) {
        return new UserDeleteResponse(id);
    }
}
