package com.accenture.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

import java.util.List;

public class ListaVuelos extends PageObject {

    public final static Target A_LA_CARTA = Target.the("Continuar a la carta").locatedBy("//div[contains(text(),'Comprar A la carta')]");
    public final static Target CONTINUAR = Target.the("Continuar con combo seleccionado").locatedBy("//span[contains(text(),'Continuar')]");


    public List<WebElementFacade> getVuelos(){
        return findAll("//div[@class='from-price']");
    }
}
