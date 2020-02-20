package com.digital.ing.product.exception;



public class ResourceNotFoundException extends RuntimeException {

	/**
	 * Default serialID
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}
}
