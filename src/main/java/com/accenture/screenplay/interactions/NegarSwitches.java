package com.accenture.screenplay.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

public class NegarSwitches implements Interaction {

    List<WebElementFacade> switches;

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (WebElementFacade e:switches) {
            actor.attemptsTo(Click.on(e));
        }

    }

    public NegarSwitches(List<WebElementFacade> switches){
        this.switches = switches;
    }

}
