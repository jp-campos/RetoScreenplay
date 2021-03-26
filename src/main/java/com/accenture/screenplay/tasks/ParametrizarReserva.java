package com.accenture.screenplay.tasks;

import com.accenture.screenplay.interactions.NegarSwitches;
import com.accenture.screenplay.userinterface.ListaVuelos;
import com.accenture.screenplay.userinterface.PopUpsReserva;
import com.accenture.screenplay.userinterface.ResumenReserva;
import com.accenture.screenplay.util.VueloHelper;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;


public class ParametrizarReserva implements Task {

    private ListaVuelos listaVuelos;
    private PopUpsReserva popUpsReserva;
    private ResumenReserva resumenReserva;


    public ParametrizarReserva(ListaVuelos listaVuelos, PopUpsReserva popUpsReserva, ResumenReserva resumenReserva){
        this.popUpsReserva = popUpsReserva;
        this.listaVuelos = listaVuelos;
        this.resumenReserva = resumenReserva;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        Map<WebElementFacade,Integer> par = vueloMasBarato();
        WebElementFacade vueloMasBarato = (WebElementFacade) par.keySet().toArray()[0];
        Integer precioMasBarato = par.get(vueloMasBarato);

        actor.remember("precioMasBarato", precioMasBarato);

        actor.attemptsTo(
                Click.on(vueloMasBarato),
                Click.on(ListaVuelos.A_LA_CARTA),
                JavaScriptClick.on(ListaVuelos.CONTINUAR)

        );
        actor.attemptsTo(
                WaitUntil.the(popUpsReserva.NO_GRACIAS, WebElementStateMatchers.isClickable()),
                JavaScriptClick.on(popUpsReserva.NO_GRACIAS),
                Click.on(PopUpsReserva.BOTON_CONFIRMAR_NO_GRACIAS),
                JavaScriptClick.on(PopUpsReserva.NO_GRACIAS),
                WaitUntil.the(ResumenReserva.CHECK_BOX, WebElementStateMatchers.isClickable()),
                JavaScriptClick.on(ResumenReserva.CHECK_BOX),
                new NegarSwitches(resumenReserva.switches())

        );
    }

    public static ParametrizarReserva masBarata(ListaVuelos listaVuelos, PopUpsReserva popUpsReserva, ResumenReserva resumenReserva){
        return Tasks.instrumented(ParametrizarReserva.class, listaVuelos, popUpsReserva, resumenReserva);
    }

    private  Map<WebElementFacade,Integer> vueloMasBarato(){
        List<WebElementFacade> vuelos= listaVuelos.getVuelos();

        Map<WebElementFacade,Integer> par = VueloHelper.vueloMenorPrecio(vuelos);
        WebElementFacade el = (WebElementFacade) par.keySet().toArray()[0];
        return  par;

    }

}
