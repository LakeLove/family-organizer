package io.github.lakelove.familyorganizer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class FamilyOrganizerExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleException(Exception e) {
		log.error("Exception: " + e);
		return ResponseEntity.internalServerError().body(e.getMessage());
	}

}