package rocketseat.com.passin.dto.event.exceptions;

public class EventFullException extends RuntimeException{
    public EventFullException(String message){
        super(message);
    }
}
