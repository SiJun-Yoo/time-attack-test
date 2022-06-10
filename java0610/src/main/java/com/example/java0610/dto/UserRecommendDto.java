package com.example.java0610.dto;

import com.example.java0610.domain.User;
import com.example.java0610.domain.type.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRecommendDto {
    private String email;
    private String name;
    private Integer age;
    private Gender gender;

    public static UserRecommendDto from(User user) {
        String email = user.getEmail();
        String name = user.getName();
        Integer age = user.getAge();
        Gender gender = user.getGender();
        return new UserRecommendDto(email,name,age,gender);
    }
}
