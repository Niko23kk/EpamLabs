package exseption;

public class NoDisciplinesException extends Exception {
    private String message;

    public NoDisciplinesException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
