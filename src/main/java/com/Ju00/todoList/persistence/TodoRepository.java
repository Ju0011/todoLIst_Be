package com.Ju00.todoList.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.TodoEntity;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String>{
    List<TodoEntity> findByUserId(String userId);
}

// 스프링 데이터가 JPA 메서드 이름을 파싱해서 select * from todorepository WHERE userId = '{userId}' 쿼리 작성해 실행