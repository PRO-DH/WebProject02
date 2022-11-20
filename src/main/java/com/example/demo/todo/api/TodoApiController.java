package com.example.demo.todo.api;

import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/todos")
@RequiredArgsConstructor    // 필요한 것 주입안해도 자동으로 가져온다.
public class TodoApiController {

    private final TodoRepository repository;

    // 할 일 목록 전체조회 요청
    @GetMapping
    public List<ToDo> todos() {
        log.info("/api/todos GET request!");

        return repository.findAll();
    }
}