package model.response.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    OK(2000, HttpStatus.OK, "OK"),
    BAD_REQUEST(4000, HttpStatus.BAD_REQUEST, "잘못된 파라미터");

    ErrorCode(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    private final int code;
    private final HttpStatus httpStatus;
    @Getter
    private final String message;


}
