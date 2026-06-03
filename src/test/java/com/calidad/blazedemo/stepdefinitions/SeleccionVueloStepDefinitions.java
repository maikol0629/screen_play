package com.calidad.blazedemo.stepdefinitions;

import com.calidad.blazedemo.interactions.NavegarA;
import com.calidad.blazedemo.questions.ElPrecioDelVuelo;
import com.calidad.blazedemo.questions.LaAerolineaDelVuelo;
import com.calidad.blazedemo.tasks.BuscarVuelos;
import com.calidad.blazedemo.tasks.SeleccionarVuelo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class SeleccionVueloStepDefinitions {

    @Given("que el viajero ha consultado la disponibilidad de vuelos y el sistema ha presentado los resultados")
    public void viajeroHaConsultadoDisponibilidad() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarA.a(""),
                BuscarVuelos.desde("Boston", "New York")
        );
    }

    @When("el viajero elige uno de los vuelos disponibles en la lista de resultados")
    public void viajeroEligeUnVuelo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarVuelo.primeroDisponible()
        );
    }

    @Then("el sistema debe habilitar el proceso de reserva para ese vuelo especifico")
    public void sistemaHabilitaProcesoReserva() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LaAerolineaDelVuelo.enFormulario(), not(isEmptyString()))
        );
    }

    @And("^el sistema debe reflejar los datos del vuelo seleccionado \\(aerolinea, precio\\) en el formulario de reserva$")
    public void sistemaReflejaDatosVuelo() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LaAerolineaDelVuelo.enFormulario(), containsString("Airline:")),
                seeThat(ElPrecioDelVuelo.enFormulario(), containsString("Price:"))
        );
    }
}
