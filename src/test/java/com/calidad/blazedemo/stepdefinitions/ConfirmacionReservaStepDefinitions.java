package com.calidad.blazedemo.stepdefinitions;

import com.calidad.blazedemo.models.DatosPago;
import com.calidad.blazedemo.models.DatosPasajero;
import com.calidad.blazedemo.questions.ElEstadoDeLaReserva;
import com.calidad.blazedemo.questions.ElNumeroDeOrden;
import com.calidad.blazedemo.questions.ElPrecioTotal;
import com.calidad.blazedemo.tasks.BuscarVuelos;
import com.calidad.blazedemo.tasks.RegistrarDatosYConfirmarPago;
import com.calidad.blazedemo.tasks.SeleccionarVuelo;
import com.calidad.blazedemo.tasks.VerificarConfirmacionDeReserva;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class ConfirmacionReservaStepDefinitions {

    @Given("que el viajero ha completado el proceso de pago con datos validos")
    public void viajeroHaCompletadoPago() {
        DatosPasajero datosPasajero = new DatosPasajero("Juan Perez", "123 Main St", "Boston",
                "Massachusetts", "02101");
        DatosPago datosPago = new DatosPago("Visa", "4111111111111111", "12", "2028", "Juan Perez");
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://blazedemo.com/"),
                BuscarVuelos.desde("Boston", "New York"),
                SeleccionarVuelo.primeroDisponible(),
                RegistrarDatosYConfirmarPago.con(datosPasajero, datosPago)
        );
    }

    @And("el sistema ha procesado la transaccion exitosamente")
    public void sistemaHaProcesadoTransaccion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarConfirmacionDeReserva.exitosa()
        );
    }

    @When("el sistema presenta la pantalla de resultado de la transaccion")
    public void sistemaPresentaPantallaResultado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarConfirmacionDeReserva.exitosa()
        );
    }

    @Then("el viajero debe visualizar un numero de orden unico que identifica su reserva")
    public void viajeroVisualizaNumeroDeOrden() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElNumeroDeOrden.generado(), not(isEmptyString()))
        );
    }

    @And("el comprobante debe incluir el precio total cobrado por la reserva")
    public void comprobanteIncluyePrecioTotal() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElPrecioTotal.cobrado(), not(isEmptyString()))
        );
    }

    @And("el estado de la reserva debe indicar que fue confirmada satisfactoriamente")
    public void estadoReservaConfirmada() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElEstadoDeLaReserva.actual(), is("PendingCapture"))
        );
    }
}
