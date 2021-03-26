package com.accenture.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.vivaair.com/co/es")
public class VivaAirHome extends PageObject {

    public static final Target SOLO_IDA = Target.the("Checkbox de vuelo solo ida").locatedBy("//span[contains(text(),'Solo ida')]");
    public static final Target ORIGEN = Target.the("Origen").locatedBy("//input[@id='criteria-airport-select-departure-input']");
    public static final Target DESTINO = Target.the("Destino").locatedBy("//input[@id='criteria-airport-select-destination-input']");
    public static final Target CALENDARIO_IDA = Target.the("Calendario vuelo ida").located(By.id("criteria-dates-from"));
    public static final Target BOTON_BUSCAR_VUELO = Target.the("Boton buscar vuelo").locatedBy("//button[@id='criteria-search-button-desktop']");

    public static final Target FECHA = Target.the("Fecha del vuelo").locatedBy("//button[@date='{0}']");


}
