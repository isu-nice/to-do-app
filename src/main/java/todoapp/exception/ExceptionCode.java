package todoapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ExceptionCode {
    TODO_EXISTS(409, "Todo title exists"),
    TODO_NOT_FOUND(404, "Todo not found");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
