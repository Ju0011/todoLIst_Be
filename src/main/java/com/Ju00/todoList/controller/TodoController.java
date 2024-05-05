package com.Ju00.todoList.controller;

import com.Ju00.todoList.dto.ResponseDTO;
import com.Ju00.todoList.dto.TodoDTO;
import com.Ju00.todoList.model.TodoEntity;
import com.Ju00.todoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired  // 알아서 빈을 찾아, 그 빈을 이 인스턴스 멤버 변수에 연결
    // TodoController를 초기화할때 알아서 TodoService를 초기화 또는 검색해 TodoController에 주입
    private TodoService service;

    @GetMapping("/test")
    public ResponseEntity<?> testTodo() {
        String str = service.testService(); // 테스트 서비스 사용
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // ResponseEntity.ok(response) 를 사용해도 상관 없음
        return ResponseEntity.ok().body(response);
    }
}