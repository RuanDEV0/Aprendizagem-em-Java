package academy.devdojo.springbootessentials.handler;

import academy.devdojo.springbootessentials.exception.BadRequestException;
import academy.devdojo.springbootessentials.exception.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadResquestException(BadRequestException badRequestException){
        return new ResponseEntity<>(BadRequestExceptionDetails.builder()
                .details(badRequestException.getMessage())
                .developerMessage(badRequestException.getClass().getName())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception, Check the Documentation")
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }
}