package com.example.java0610.controller;

import com.example.java0610.dto.*;
import com.example.java0610.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public UserCreateResponse create(@RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/read/{id}")
    public UserFindResponse find(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public UserUpdateResponse update(@RequestBody UserUpdateRequest request, @PathVariable Long id) {
        return userService.modifyUserById(request,id);
    }

    @DeleteMapping("/delete/{id}")
    public UserDeleteResponse delete(@PathVariable Long id){
        return userService.removeUserById(id);
    }

    @GetMapping("/recommend/{id}")
    public UserRecommendResponse recommend(@PathVariable Long id){
        return userService.recommendUserById(id);
    }
}
