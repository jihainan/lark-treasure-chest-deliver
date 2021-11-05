package com.kit.deliver.exception;

import com.kit.deliver.dto.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @ClassName CustomResponseEntityExceptionHandler
 * @Description custom response entity exception handler
 * @Author jihainan
 * @Date 2021/11/5 2:57 上午
 * @Version 1.0
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.EntityNotFoundException.class)
    public final ResponseEntity<Response<String>> handleNotFountExceptions(Exception ex, WebRequest request) {
        Response<String> response = Response.notFound();
        response.addErrorMsgToResponse(ex.getMessage(), ex);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomException.DuplicateEntityException.class)
    public final ResponseEntity<Response<String>> handleNotFountExceptions1(Exception ex, WebRequest request) {
        Response<String> response = Response.duplicateEntity();
        response.addErrorMsgToResponse(ex.getMessage(), ex);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
