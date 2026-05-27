package com.calidad.blazedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class EscribirTexto implements Interaction {

    private final Target target;
    private final String valor;

    private EscribirTexto(Target target, String valor) {
        this.target = target;
        this.valor = valor;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(valor).into(target));
    }

    public static Interaction enCampo(Target target, String valor) {
        return new EscribirTexto(target, valor);
    }
}
