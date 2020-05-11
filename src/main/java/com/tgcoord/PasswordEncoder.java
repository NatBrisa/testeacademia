/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord;

import java.util.logging.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author natal
 */
public class PasswordEncoder {   
    private static final Logger LOG = Logger.getLogger(PasswordEncoder.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        System.out.println(pwEncoder.encode("TGWeb100!"));
    }   
}
