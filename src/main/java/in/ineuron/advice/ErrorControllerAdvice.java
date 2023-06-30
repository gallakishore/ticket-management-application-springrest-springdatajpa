package in.ineuron.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.error.ErrorDetails;
import in.ineuron.exception.TouristNotFoundException;

@RestControllerAdvice
public class ErrorControllerAdvice {

	@ExceptionHandler(TouristNotFoundException.class)
	private ResponseEntity<ErrorDetails> handlerTouristNotFound(TouristNotFoundException errorMsg) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), errorMsg.getMessage(), "404 status");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	private ResponseEntity<ErrorDetails> handlingAllError(Exception e) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "500 status");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
