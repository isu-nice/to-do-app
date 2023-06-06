package todoapp.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todoapp.todo.dto.TodoDto;
import todoapp.todo.entity.Todo;
import todoapp.todo.mapper.TodoMapper;
import todoapp.todo.service.TodoService;
import todoapp.utils.UriCreator;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/")
@Validated
@Slf4j
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    // 할 일 목록 등록
    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoDto.Post requestBody) {
        Todo todo = mapper.todoPostDtoToTodo(requestBody);

        Todo createdTodo = todoService.createTodo(todo);

        URI location =
                UriCreator.createUri("", createdTodo.getId());

        return ResponseEntity.created(location).build();
    }

    // 한 일에 완료 표시

    // 할 일의 내용 수정

    // 특정 할 일을 id를 입력하여 조회

    // 전체 할 일 목록 조회

    // 특정 할 일을 id를 입력하여 삭제

    // 전체 할 일 삭제
}
