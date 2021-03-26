package com.accenture.screenplay.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaHelper {


    public static String fechaManiana(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now.plusDays(1));
    }

}
