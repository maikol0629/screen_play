package com.calidad.blazedemo.questions;

import com.calidad.blazedemo.userinterfaces.ConfirmationPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ElEstadoDeLaReserva {
    private ElEstadoDeLaReserva() {}

    public static Question<String> actual() {
        return Text.of(ConfirmationPage.TEXTO_ESTADO);
    }
}
