package todoapp.helper;

import todoapp.todo.entity.Todo;

import java.util.List;

public class StubData {

    public static class MockTodo {
        public static Todo getSingleResultTodo() {
            Todo todo = new Todo();
            todo.setTitle("공부");
            todo.setTodoOrder(1);
            todo.setCompleted(false);

            return todo;
        }

        public static List<Todo> getMultiResultTodo() {
            Todo todo1 = new Todo();
            todo1.setTitle("공부");
            todo1.setTodoOrder(1);
            todo1.setCompleted(false);

            Todo todo2 = new Todo();
            todo2.setTitle("운동");
            todo2.setTodoOrder(2);
            todo2.setCompleted(false);

            Todo todo3 = new Todo();
            todo3.setTitle("설거지");
            todo3.setTodoOrder(3);
            todo3.setCompleted(true);

            return List.of(todo1, todo2, todo3);
        }

        public static Todo getSingleResponseBody(long todoId) {
            return null;
        }
    }

}
