package com.calidad.blazedemo.tasks;

import com.calidad.blazedemo.interactions.ClickeaEn;
import com.calidad.blazedemo.interactions.EsperarUnMomento;
import com.calidad.blazedemo.userinterfaces.ReservePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class SeleccionarVuelo {
    private SeleccionarVuelo() {}

    public static Performable primeroDisponible() {
        return Task.where("{0} elige el primer vuelo disponible de la lista de resultados",
                EsperarUnMomento.segundos(1),
                ClickeaEn.elemento(ReservePage.BOTON_ELEGIR_VUELO_POR_POSICION(1)),
                EsperarUnMomento.segundos(2)
        );
    }

    public static Performable porPosicion(int posicion) {
        return Task.where("{0} elige el vuelo en la posicion " + posicion + " de la lista de resultados",
                EsperarUnMomento.segundos(1),
                ClickeaEn.elemento(ReservePage.BOTON_ELEGIR_VUELO_POR_POSICION(posicion)),
                EsperarUnMomento.segundos(2)
        );
    }
}
