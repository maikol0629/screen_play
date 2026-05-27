package com.calidad.blazedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Open;

public class NavegarA implements Interaction {

    private final String url;

    private NavegarA(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static Interaction laUrl(String url) {
        return new NavegarA(url);
    }
}
