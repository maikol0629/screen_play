package com.calidad.blazedemo.questions;

import com.calidad.blazedemo.userinterfaces.ConfirmationPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ElNumeroDeOrden {
    private ElNumeroDeOrden() {}

    public static Question<String> generado() {
        return Text.of(ConfirmationPage.TEXTO_ID_ORDEN);
    }
}
