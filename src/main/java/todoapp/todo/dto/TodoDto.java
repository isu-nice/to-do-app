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
//        @NotBlank(message = "할 일의 내용은 100자 미만이어야 합니다.")
        private String title;

//        @Positive(message = "할 일의 순위는 1이상인 숫자여야 합니다.")
        private int todoOrder;

        @NotNull
//        @AssertFalse(message = "등록할 때는 미완료(false) 상태여야 합니다.")
        private boolean completed;
    }

    @AllArgsConstructor
    @Getter
    public static class Patch {
        private long id;

//        @NotBlank(message = "할 일의 내용은 100자 미만이어야 합니다.")
        private String title;

//        @Range(min = 1)
        private int todoOrder;

//        @NotNull
        private boolean completed;

        public void setId(long todoId) {
            this.id = todoId;
        }
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
