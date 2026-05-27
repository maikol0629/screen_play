package com.calidad.blazedemo.tasks;

import com.calidad.blazedemo.interactions.EsperarQue;
import com.calidad.blazedemo.interactions.EsperarUnMomento;
import com.calidad.blazedemo.userinterfaces.ConfirmationPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class VerificarConfirmacionDeReserva {
    private VerificarConfirmacionDeReserva() {}

    public static Performable exitosa() {
        return Task.where("{0} verifica que el sistema presenta la confirmacion de la reserva",
                EsperarUnMomento.segundos(2),
                EsperarQue.elementoSeaVisible(ConfirmationPage.TITULO_CONFIRMACION),
                EsperarUnMomento.segundos(1)
        );
    }
}
