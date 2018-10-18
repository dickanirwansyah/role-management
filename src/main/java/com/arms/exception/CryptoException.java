package com.arms.exception;

public class CryptoException extends RuntimeException {

	private static final long serialVersionUID = 4507977361896475589L;

	public CryptoException(String message) {
		super(message);
	}

	public CryptoException(String message, Throwable e) {
		super(message, e);
	}

}
