package com.accenture.screenplay.tasks;

import com.accenture.screenplay.interactions.SeleccionarFechaIda;
import com.accenture.screenplay.model.Vuelo;
import com.accenture.screenplay.userinterface.VivaAirHome;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class BuscarVuelo implements Task {

    private final Vuelo vuelo;

    public BuscarVuelo(Vuelo vuelo){
        this.vuelo = vuelo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(VivaAirHome.SOLO_IDA),
                Enter.theValue(vuelo.getOrigen() +"\n").into(VivaAirHome.ORIGEN),
                Enter.theValue(vuelo.getDestino() + "\n").into(VivaAirHome.DESTINO),
                SeleccionarFechaIda.en(vuelo.getFechaIda()),
                Click.on(VivaAirHome.BOTON_BUSCAR_VUELO)
        );
    }

    public static BuscarVuelo de(Vuelo vuelo){
        return Tasks.instrumented(BuscarVuelo.class, vuelo);
    }


}
