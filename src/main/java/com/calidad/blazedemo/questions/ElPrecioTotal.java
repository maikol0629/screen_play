package com.calidad.blazedemo.questions;

import com.calidad.blazedemo.userinterfaces.ConfirmationPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ElPrecioTotal {
    private ElPrecioTotal() {}

    public static Question<String> cobrado() {
        return Text.of(ConfirmationPage.TEXTO_MONTO);
    }
}
