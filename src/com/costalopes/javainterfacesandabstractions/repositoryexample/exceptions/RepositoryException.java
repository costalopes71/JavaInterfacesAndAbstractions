package com.costalopes.javainterfacesandabstractions.repositoryexample.exceptions;

public class RepositoryException extends RuntimeException {

	private static final long serialVersionUID = -2776908478000642295L;

	public RepositoryException(final String message, final Throwable cause) {
		
		super(message, cause);
		
	}
	
}
