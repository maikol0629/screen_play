package com.calidad.blazedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

public class SeleccionarOpcion implements Interaction {

    private final Target target;
    private final String textoVisible;

    private SeleccionarOpcion(Target target, String textoVisible) {
        this.target = target;
        this.textoVisible = textoVisible;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectFromOptions.byVisibleText(textoVisible).from(target));
    }

    public static Interaction conTextoVisible(String textoVisible, Target target) {
        return new SeleccionarOpcion(target, textoVisible);
    }
}
