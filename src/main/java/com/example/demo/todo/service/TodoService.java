package com.example.demo.todo.service;

import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.dto.TodoDto;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public FindAllDTO findAllServ(){
        List<ToDo> toDoList = repository.findAll();  // 그대로 보내면 민감한 정보가 포함되어있다.
        //데이터베이스 가서 요구사항 다 가져옴

        FindAllDTO findAllDTO = new FindAllDTO();
        findAllDTO.setCount(toDoList.size());
        //카운트 있는 곳에서 할일목록 받아옴
        List<TodoDto> dtos = new ArrayList<>();
        //할일 목록을 유저아이디를 뺴고 세팅해야되서 새로운 리스트 생성
        for (ToDo todo : toDoList) {
            TodoDto dto = new TodoDto();
            dto.setId(todo.getId());
            dto.setTitle(todo.getTitle());
            dto.setDone(todo.isDone());
            //toDo들 중에 유저 아이디만 뺴고 전부 dto에 실엇다.

            dtos.add(dto);
            //유저 아이디가 빠진 모든 정보를 dtos에 추가한다.
        }
        findAllDTO.setTodos(dtos);
        return findAllDTO;
        //findAllDTO를 리턴한다.

        // 더러운 코드. 클린하지 못하다.

    }

}
