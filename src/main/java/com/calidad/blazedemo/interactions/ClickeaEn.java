package com.calidad.blazedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickeaEn implements Interaction {

    private final Target target;

    private ClickeaEn(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(target));
    }

    public static Interaction elemento(Target target) {
        return new ClickeaEn(target);
    }
}
