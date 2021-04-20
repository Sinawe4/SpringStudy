package com.example.TodoList.service;


import com.example.TodoList.model.TodoModel;
import com.example.TodoList.model.TodoRequest;
import com.example.TodoList.service.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoModel add(TodoRequest request){
         TodoModel todoModel = new TodoModel();
         todoModel.setTitle(request.getTitle());
         todoModel.setOrder(request.getOrder());
         todoModel.setCompleted((request.getCompleted()));
         return this.todoRepository.save(todoModel);
    }

    public TodoModel searchById(Long id){
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoModel> searchAll(){
        return this.todoRepository.findAll();
    }

    public TodoModel updateById(Long id, TodoRequest request){
        TodoModel todoModel = this.searchById(id);
        if (request.getTitle() != null)
            todoModel.setTitle(request.getTitle());

        if (request.getOrder() != null)
            todoModel.setOrder(request.getOrder());

        if (request.getCompleted() != null)
            todoModel.setCompleted(request.getCompleted());

        return this.todoRepository.save(todoModel);
    }

    public void delectByid(long id){
        this.todoRepository.deleteById(id);
    }

    public void deleteByAll(){
        this.todoRepository.deleteAll();
    }
}
