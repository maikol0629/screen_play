package com.calidad.blazedemo.questions;

import com.calidad.blazedemo.userinterfaces.PurchasePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ElPrecioDelVuelo {
    private ElPrecioDelVuelo() {}

    public static Question<String> enFormulario() {
        return Text.of(PurchasePage.TEXTO_PRECIO);
    }
}
