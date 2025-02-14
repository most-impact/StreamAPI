package pro.sky.StreamAPI.exceptions;

public class EmployeeFullStorageException extends RuntimeException{
    public EmployeeFullStorageException(String message) {
        super(message);
    }
}
