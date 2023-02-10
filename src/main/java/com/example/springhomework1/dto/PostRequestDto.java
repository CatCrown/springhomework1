package com.example.springhomework1.dto;

import lombok.Data;
import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;//제목
    private String username;//작성자명
    private String contents; // 작성내용
    private String pw;//비번
}
