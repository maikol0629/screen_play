package com.calidad.blazedemo.questions;

import com.calidad.blazedemo.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ElMensajeDeLogueo implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.MENSAJE_BIENVENIDA).answeredBy(actor);
    }

    public static ElMensajeDeLogueo es() {
        return new ElMensajeDeLogueo();
    }
}
