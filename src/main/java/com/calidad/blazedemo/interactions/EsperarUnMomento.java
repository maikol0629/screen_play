package com.calidad.blazedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class EsperarUnMomento implements Interaction {

    private final int segundos;

    private EsperarUnMomento(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static Interaction segundos(int segundos) {
        return new EsperarUnMomento(segundos);
    }
}
