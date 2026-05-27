package com.calidad.blazedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmationPage {
    public static final Target TITULO_CONFIRMACION = Target.the("Titulo de confirmacion de compra")
            .located(By.xpath("//h1[contains(text(),'Thank you for your purchase')]"));

    public static final Target TEXTO_ID_ORDEN = Target.the("Texto del identificador de la orden")
            .located(By.xpath("//td[text()='Id']/following-sibling::td"));

    public static final Target TEXTO_ESTADO = Target.the("Texto del estado de la reserva")
            .located(By.xpath("//td[text()='Status']/following-sibling::td"));

    public static final Target TEXTO_MONTO = Target.the("Texto del monto total cobrado")
            .located(By.xpath("//td[text()='Amount']/following-sibling::td"));

    private ConfirmationPage() {}
}
