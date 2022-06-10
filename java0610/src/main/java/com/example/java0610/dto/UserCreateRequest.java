package com.example.java0610.dto;

import com.example.java0610.domain.User;
import com.example.java0610.domain.type.Gender;
import lombok.Data;

@Data
public class UserCreateRequest {
    private String email;
    private String name;
    private Integer age;
    private Gender gender;
    public static User newUser(UserCreateRequest userCreateRequest){
        User user = new User();
        user.setEmail(userCreateRequest.getEmail());
        user.setName(userCreateRequest.getName());
        user.setAge(userCreateRequest.getAge());
        user.setGender(userCreateRequest.getGender());
        return user;
    }
}
