package com.calidad.blazedemo.tasks;

import com.calidad.blazedemo.interactions.ClickeaEn;
import com.calidad.blazedemo.interactions.EscribirTexto;
import com.calidad.blazedemo.interactions.EsperarQue;
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
                EsperarQue.elementoSeaVisible(PurchasePage.INPUT_NOMBRE),
                EscribirTexto.enCampo(PurchasePage.INPUT_NOMBRE, pasajero.getNombre()),
                EscribirTexto.enCampo(PurchasePage.INPUT_DIRECCION, pasajero.getDireccion()),
                EscribirTexto.enCampo(PurchasePage.INPUT_CIUDAD, pasajero.getCiudad()),
                EscribirTexto.enCampo(PurchasePage.INPUT_ESTADO, pasajero.getEstado()),
                EscribirTexto.enCampo(PurchasePage.INPUT_CODIGO_POSTAL, pasajero.getCodigoPostal()),
                EsperarQue.elementoSeaVisible(PurchasePage.SELECT_TIPO_TARJETA),
                SeleccionarOpcion.conTextoVisible(pago.getTipoTarjeta(), PurchasePage.SELECT_TIPO_TARJETA),
                EscribirTexto.enCampo(PurchasePage.INPUT_NUMERO_TARJETA, pago.getNumeroTarjeta()),
                EscribirTexto.enCampo(PurchasePage.INPUT_MES_VENCIMIENTO, pago.getMesVencimiento()),
                EscribirTexto.enCampo(PurchasePage.INPUT_ANIO_VENCIMIENTO, pago.getAnioVencimiento()),
                EscribirTexto.enCampo(PurchasePage.INPUT_NOMBRE_TITULAR, pago.getNombreTitular()),
                ClickeaEn.elemento(PurchasePage.BOTON_COMPRAR)
        );
    }

    public static Performable conCamposObligatorios(DatosPasajero pasajero, DatosPago pago) {
        return Task.where("{0} completa solo los campos obligatorios del formulario y confirma la compra",
                EsperarQue.elementoSeaVisible(PurchasePage.INPUT_NOMBRE),
                EscribirTexto.enCampo(PurchasePage.INPUT_NOMBRE, pasajero.getNombre()),
                EscribirTexto.enCampo(PurchasePage.INPUT_DIRECCION, pasajero.getDireccion()),
                EscribirTexto.enCampo(PurchasePage.INPUT_CIUDAD, pasajero.getCiudad()),
                EscribirTexto.enCampo(PurchasePage.INPUT_ESTADO, pasajero.getEstado()),
                EscribirTexto.enCampo(PurchasePage.INPUT_CODIGO_POSTAL, pasajero.getCodigoPostal()),
                EsperarQue.elementoSeaVisible(PurchasePage.SELECT_TIPO_TARJETA),
                SeleccionarOpcion.conTextoVisible(pago.getTipoTarjeta(), PurchasePage.SELECT_TIPO_TARJETA),
                EscribirTexto.enCampo(PurchasePage.INPUT_NUMERO_TARJETA, pago.getNumeroTarjeta()),
                EscribirTexto.enCampo(PurchasePage.INPUT_MES_VENCIMIENTO, pago.getMesVencimiento()),
                EscribirTexto.enCampo(PurchasePage.INPUT_ANIO_VENCIMIENTO, pago.getAnioVencimiento()),
                EscribirTexto.enCampo(PurchasePage.INPUT_NOMBRE_TITULAR, pago.getNombreTitular()),
                ClickeaEn.elemento(PurchasePage.BOTON_COMPRAR)
        );
    }
}
