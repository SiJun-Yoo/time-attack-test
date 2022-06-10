package com.example.java0610.dto;

import com.example.java0610.domain.User;
import com.example.java0610.domain.type.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserFindResponse {
    private String email;
    private String name;
    private Integer age;
    private Gender gender;

    public static UserFindResponse from(User user) {
        String email = user.getEmail();
        String name = user.getName();
        Integer age = user.getAge();
        Gender gender = user.getGender();
        return new UserFindResponse(email,name,age,gender);
    }
}
