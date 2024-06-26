package projectBackend.Odontologia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> tratamiendoResourceNotFoundException(ResourceNotFoundException rnfe){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" mensaje: "+rnfe.getMessage());
    }

    @ExceptionHandler({FailCreationException.class})
    public ResponseEntity<String> tratamiendoFailCreationException(FailCreationException fce){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" mensaje: "+fce.getMessage());
    }

    @ExceptionHandler({DuplicateRegisterException.class})
    public ResponseEntity<String> tratamiendoDuplicateRegisterException(DuplicateRegisterException dre){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" mensaje: "+dre.getMessage());
    }
}
