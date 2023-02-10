package com.example.springhomework1.repository;

import com.example.springhomework1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
    // AtDesc()는 내림차순이다. 가장 최근의 값이 위로 올라가게 한다.
}
