package com.accenture.screenplay.interactions;

import com.accenture.screenplay.userinterface.VivaAirHome;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JSClickOnElement;
import net.serenitybdd.screenplay.actions.JSClickOnTarget;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

public class SeleccionarFechaIda implements Interaction {
    String fechaIda;

    public SeleccionarFechaIda(String fecha){
        this.fechaIda = fecha;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(VivaAirHome.CALENDARIO_IDA),
                JavaScriptClick.on(VivaAirHome.FECHA.of(fechaIda))
                );

    }

    public static SeleccionarFechaIda en(String fechaIda){
        return new SeleccionarFechaIda(fechaIda);

    }
}
