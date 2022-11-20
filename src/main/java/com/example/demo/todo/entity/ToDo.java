package com.example.demo.todo.entity;

import lombok.*;

// DB에 들어가는 데이터, 민감한 정보도 다 있어야한다. -> 저장할때 쓰는 것이다. (TodoDto와 다른점.)

@Setter @Getter @ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 전체 필드 초기화 생성자
// 역할: 하나의 할 일 데이터의 집합 객체
public class ToDo {

    private long id; // 할일들을 식별하는 번호
    private String userId; // 할 일을 등록한 회원의 식별자
    private String title; // 할 일 내용
    private boolean done; // 할 일 완료 여부

    // ToDo에서 dto가 필요한 필드를 빼오는 생성자
    public TodoDto(ToDo toDo){
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.done = toDo.isDone();
    }

}
