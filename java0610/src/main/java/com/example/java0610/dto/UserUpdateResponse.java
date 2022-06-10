package com.example.java0610.dto;

import com.example.java0610.domain.User;
import com.example.java0610.domain.type.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserUpdateResponse {
    private Long id;
    public static UserUpdateResponse from(User user) {
        Long id = user.getId();
        return new UserUpdateResponse(id);
    }
}
