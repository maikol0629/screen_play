package com.calidad.blazedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class EjecutarJavaScript implements Interaction {

    private final String script;
    private final Target target;
    private final String argumento;

    private EjecutarJavaScript(String script, Target target, String argumento) {
        this.script = script;
        this.target = target;
        this.argumento = argumento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement elemento = target.resolveFor(actor);
        ((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver())
                .executeScript(script, elemento, argumento);
    }

    public static Interaction con(String script, Target target, String argumento) {
        return new EjecutarJavaScript(script, target, argumento);
    }
}
