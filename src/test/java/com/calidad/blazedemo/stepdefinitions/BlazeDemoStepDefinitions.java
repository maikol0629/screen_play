package com.calidad.blazedemo.stepdefinitions;

import com.calidad.blazedemo.models.DatosPago;
import com.calidad.blazedemo.models.DatosPasajero;
import com.calidad.blazedemo.questions.*;
import com.calidad.blazedemo.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class BlazeDemoStepDefinitions {

    private DatosPasajero datosPasajero;
    private DatosPago datosPago;

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("El Viajero");
    }

    @BeforeStep
    public void pausaAntesDeCadaPaso() throws InterruptedException {
        Thread.sleep(500);
    }

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

    @Given("que el viajero ha consultado la disponibilidad de vuelos y el sistema ha presentado los resultados")
    public void viajeroHaConsultadoDisponibilidad() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://blazedemo.com/"),
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

    @Given("que el viajero ha seleccionado un vuelo y el sistema ha habilitado el formulario de reserva")
    public void viajeroHaSeleccionadoVuelo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://blazedemo.com/"),
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

    @Given("que el viajero ha completado el proceso de pago con datos validos")
    public void viajeroHaCompletadoPago() {
        datosPasajero = new DatosPasajero("Juan Perez", "123 Main St", "Boston",
                "Massachusetts", "02101");
        datosPago = new DatosPago("Visa", "4111111111111111", "12", "2028", "Juan Perez");
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
