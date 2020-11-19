package exseption;

public class NoStudentsException extends Exception {
    private String message;

    public NoStudentsException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
