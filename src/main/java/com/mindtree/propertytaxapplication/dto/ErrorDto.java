package com.mindtree.propertytaxapplication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDto {

	private String errorMessage;

	private Throwable cause;

	public ErrorDto(String errorMessage, Throwable cause) {
		this.errorMessage = errorMessage;
		this.cause = cause;
	}

}
