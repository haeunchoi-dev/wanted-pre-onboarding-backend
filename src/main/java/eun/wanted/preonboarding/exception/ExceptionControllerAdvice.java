package eun.wanted.preonboarding.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ExceptionResponse> globalRequestException(
        final GlobalException globalException) {

        return ResponseEntity.badRequest().body(
            new ExceptionResponse(globalException.getMessage(), globalException.getErrorCode()));
    }

    @Getter
    @AllArgsConstructor
    public static class ExceptionResponse {
        private String message;
        private String errorCode;
    }
}