package in.ineuron.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.Exception.TouristNotFoundException;
import in.ineuron.error.ErrorDetails;

@RestControllerAdvice
public class TouristErrorControllerAdvice {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails>handleTouristNotFound(TouristNotFoundException tf){
		System.out.println("TouristErrorControllerAdvice.handleTouristNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), tf.getMessage(), "404-NotFound");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>handleTouristNotFound(Exception e){
		System.out.println("TouristErrorControllerAdvice.handleTouristNotFound()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "problem occured");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
