package com.example.demo.todo.service;

import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

// 역할 : 컨트롤러와 저장소 사이의 잡 일 처리
@Service
@Slf4j
@RequiredArgsConstructor    // final 초기화 , allargs - final 아닌것 전부 초기화, noargs 빈칸생성자
public class TodoService {
    private final TodoRepository repository;
    /*
        -할 일 목록조회 중간처리
        1. 컨트롤러에게 userId를 뺀 할 일 리스트를 전달한다.
        2. 할 일 목록의 카운트를 세서 따로 추가해서 전달한다.
     */
    public void findAllServ(){
        List<ToDo> toDoList = repository.findAll();  // 그대로 보내면 민감한 정보가 포함되어있다.

    }

}
