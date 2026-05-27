package com.calidad.blazedemo.tasks;

import com.calidad.blazedemo.interactions.ClickeaEn;
import com.calidad.blazedemo.interactions.EscribirTexto;
import com.calidad.blazedemo.interactions.EsperarUnMomento;
import com.calidad.blazedemo.interactions.SeleccionarOpcion;
import com.calidad.blazedemo.models.DatosPago;
import com.calidad.blazedemo.models.DatosPasajero;
import com.calidad.blazedemo.userinterfaces.PurchasePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class RegistrarDatosYConfirmarPago {
    private RegistrarDatosYConfirmarPago() {}

    public static Performable con(DatosPasajero pasajero, DatosPago pago) {
        return Task.where("{0} completa el formulario de reserva y confirma la compra",
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_NOMBRE, pasajero.getNombre()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_DIRECCION, pasajero.getDireccion()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_CIUDAD, pasajero.getCiudad()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_ESTADO, pasajero.getEstado()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_CODIGO_POSTAL, pasajero.getCodigoPostal()),
                EsperarUnMomento.segundos(1),
                SeleccionarOpcion.conTextoVisible(pago.getTipoTarjeta(), PurchasePage.SELECT_TIPO_TARJETA),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_NUMERO_TARJETA, pago.getNumeroTarjeta()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_MES_VENCIMIENTO, pago.getMesVencimiento()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_ANIO_VENCIMIENTO, pago.getAnioVencimiento()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_NOMBRE_TITULAR, pago.getNombreTitular()),
                EsperarUnMomento.segundos(1),
                ClickeaEn.elemento(PurchasePage.BOTON_COMPRAR),
                EsperarUnMomento.segundos(2)
        );
    }

    public static Performable conCamposObligatorios(DatosPasajero pasajero, DatosPago pago) {
        return Task.where("{0} completa solo los campos obligatorios del formulario y confirma la compra",
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_NOMBRE, pasajero.getNombre()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_DIRECCION, pasajero.getDireccion()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_CIUDAD, pasajero.getCiudad()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_ESTADO, pasajero.getEstado()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_CODIGO_POSTAL, pasajero.getCodigoPostal()),
                EsperarUnMomento.segundos(1),
                SeleccionarOpcion.conTextoVisible(pago.getTipoTarjeta(), PurchasePage.SELECT_TIPO_TARJETA),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_NUMERO_TARJETA, pago.getNumeroTarjeta()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_MES_VENCIMIENTO, pago.getMesVencimiento()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_ANIO_VENCIMIENTO, pago.getAnioVencimiento()),
                EsperarUnMomento.segundos(1),
                EscribirTexto.enCampo(PurchasePage.INPUT_NOMBRE_TITULAR, pago.getNombreTitular()),
                EsperarUnMomento.segundos(1),
                ClickeaEn.elemento(PurchasePage.BOTON_COMPRAR),
                EsperarUnMomento.segundos(2)
        );
    }
}
