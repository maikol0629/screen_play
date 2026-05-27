package com.calidad.blazedemo.tasks;

import com.calidad.blazedemo.interactions.ClickeaEn;
import com.calidad.blazedemo.interactions.EjecutarJavaScript;
import com.calidad.blazedemo.interactions.EsperarUnMomento;
import com.calidad.blazedemo.interactions.SeleccionarOpcion;
import com.calidad.blazedemo.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Task;

public class BuscarVuelos {
    private BuscarVuelos() {}

    public static Task desde(String origen, String destino) {
        return Task.where("{0} solicita la consulta de vuelos desde " + origen + " hacia " + destino,
                EsperarUnMomento.segundos(1),
                SeleccionarOpcion.conTextoVisible(origen, HomePage.SELECT_ORIGEN),
                EsperarUnMomento.segundos(1),
                SeleccionarOpcion.conTextoVisible(destino, HomePage.SELECT_DESTINO),
                EsperarUnMomento.segundos(1),
                ClickeaEn.elemento(HomePage.BOTON_BUSCAR),
                EsperarUnMomento.segundos(2)
        );
    }

    public static Task desdeMismaCiudad(String ciudad) {
        return Task.where("{0} solicita vuelos desde " + ciudad + " hacia la misma ciudad",
                EsperarUnMomento.segundos(1),
                SeleccionarOpcion.conTextoVisible(ciudad, HomePage.SELECT_ORIGEN),
                EsperarUnMomento.segundos(1),
                EjecutarJavaScript.con(
                        "arguments[0].value = arguments[1];",
                        HomePage.SELECT_DESTINO,
                        ciudad
                ),
                EsperarUnMomento.segundos(1),
                ClickeaEn.elemento(HomePage.BOTON_BUSCAR),
                EsperarUnMomento.segundos(2)
        );
    }
}
