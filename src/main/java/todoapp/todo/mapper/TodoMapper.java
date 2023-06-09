package todoapp.todo.mapper;

import org.mapstruct.Mapper;
import todoapp.todo.dto.TodoDto;
import todoapp.todo.entity.Todo;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoPostDtoToTodo(TodoDto.Post requestBody);

    Todo todoPatchDtoToTodo(TodoDto.Patch requestBody);

    TodoDto.Response todoToTodoResponseDto(Todo todo);

    List<TodoDto.Response> todosToTodoResponseDtos(List<Todo> todos);
}
