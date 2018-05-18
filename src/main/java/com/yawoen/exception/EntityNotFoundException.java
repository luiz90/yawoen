package com.yawoen.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3101356914907089705L;
	
	public EntityNotFoundException(String message)
    {
        super(message);
    }

}
