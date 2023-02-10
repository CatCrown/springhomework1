package com.example.springhomework1.service;

import com.example.springhomework1.dto.PostRequestDto;
import com.example.springhomework1.entity.Post;
import com.example.springhomework1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post createPost(PostRequestDto requestDto){
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }
    @Transactional(readOnly = true)
    public List<Post> getPosts(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional(readOnly = true) // 선택된 글 조회
    public List<Post> getPost(Long id) {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다. ")
        );
        if(!post.getPw().equals(requestDto.getPw())){
            throw new IllegalArgumentException(("비밀번호가 틀렸습니다."));
        }
        post.update(requestDto);
        return post.getId();
    }
    @Transactional
    public Long deletePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다. ")
        );
        if(!post.getPw().equals(requestDto.getPw())){
            throw new IllegalArgumentException(("비밀번호가 틀렸습니다."));
        }
        postRepository.deleteById(id);
        return id;
    }



}
