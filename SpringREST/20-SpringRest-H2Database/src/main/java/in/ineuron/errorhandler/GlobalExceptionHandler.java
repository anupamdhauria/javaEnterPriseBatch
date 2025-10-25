package in.ineuron.errorhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.error.ErrorDetails;
import in.ineuron.exception.StudentRecordNotFoundException;
import in.ineuron.model.Student;

@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentRecordNotFoundException.class)
	public ResponseEntity<ErrorDetails>handleRecordNotFoundException(StudentRecordNotFoundException se){
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDateTime.now(), se.getMessage(), "Record Not found"), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>handleAllException(Exception e){
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
