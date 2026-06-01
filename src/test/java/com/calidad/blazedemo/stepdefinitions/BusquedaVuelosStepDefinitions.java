package com.calidad.blazedemo.stepdefinitions;

import com.calidad.blazedemo.questions.LosVuelosDisponibles;
import com.calidad.blazedemo.tasks.BuscarVuelos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class BusquedaVuelosStepDefinitions {

    @Given("que el viajero se encuentra en el portal de la agencia de viajes")
    public void elViajeroEstaEnElPortal() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://blazedemo.com/")
        );
    }

    @And("ha indicado {string} como ciudad de origen y {string} como ciudad de destino")
    public void indicaOrigenYDestino(String origen, String destino) {
        OnStage.theActorInTheSpotlight().remember("origen", origen);
        OnStage.theActorInTheSpotlight().remember("destino", destino);
    }

    @And("ha indicado la misma ciudad tanto para el origen como para el destino")
    public void indicaMismaCiudad() {
        OnStage.theActorInTheSpotlight().remember("origen", "Boston");
        OnStage.theActorInTheSpotlight().remember("destino", "Boston");
    }

    @When("el viajero solicita la consulta de vuelos disponibles")
    public void solicitaConsultaDeVuelos() {
        String origen = OnStage.theActorInTheSpotlight().recall("origen");
        String destino = OnStage.theActorInTheSpotlight().recall("destino");
        if (origen.equals(destino)) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    BuscarVuelos.desdeMismaCiudad(origen)
            );
        } else {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    BuscarVuelos.desde(origen, destino)
            );
        }
    }

    @Then("el sistema debe presentar al menos un vuelo con aerolinea, numero de vuelo y precio estimado")
    public void sistemaPresentaVuelos() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LosVuelosDisponibles.cantidad(), greaterThan(0))
        );
    }

    @And("el resultado debe corresponder al par de ciudades origen-destino seleccionado")
    public void resultadoCorrespondeAParCiudades() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LosVuelosDisponibles.sonVisibles(), is(true))
        );
    }

    @Then("el sistema debe presentar los vuelos disponibles para ese trayecto")
    public void sistemaPresentaVuelosMismaCiudad() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LosVuelosDisponibles.sonVisibles(), is(true))
        );
    }
}
