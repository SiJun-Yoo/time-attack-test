package com.example.java0610.dto;

import com.example.java0610.domain.User;
import com.example.java0610.domain.type.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserUpdateRequest {
    private String name;
    private Integer age;
    private Gender gender;

    public static User newUser(UserUpdateRequest userUpdateRequest){
        User user = new User();
        user.setName(userUpdateRequest.getName());
        user.setAge(userUpdateRequest.getAge());
        user.setGender(userUpdateRequest.getGender());
        return user;
    }
}
