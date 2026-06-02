package com.calidad.blazedemo.tasks;

import com.calidad.blazedemo.interactions.ClickeaEn;
import com.calidad.blazedemo.interactions.EjecutarJavaScript;
import com.calidad.blazedemo.interactions.EsperarQue;
import com.calidad.blazedemo.interactions.SeleccionarOpcion;
import com.calidad.blazedemo.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Task;

public class BuscarVuelos {
    private BuscarVuelos() {}

    public static Task desde(String origen, String destino) {
        return Task.where("{0} solicita la consulta de vuelos desde " + origen + " hacia " + destino,
                EsperarQue.elementoSeaVisible(HomePage.SELECT_ORIGEN),
                SeleccionarOpcion.conTextoVisible(origen, HomePage.SELECT_ORIGEN),
                EsperarQue.elementoSeaVisible(HomePage.SELECT_DESTINO),
                SeleccionarOpcion.conTextoVisible(destino, HomePage.SELECT_DESTINO),
                ClickeaEn.elemento(HomePage.BOTON_BUSCAR)
        );
    }

    public static Task desdeMismaCiudad(String ciudad) {
        return Task.where("{0} solicita vuelos desde " + ciudad + " hacia la misma ciudad",
                EsperarQue.elementoSeaVisible(HomePage.SELECT_ORIGEN),
                SeleccionarOpcion.conTextoVisible(ciudad, HomePage.SELECT_ORIGEN),
                EjecutarJavaScript.con(
                        "arguments[0].value = arguments[1];",
                        HomePage.SELECT_DESTINO,
                        ciudad
                ),
                ClickeaEn.elemento(HomePage.BOTON_BUSCAR)
        );
    }
}
