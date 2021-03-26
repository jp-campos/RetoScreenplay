package com.accenture.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PopUpsReserva extends PageObject {

    public static final Target NO_GRACIAS = Target.the("Opcion no gracias").locatedBy("//span[contains(text(),'No, gracias')]");
    public static final Target  BOTON_CONFIRMAR_NO_GRACIAS = Target.the("Boton confirmar no gracias").locatedBy("//div[@class='vue-dialog-buttons']/button[1]");

}
