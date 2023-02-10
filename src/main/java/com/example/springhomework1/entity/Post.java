package com.example.springhomework1.entity;

import com.example.springhomework1.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post extends Timestamped {
    @Id  // 번호수 순서
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title; //제목

    @Column(nullable = false)
    private String username; //작성자

    @Column(nullable = false)
    private String contents; //작성내용
    @Column(nullable = false)
    private String pw; //비밀번호

    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.pw = requestDto.getPw();
    }
    public void update(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.pw = requestDto.getPw();
    }


}
