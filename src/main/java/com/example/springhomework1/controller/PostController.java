package com.example.springhomework1.controller;

import com.example.springhomework1.dto.PostRequestDto;
import com.example.springhomework1.entity.Post;
import com.example.springhomework1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("index");
    }
    @GetMapping("/api/posts")
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    //선택된 게시글 조회
    @GetMapping("api/posts/{id}")
    public List<Post> getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        return postService.createPost(requestDto);
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.updatePost(id,requestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.deletePost(id,requestDto);
    }
}
