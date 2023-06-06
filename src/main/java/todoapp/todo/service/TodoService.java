package todoapp.todo.service;

import org.springframework.stereotype.Service;
import todoapp.exception.BusinessLogicException;
import todoapp.exception.ExceptionCode;
import todoapp.todo.entity.Todo;
import todoapp.todo.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 투두 목록 등록
    public Todo createTodo(Todo todo) {
        // 이미 등록된 할 일인지 검증
        verifyExistTodo(todo.getTitle());

        Todo savedTodo = todoRepository.save(todo);

        return savedTodo;
    }

    // 할 일의 내용 수정 (+ 한 일 완료 체크)
    public Todo updateTodo(Todo todo) {
        Todo findTodo = findVerifiedTodo(todo.getId());

        Optional.ofNullable(todo.getTitle())
                .ifPresent(findTodo::setTitle);
        Optional.ofNullable(todo.getTodoOrder())
                .ifPresent(findTodo::setTodoOrder);
        Optional.ofNullable(todo.getCompleted())
                .ifPresent(findTodo::setCompleted);

        return todoRepository.save(findTodo);
    }

    // 등록되어있는 할일의 특정 id 입력하여 조회
    public Todo findTodo(long todoId) {
        return findVerifiedTodo(todoId);
    }

    // 등록된 전체 할일 목록 조회
    public List<Todo> findAllTodos() {
        List<Todo> todos = new ArrayList<>();

        todoRepository.findAll()
                .forEach(todos::add);

        return todos;
    }

    // 등록된 특정 할 일 id 입력하여 삭제
    public void deleteTodo(long todoId) {
        Todo todo = findVerifiedTodo(todoId);
        todoRepository.delete(todo);
    }

    // 등록된 전체 할 일 삭제
    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

    // 존재하는 투두인 지 확인
    private Todo findVerifiedTodo(long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);

        Todo findTodo =
                optionalTodo.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));
        return findTodo;
    }

    // 이미 등록된 할 일인지 검증
    private void verifyExistTodo(String title) {
        Optional<Todo> todo = todoRepository.findByTitle(title);

        if (todo.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.TODO_EXISTS);
        }
    }

}
