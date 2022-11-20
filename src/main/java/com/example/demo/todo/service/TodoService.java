package com.example.demo.todo.service;


import com.example.demo.todo.dto.FindAllDTO;
import com.example.demo.todo.entity.ToDo;
import com.example.demo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

// 역할: 컨트롤러와 저장소 사이의 잡일 처리 역할
@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    /*
         - 할 일 목록조회 중간처리
         1. 컨트롤러에게 userId를 뺀 할일 리스트를 전달한다.
         2. 할일 목록의 카운트를 세서 따로 추가해서 전달한다.
     */
    public FindAllDTO findAllServ() {
        return new FindAllDTO(repository.findAll());
    }


    // 목록 생성 service
    public FindAllDTO createServ(final ToDo newTodo) {

        if (newTodo == null) {
            log.warn("newTodo cannot be null!");
            throw new RuntimeException("newTodo cannot be null!");
        }   // 에러 방지 코드 - 안전장치 secure code

        boolean flag = repository.save(newTodo);
        if (flag) log.info("새로운 할일 [Id : {}] 이 저장되었습니다.", newTodo.getId());
        // flag가 true 일때만 저장

        return flag ? findAllServ() : null;
        // flag 가 true 일때만 findAllServ return, false null return.
    }


    //목록 삭제하기 service
    public FindAllDTO deleteServ(long id) {
        boolean flag = repository.remove(id);

        // !flag = flag가 false 라면
        if (!flag) {
            log.warn("delete fail!! not found id {}", id);
            throw new RuntimeException("delete fail!");
        }
        return findAllServ();
    }


    // 목록 하나만 찾기 service
    public FindAllDTO findOneServ(int number) {
        return new FindAllDTO((List<ToDo>) repository.findOne(number));
    }
}

