package com.calidad.blazedemo.tasks;

import com.calidad.blazedemo.interactions.ClickeaEn;
import com.calidad.blazedemo.interactions.EsperarQue;
import com.calidad.blazedemo.userinterfaces.ReservePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class SeleccionarVuelo {
    private SeleccionarVuelo() {}

    public static Performable primeroDisponible() {
        return Task.where("{0} elige el primer vuelo disponible de la lista de resultados",
                EsperarQue.elementoSeaVisible(ReservePage.BOTON_ELEGIR_VUELO_POR_POSICION(1)),
                ClickeaEn.elemento(ReservePage.BOTON_ELEGIR_VUELO_POR_POSICION(1))
        );
    }

}