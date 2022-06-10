package com.example.java0610.domain;

import com.example.java0610.domain.type.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    private Long id;
    private String email;
    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
