package todoapp.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TodoDto {
    @AllArgsConstructor
    @Getter
    public static class Post {
        @NotBlank(message = "할 일의 내용은 100자 미만이어야 합니다.")
        private String title;

        @Positive
        private int todoOrder;

        @NotNull
        @AssertFalse
        private boolean completed;
    }

    @AllArgsConstructor
    @Getter
    public static class Patch {
        private long id;

        @NotBlank(message = "할 일의 내용은 100자 미만이어야 합니다.")
        private String title;

        @Range(min = 1)
        private int todoOrder;

        @NotNull
        private boolean completed;
    }

    @AllArgsConstructor
    @Getter
    public static class Response {
        private long id;
        private String title;
        private int todoOrder;
        private boolean completed;
    }
}
