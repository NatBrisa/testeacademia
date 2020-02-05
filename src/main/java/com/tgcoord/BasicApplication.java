package com.tgcoord;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

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
    public static void main(final String[] args) {
            SpringApplication.run(BasicApplication.class, args);
    }
}
