package com.accenture.screenplay.util;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VueloHelper {

    public static Map<WebElementFacade,Integer> vueloMenorPrecio(List<WebElementFacade> vuelos){
        WebElementFacade minVuelo = null;
        int minVal = Integer.MAX_VALUE;

        for (WebElementFacade e:vuelos) {
            int precioActual = PrecioHelper.parsePrecioVuelo(e.getText());

            if(precioActual < minVal){
                minVal = precioActual;
                minVuelo = e;
            }
        }
        Map<WebElementFacade,Integer> mapa = new HashMap<>();
        mapa.put(minVuelo, minVal);
        return mapa;
    }

}
