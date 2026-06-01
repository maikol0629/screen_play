package com.calidad.blazedemo.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target INPUT_EMAIL = Target.the("campo de correo electrónico")
            .located(By.id("email"));

    public static final Target INPUT_PASSWORD = Target.the("campo de contraseña")
            .located(By.id("password"));

    public static final Target BUTTON_LOGIN = Target.the("botón de inicio de sesión")
            .located(By.cssSelector("button[type='submit']"));

    // Después de un login exitoso, suele haber un elemento que indica que estamos logueados, 
    // como un panel o un mensaje "You are logged in!" en /home
    public static final Target MENSAJE_BIENVENIDA = Target.the("mensaje de inicio de sesión exitoso")
            .located(By.cssSelector(".panel-body"));
}
