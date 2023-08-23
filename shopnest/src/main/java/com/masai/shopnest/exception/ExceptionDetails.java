package com.masai.shopnest.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDetails {
	private LocalDateTime timestamp;
	private String msg;
	private String uri;
}
