package com.calidad.blazedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PurchasePage {
    public static final Target INPUT_NOMBRE = Target.the("Campo de nombre del pasajero")
            .located(By.id("inputName"));
    public static final Target INPUT_DIRECCION = Target.the("Campo de direccion")
            .located(By.id("address"));
    public static final Target INPUT_CIUDAD = Target.the("Campo de ciudad")
            .located(By.id("city"));
    public static final Target INPUT_ESTADO = Target.the("Campo de estado")
            .located(By.id("state"));
    public static final Target INPUT_CODIGO_POSTAL = Target.the("Campo de codigo postal")
            .located(By.id("zipCode"));
    public static final Target SELECT_TIPO_TARJETA = Target.the("Selector de tipo de tarjeta")
            .located(By.id("cardType"));
    public static final Target INPUT_NUMERO_TARJETA = Target.the("Campo de numero de tarjeta")
            .located(By.id("creditCardNumber"));
    public static final Target INPUT_MES_VENCIMIENTO = Target.the("Campo de mes de vencimiento")
            .located(By.id("creditCardMonth"));
    public static final Target INPUT_ANIO_VENCIMIENTO = Target.the("Campo de anio de vencimiento")
            .located(By.id("creditCardYear"));
    public static final Target INPUT_NOMBRE_TITULAR = Target.the("Campo de nombre del titular")
            .located(By.id("nameOnCard"));
    public static final Target BOTON_COMPRAR = Target.the("Boton de compra del tiquete")
            .located(By.xpath("//input[@value='Purchase Flight']"));

    public static final Target TEXTO_AEROLINEA = Target.the("Texto de la aerolinea seleccionada")
            .located(By.xpath("//p[contains(.,'Airline:')]"));
    public static final Target TEXTO_NUMERO_VUELO = Target.the("Texto del numero de vuelo")
            .located(By.xpath("//p[contains(.,'Flight Number:')]"));
    public static final Target TEXTO_PRECIO = Target.the("Texto del precio del vuelo")
            .located(By.xpath("//p[contains(.,'Price:')]"));
    public static final Target TEXTO_COSTO_TOTAL = Target.the("Texto del costo total")
            .located(By.xpath("//p[contains(.,'Total Cost:')]"));

    private PurchasePage() {}
}
