package com.example.springhomework1.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 이 클래스의 변수인 createdDate와 modifiedDate도 칼럼으로 인식하게한다.
@EntityListeners(AuditingEntityListener.class)
//BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
public class Timestamped {

    @CreatedDate
    //Entity가 생성되면, createdDate에 저장 시간이 자동으로 저장된다.
    private LocalDateTime createdAt;

    @LastModifiedDate
    //조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    private LocalDateTime modifiedAt;
}
