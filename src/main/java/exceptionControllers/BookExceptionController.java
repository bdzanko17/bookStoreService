package exceptionControllers;

import com.example.book.exceptions.BookAlreadyExistException;
import com.example.book.exceptions.BookNotFoundException;
import com.example.book.exceptions.NoAuthorsForBookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionController {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> exception(IllegalArgumentException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = BookAlreadyExistException.class)
    public ResponseEntity<Object> exception(BookAlreadyExistException exception){
        return new ResponseEntity<>("Book already exist", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NoAuthorsForBookException.class)
    public ResponseEntity<Object> exception(NoAuthorsForBookException exception){
        return new ResponseEntity<>("No authors for book", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<Object> exception(BookNotFoundException exception){
        return new ResponseEntity<>("Book not exist", HttpStatus.BAD_REQUEST);
    }
}
