package com.example.demo.todo.dto;

import lombok.*;

// 수많은 정보 중 보여주고 싶은 정보만 보여준다.(entity 패키지의 ToDo와 다른점)

@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
public class TodoDto {

    private long id;
    private String title;
    private boolean done;
}
