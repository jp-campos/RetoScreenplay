package com.accenture.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;

public class ResumenReserva extends PageObject {

    public final static Target CHECK_BOX = Target.the("Checkbox").locatedBy("//div[@class='chubb-single-offer']/label/span[@class='box']");
    public final static Target PRECIO_FINAL = Target.the("Precio final").locatedBy("//span[@class='price']");

    public List<WebElementFacade> switches(){
        return findAll(By.xpath("//label[@class='switch']"));
    }




}
