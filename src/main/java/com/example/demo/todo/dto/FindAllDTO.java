package com.example.demo.todo.dto;

import lombok.*;

import java.util.List;

// 전체목록을 보여줄 때 필요한 데이터만 보여준다. (userId를 빼고)

@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
public class FindAllDTO {

    private int count; // 할 일 목록의 갯수
    private List<TodoDto> todos; // userId가 빠진 할 일 목록
}
