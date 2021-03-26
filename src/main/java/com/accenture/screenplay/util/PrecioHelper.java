package com.accenture.screenplay.util;

public class PrecioHelper {

    public static int parsePrecioVuelo(String texto){
        return Integer.parseInt(texto.split(" ")[1].replace(",",""));
    }
    public static int parsePrecioVueloResumen(String texto){
        return Integer.parseInt(texto.split(" ")[2].replace(",",""));
    }

}
