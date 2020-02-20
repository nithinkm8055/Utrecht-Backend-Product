package com.digital.ing.product.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler {

	/**
	 * Build the response for Exception.
	 * <p>
	 * The implementation that creates the response object.
	 * 
	 * @param apiError the model object
	 * @return a {@code ResponseEntity} instance
	 */
	private ResponseEntity<Object> buildResponseEntity(ExceptionResponse exceptionResponse, HttpStatus status) {
		return new ResponseEntity<>(exceptionResponse, status);
	}

	/**
	 * This method handles generic exceptions.
	 * 
	 * @param exception
	 * @param request
	 * @return a ResponseEntity instance containing the error response
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(final ResourceNotFoundException ex,
			final HttpServletRequest request) {
		return buildResponseEntity(new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getRequestURI()),
				HttpStatus.NOT_FOUND);
	}

	/**
	 * This method handles custom exceptions.
	 * 
	 * @param exception
	 * @param request
	 * @return a ResponseEntity instance containing the error response
	 */
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleCustomException(final CustomException ex, final HttpServletRequest request) {
		return buildResponseEntity(new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getRequestURI()),
				ex.getHttpStatus());
	}

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleException(MethodArgumentNotValidException manve) {
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setDetail("validation failed");
		errorDetail.setTimeStamp(new Date());
		errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDetail.setDeveloperMessage(manve.getClass().getName());
		errorDetail.setTitle("Input validation failed");

		// Create ValidationError instances
		List<FieldError> errorField = manve.getBindingResult().getFieldErrors();
		for (FieldError fe : errorField) {
			List<ValidationError> validationErrorList = errorDetail.getErrors().get(fe.getField());
			if (validationErrorList == null) {
				validationErrorList = new ArrayList<ValidationError>();
				errorDetail.getErrors().put(fe.getField(), validationErrorList);
			}
			ValidationError validationError = new ValidationError();
			validationError.setCode(fe.getCode());
			validationError.setMessage(fe.getDefaultMessage());
			validationErrorList.add(validationError);
		}
		return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
	}

	/**
	 * This method handles generic exceptions.
	 * 
	 * @param exception
	 * @param request
	 * @return a ResponseEntity instance containing the error response
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(final Exception ex, final HttpServletRequest request) {
		return buildResponseEntity(new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getRequestURI()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
