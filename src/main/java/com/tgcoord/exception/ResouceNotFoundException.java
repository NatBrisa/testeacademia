/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.exception;

import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author natal
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    @SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ResouceNotFoundException.class.getName());

	
	/**
     *
     * @param message
     */
    public ResouceNotFoundException(String message) {
        super(message);
    }
}
