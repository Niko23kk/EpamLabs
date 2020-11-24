package exseption;

public class NoGroupsException extends Exception {
    private String message;

    public NoGroupsException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
