package com.calidad.blazedemo.stepdefinitions;

import com.calidad.blazedemo.questions.ElMensajeDeLogueo;
import com.calidad.blazedemo.tasks.IniciarSesion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

public class InicioSesionStepDefinitions {

    @Given("que el usuario se encuentra en la pagina de login de blazedemo")
    public void queElUsuarioSeEncuentraEnLaPaginaDeLoginDeBlazedemo() {
        OnStage.theActorCalled("Usuario").wasAbleTo(
                Open.url("https://blazedemo.com/login")
        );
    }

    @When("el ingresa sus credenciales")
    public void elIngresaSusCredenciales(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String email = data.get(0).get("email");
        String password = data.get(0).get("password");

        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesion.conCredenciales(email, password)
        );
    }

    @Then("deberia ver el mensaje de confirmacion")
    public void deberiaVerElMensajeDeConfirmacion() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ElMensajeDeLogueo.es(), Matchers.containsString("You are logged in!"))
        );
    }
}
