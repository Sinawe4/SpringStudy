package com.example.TodoList.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    public TodoResponse(TodoModel todoModel){
        this.id = todoModel.getId();
        this.title = todoModel.getTitle();
        this.order = todoModel.getOrder();
        this.completed = todoModel.getCompleted();

        this.url = "http://localhost:8080/" + this.id; //절대 좋은 코드는 아니지만 연습용의 편의를 위해 썼습니다. (보통은 config나 property로 해야함)
    }

}
