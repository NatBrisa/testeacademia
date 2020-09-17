package com.tgcoord;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.logging.Logger;

/**
 * @author natalia
 */
@SpringBootApplication
@EnableTransactionManagement
public class BasicApplication extends SpringBootServletInitializer {

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger.getLogger(BasicApplication.class.getName());

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//       return application.sources(BasicApplication.class);
//    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }
}
