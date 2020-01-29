package com.tgcoord;


import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author natal
 */
@SpringBootApplication
public class BasicApplication {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(BasicApplication.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}
}
