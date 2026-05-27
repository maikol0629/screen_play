package com.calidad.blazedemo.questions;

import com.calidad.blazedemo.userinterfaces.ReservePage;
import net.serenitybdd.screenplay.Question;

public class LosVuelosDisponibles {
    private LosVuelosDisponibles() {}

    public static Question<Boolean> sonVisibles() {
        return actor -> ReservePage.TABLA_VUELOS.resolveFor(actor).isVisible();
    }

    public static Question<Integer> cantidad() {
        return actor -> ReservePage.FILAS_VUELOS.resolveAllFor(actor).size();
    }

    public static Question<Boolean> noHayVuelos() {
        return actor -> ReservePage.FILAS_VUELOS.resolveAllFor(actor).isEmpty();
    }
}
