/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetoetec.academia.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author natal
 */
public class DateFormatter {
    
    public static LocalDate toLocalDateFormat(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/y");
        LocalDate localDate = LocalDate.parse(data, formatter);
        return localDate;
    }
}
