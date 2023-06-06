package todoapp.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class TodoDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        @NotBlank(message = "할 일의 내용은 100자 미만이어야 합니다.")
        private String title;

        @NotBlank(message = "우선 순위는 1이상이어야 합니다.")
        private int todoOrder;

        @NotBlank
        private boolean completed;
    }

    @AllArgsConstructor
    @Getter
    public static class Patch {
        private long todoId;

        @NotBlank(message = "할 일의 내용은 100자 미만이어야 합니다.")
        private String title;

        @NotBlank(message = "우선 순위는 1이상이어야 합니다.")
        private int todoOrder;

        @NotBlank
        private boolean completed;
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private long todoId;
        private String title;
        private int todoOrder;
        private boolean completed;
    }
}
