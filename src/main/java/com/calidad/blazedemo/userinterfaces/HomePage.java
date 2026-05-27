package com.calidad.blazedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target SELECT_ORIGEN = Target.the("Selector de ciudad de origen")
            .located(By.name("fromPort"));
    public static final Target SELECT_DESTINO = Target.the("Selector de ciudad de destino")
            .located(By.name("toPort"));
    public static final Target BOTON_BUSCAR = Target.the("Boton de busqueda de vuelos")
            .located(By.xpath("//input[@value='Find Flights']"));

    private HomePage() {}
}
