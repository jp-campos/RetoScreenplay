package com.accenture.screenplay.stepdefinitions;

import com.accenture.screenplay.model.VueloBuilder;
import com.accenture.screenplay.questions.ElPrecioFinal;
import com.accenture.screenplay.tasks.BuscarVuelo;
import com.accenture.screenplay.tasks.ParametrizarReserva;
import com.accenture.screenplay.userinterface.ListaVuelos;
import com.accenture.screenplay.userinterface.PopUpsReserva;
import com.accenture.screenplay.userinterface.ResumenReserva;
import com.accenture.screenplay.userinterface.VivaAirHome;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

public class ReservarVueloStepDefinitions {

    private VivaAirHome vivaAirPage;
    private Actor actor = Actor.named("Tulio");

    @Managed(driver = "chrome")
    private WebDriver driver;

    @Given("^Tulio esta navegando por el internet$")
    public void TulioEstaNavegandoPorElInternet() {
        actor.can(BrowseTheWeb.with(driver));
        actor.wasAbleTo(Open.browserOn(vivaAirPage));

    }

    @When("^Reserva el vuelo mas barato entre Bogota y Medellin$")
    public void makeReservation() {
        actor.attemptsTo(BuscarVuelo
                .de(VueloBuilder.desde("Medellin").hacia("Bogota").soloIda().idaElDiaDeManiana().conPasajeros(1)),
                ParametrizarReserva.masBarata(new ListaVuelos(), new PopUpsReserva(), new ResumenReserva())

        );
    }

    @Then("^El valor inicial del vuelo deberia ser el mismo al final de la transaccion$")
    public void sameReservationPrice() {
        int precioOriginal = actor.recall("precioMasBarato");
        actor.should(seeThat(ElPrecioFinal.valor(), is(precioOriginal)));
    }


}
