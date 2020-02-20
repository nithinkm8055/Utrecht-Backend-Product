package com.digital.ing.product.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Build the response for Exception.
	 * <p>
	 * The implementation that creates the response object.
	 *
	 * @param apiError the model object
	 * @return a {@code ResponseEntity} instance
	 */
	@ExceptionHandler({
			ApiException.class
	})
	public ResponseEntity<Object> handle(ApiException apiException) {
		return new ResponseEntity<>(new ApiError(apiException.getStatus(),apiException.getMessage(),apiException.getErrors()), apiException.getStatus());
	}
}
