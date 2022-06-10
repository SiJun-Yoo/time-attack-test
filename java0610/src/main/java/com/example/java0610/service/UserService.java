package com.example.java0610.service;

import com.example.java0610.domain.User;
import com.example.java0610.domain.type.Gender;
import com.example.java0610.dto.*;
import com.example.java0610.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserCreateResponse createUser(UserCreateRequest request) {
        User user = UserCreateRequest.newUser(request);
        user = userRepository.save(user);
        return UserCreateResponse.from(user);
    }

    @Transactional(readOnly = true)
    public UserFindResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
        return UserFindResponse.from(user);
    }

    public UserUpdateResponse modifyUserById(UserUpdateRequest request, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setGender(request.getGender());
        return UserUpdateResponse.from(user);
    }

    public UserDeleteResponse removeUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
        userRepository.delete(user);
        return UserDeleteResponse.from(id);
    }

    @Transactional(readOnly = true)
    public UserRecommendResponse recommendUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
        Integer age = user.getAge();
        Gender gender = user.getGender();
        List<User> recommendUser = userRepository.recommendByAllUser(age,gender).orElseThrow(() -> new IllegalStateException("서버 에러 입니다."));

        UserRecommendResponse response = new UserRecommendResponse();
        List<UserRecommendDto> userList = response.getResult();
        for(User nowUser : recommendUser){
            userList.add(UserRecommendDto.from(nowUser));
        }
        return response;
    }


}
