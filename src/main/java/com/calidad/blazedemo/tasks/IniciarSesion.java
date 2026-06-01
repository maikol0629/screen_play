package com.calidad.blazedemo.tasks;

import com.calidad.blazedemo.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IniciarSesion implements Task {

    private final String email;
    private final String password;

    public IniciarSesion(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static IniciarSesion conCredenciales(String email, String password) {
        return Tasks.instrumented(IniciarSesion.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(LoginPage.INPUT_EMAIL),
                Enter.theValue(password).into(LoginPage.INPUT_PASSWORD),
                Click.on(LoginPage.BUTTON_LOGIN)
        );
    }
}
