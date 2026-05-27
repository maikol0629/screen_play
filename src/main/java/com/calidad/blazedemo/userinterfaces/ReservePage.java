package com.calidad.blazedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ReservePage {
    public static final Target TABLA_VUELOS = Target.the("Tabla de resultados de vuelos")
            .located(By.cssSelector("table.table"));

    public static final Target FILAS_VUELOS = Target.the("Filas de vuelos disponibles")
            .located(By.cssSelector("table.table tbody tr"));

    public static final Target BOTON_ELEGIR_VUELO_POR_POSICION(int posicion) {
        return Target.the("Boton elegir vuelo en posicion " + posicion)
                .located(By.xpath("(//input[@value='Choose This Flight'])[" + posicion + "]"));
    }

    private ReservePage() {}
}
