package com.lab.springdata.errors.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LibraryCustomException extends Exception {
	public LibraryCustomException(String message) {
		super(message);
	}
}
