package com.accenture.screenplay.questions;

import com.accenture.screenplay.userinterface.ResumenReserva;
import com.accenture.screenplay.util.PrecioHelper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("El precio inicial es igual al de la confirmación de la reserva")
public class ElPrecioFinal implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        Integer precioAnterior = actor.recall("precioMasBarato");
        String precioTexto = ResumenReserva.PRECIO_FINAL.resolveFor(actor).getText();
        return PrecioHelper.parsePrecioVueloResumen(precioTexto);

    }

    public static Question<Integer> valor(){
        return new ElPrecioFinal();
    }
}
