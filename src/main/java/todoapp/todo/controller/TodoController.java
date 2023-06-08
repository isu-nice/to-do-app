package todoapp.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import todoapp.todo.dto.TodoDto;
import todoapp.todo.entity.Todo;
import todoapp.todo.mapper.TodoMapper;
import todoapp.todo.service.TodoService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@CrossOrigin
@RestController
//@RequestMapping("/")
@Validated
@Slf4j
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    // 테스트용
    @GetMapping("/test")
    public String helloTodo() {
        return "Test OK";
    }

    // 할 일 목록 등록
    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoDto.Post requestBody) {
        Todo todo = mapper.todoPostDtoToTodo(requestBody);
        Todo createdTodo = todoService.createTodo(todo);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(createdTodo),
                HttpStatus.CREATED);
    }

    // 할 일의 내용 수정 (+ 한 일에 완료 표시)
    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(
            @PathVariable("todo-id") @Positive long todoId,
            @Valid @RequestBody TodoDto.Patch requestBody
    ) {
        requestBody.setId(todoId);

        Todo todo = mapper.todoPatchDtoToTodo(requestBody);
        Todo updatedTodo = todoService.updateTodo(todo);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(updatedTodo),
                HttpStatus.OK);
    }

    // 특정 할 일을 id를 입력하여 조회
    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") long todoId) {
        Todo todo = todoService.findTodo(todoId);
        TodoDto.Response response = mapper.todoToTodoResponseDto(todo);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 전체 할 일 목록 조회
    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> todos = todoService.findAllTodos();
        List<TodoDto.Response> response = mapper.todosToTodoResponseDtos(todos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 특정 할 일을 id를 입력하여 삭제
    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") long todoId) {
        todoService.deleteTodo(todoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 전체 할 일 삭제
    @DeleteMapping
    public ResponseEntity deleteAllTodos() {
        todoService.deleteAllTodos();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
