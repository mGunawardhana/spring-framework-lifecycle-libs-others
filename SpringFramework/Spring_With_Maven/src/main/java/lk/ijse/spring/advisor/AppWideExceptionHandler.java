package lk.ijse.spring.advisor;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public void handleExceptions(RuntimeException exception) {
        System.out.println(exception.getMessage());
    }

}
