package todoapp.todo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import todoapp.exception.BusinessLogicException;
import todoapp.helper.StubData;
import todoapp.todo.entity.Todo;
import todoapp.todo.repository.TodoRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {
    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;


    @Test
    @DisplayName("할 일 생성 테스트")
    void createTodo() {
        /*Todo todo = StubData.MockTodo.getSingleResultTodo();

        given(todoRepository.findByTitle(Mockito.anyString()))
                .willReturn(Optional.of(todo));

        assertThrows(BusinessLogicException.class,
                () -> todoService.createTodo(todo));*/
    }

    // TODO mock 테스트 연습
    @Test
    @DisplayName("할 일 수정 테스트")
    void updateTodo() {
    }

    @Test
    @DisplayName("할 일 탐색 테스트")
    void findTodo() {
    }

    @Test
    @DisplayName("모든 할 일 조회 테스트")
    void findAllTodos() {
    }

    @Test
    @DisplayName("할 일 삭제 테스트")
    void deleteTodo() {
    }

    @Test
    @DisplayName("모든 할 일 삭제 테스트")
    void deleteAllTodos() {
    }
}