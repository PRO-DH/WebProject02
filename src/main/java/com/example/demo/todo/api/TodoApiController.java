package com.example.demo.todo.api;

import com.example.demo.todo.entity.ToDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/todos")
public class TodoApiController {

    // 할 일 목록 전체조회 요청
    @GetMapping
    public List<ToDo> todos(){
        log.info("/api/todos GET request!");
    }
}
