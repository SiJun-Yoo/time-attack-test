package com.example.java0610.repository;

import com.example.java0610.domain.User;
import com.example.java0610.domain.type.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT user FROM User user WHERE user.age = :age AND NOT user.gender = :gender ")
    Optional<List<User>> recommendByAllUser(Integer age, Gender gender);
}
