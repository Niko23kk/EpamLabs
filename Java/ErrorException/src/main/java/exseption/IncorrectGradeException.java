package exseption;

public class IncorrectGradeException extends Exception {
    private String message;
    private int value;

    public IncorrectGradeException(String message, int value){
        super(message);
        this.message = message;
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message + "; incorrect value is " + value;
    }
}
