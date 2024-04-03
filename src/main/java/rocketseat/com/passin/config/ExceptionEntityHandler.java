package rocketseat.com.passin.config;

import com.sun.tools.attach.AttachNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.com.passin.domain.attendee.exceptions.AttendeeAlreadyRegisteredException;
import rocketseat.com.passin.domain.attendee.exceptions.AttendeeNotFoundException;
import rocketseat.com.passin.domain.checkin.exceptions.CheckedInAlreadyExistsException;
import rocketseat.com.passin.domain.event.exceptions.EventNotFoundException;
import rocketseat.com.passin.dto.event.exceptions.EventFullException;
import rocketseat.com.passin.dto.general.ErrorResponseDTO;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException eventNotFoundException){
        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(EventFullException.class)
    public ResponseEntity<ErrorResponseDTO> handleEventFull(EventFullException eventFullException){
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(eventFullException.getMessage()));
    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException attendeeNotFoundException){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeAlreadyRegisteredException.class)
    public ResponseEntity handleAttendeeAlreadyExists(AttendeeAlreadyRegisteredException attendeeAlreadyRegisteredException){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckedInAlreadyExistsException.class)
    public ResponseEntity handleCheckInAlreadyExists(CheckedInAlreadyExistsException checkedInAlreadyExistsException){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
