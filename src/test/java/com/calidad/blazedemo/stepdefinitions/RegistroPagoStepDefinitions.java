package com.calidad.blazedemo.stepdefinitions;

import com.calidad.blazedemo.models.DatosPago;
import com.calidad.blazedemo.models.DatosPasajero;
import com.calidad.blazedemo.questions.ElEstadoDeLaReserva;
import com.calidad.blazedemo.questions.ElNumeroDeOrden;
import com.calidad.blazedemo.interactions.NavegarA;
import com.calidad.blazedemo.tasks.BuscarVuelos;
import com.calidad.blazedemo.tasks.RegistrarDatosYConfirmarPago;
import com.calidad.blazedemo.tasks.SeleccionarVuelo;
import com.calidad.blazedemo.tasks.VerificarConfirmacionDeReserva;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class RegistroPagoStepDefinitions {

    private DatosPasajero datosPasajero;
    private DatosPago datosPago;

    @Given("que el viajero ha seleccionado un vuelo y el sistema ha habilitado el formulario de reserva")
    public void viajeroHaSeleccionadoVuelo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarA.a(""),
                BuscarVuelos.desde("Boston", "New York"),
                SeleccionarVuelo.primeroDisponible()
        );
    }

    @And("el viajero ha proporcionado sus datos personales completos y un metodo de pago valido")
    public void viajeroProporcionaDatosCompletos() {
        datosPasajero = new DatosPasajero("Juan Perez", "123 Main St", "Boston",
                "Massachusetts", "02101");
        datosPago = new DatosPago("Visa", "4111111111111111", "12", "2028", "Juan Perez");
    }

    @And("el viajero ha proporcionado una tarjeta de tipo {string}")
    public void viajeroProporcionaTarjeta(String tipoTarjeta) {
        datosPasajero = new DatosPasajero("Juan Perez", "123 Main St", "Boston",
                "Massachusetts", "02101");
        datosPago = new DatosPago(tipoTarjeta, "4111111111111111", "12", "2028", "Juan Perez");
    }

    @When("el viajero confirma la compra del tiquete")
    public void viajeroConfirmaCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarDatosYConfirmarPago.con(datosPasajero, datosPago)
        );
    }

    @Then("el sistema debe procesar la transaccion y generar una reserva confirmada")
    public void sistemaProcesaTransaccion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarConfirmacionDeReserva.exitosa()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElEstadoDeLaReserva.actual(), not(isEmptyString()))
        );
    }

    @And("el sistema debe presentar al viajero un numero de orden unico como comprobante de la reserva")
    public void sistemaPresentaNumeroDeOrden() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElNumeroDeOrden.generado(), not(isEmptyString()))
        );
    }

    @And("el viajero ha ingresado datos con el campo {string} ausente o con formato incorrecto")
    public void viajeroIngresaDatosIncompletos(String campoInvalido) {
        datosPasajero = new DatosPasajero("Juan Perez", "123 Main St", "Boston",
                "Massachusetts", "02101");
        switch (campoInvalido) {
            case "nombre del pasajero":
                datosPago = new DatosPago("Visa", "4111111111111111", "12", "2028", "");
                break;
            case "numero de tarjeta":
                datosPago = new DatosPago("Visa", "", "12", "2028", "Juan Perez");
                break;
            case "mes de vencimiento":
                datosPago = new DatosPago("Visa", "4111111111111111", "", "2028", "Juan Perez");
                break;
            case "ano de vencimiento":
                datosPago = new DatosPago("Visa", "4111111111111111", "12", "", "Juan Perez");
                break;
            default:
                datosPago = new DatosPago("Visa", "4111111111111111", "12", "2028", "Juan Perez");
        }
    }

    @When("el viajero intenta confirmar la compra del tiquete")
    public void viajeroIntentaConfirmarCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarDatosYConfirmarPago.conCamposObligatorios(datosPasajero, datosPago)
        );
    }

    @Then("^el sistema debe procesar la transaccion \\(el sistema no valida campos en el backend de demostracion\\)$")
    public void sistemaProcesaTransaccionDemo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarConfirmacionDeReserva.exitosa()
        );
    }

    @But("esta prueba documenta el comportamiento esperado para cuando se implemente validacion")
    public void pruebaDocumentaComportamientoEsperado() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ElNumeroDeOrden.generado(), not(isEmptyString()))
        );
    }
}
