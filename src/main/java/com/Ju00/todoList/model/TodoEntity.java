package com.Ju00.todoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Todo")   // 데이터베이스에 Todo테이블에 매핑
public class TodoEntity {
    @Id
    @GeneratedValue(generator="system-uuid")    // id 자동생성
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;      // 이 오브젝트의 아이디
    private String userId;  // 이 오브젝트를 생성한 사용자의 아이디
    private String title;   // Todo 타이틀
    private boolean done;   // true - todo 를 완료한 경우 checked
}