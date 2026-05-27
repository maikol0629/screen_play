package com.calidad.blazedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class EsperarQue implements Interaction {

    private final Target target;

    private EsperarQue(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(target, WebElementStateMatchers.isVisible()));
    }

    public static Interaction elementoSeaVisible(Target target) {
        return new EsperarQue(target);
    }
}
