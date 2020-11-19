package exseption;

public class NoFacultiesException extends Exception{
    private String message;

    public NoFacultiesException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
