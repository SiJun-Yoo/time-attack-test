package com.example.java0610.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRecommendResponse {
    private List<UserRecommendDto> result = new ArrayList<>();
}
