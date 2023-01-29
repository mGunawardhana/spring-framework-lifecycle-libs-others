package lk.ijse.spring.advisor;


import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseUtil handleExceptions(RuntimeException exception) {
        return new ResponseUtil("Error", exception.getMessage(), null);
    }

}
