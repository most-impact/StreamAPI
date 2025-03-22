package pro.sky.StreamAPI.exceptions;

public class ExistingEmployeeException extends RuntimeException{
    public ExistingEmployeeException(String message) {
        super(message);
    }
}
