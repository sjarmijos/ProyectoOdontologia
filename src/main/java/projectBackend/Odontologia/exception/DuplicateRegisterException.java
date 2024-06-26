package projectBackend.Odontologia.exception;

public class DuplicateRegisterException extends RuntimeException{
    public DuplicateRegisterException(String message) {
        super(message);
    }
}
