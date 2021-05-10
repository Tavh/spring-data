package com.lab.springdata.errors.exceptions;

import lombok.Data;

@Data
public class LibraryCustomException extends Exception {
	public LibraryCustomException(String message) {
		super(message);
	}
}
