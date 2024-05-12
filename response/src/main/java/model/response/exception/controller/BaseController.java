package model.response.exception.controller;

import jakarta.servlet.http.HttpServletResponse;
import model.response.ApiResponse;
import model.response.entity.Student;
import model.response.exception.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

abstract public class BaseController {

    @ExceptionHandler(CustomException.class)
    public <T> ApiResponse<T> customExceptionHandle(
            HttpServletResponse response, CustomException customException) {
        response.setStatus(customException.getErrorCode().getHttpStatus().value());

        return new ApiResponse<T>(
                customException.getErrorCode().getCode(),
                customException.getMessage(),
                customException.getData()
        );
    }

    public <T> ApiResponse<T> makeApiResponse(List<T> results) {
        return new ApiResponse<>(results);
    }

    public <T> ApiResponse<T> makeApiResponse(T result) {
        return new ApiResponse<>(result);
    }
}
