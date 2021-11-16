package com.qa.demo.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Map Not Found")
public class MapNotFoundException extends EntityNotFoundException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MapNotFoundException() {
		// TODO Auto-generated constructor stub
	}

}
