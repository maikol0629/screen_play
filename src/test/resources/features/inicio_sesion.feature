@Login @Regresion
Feature: Inicio de sesión en BlazeDemo
  Como usuario de la aplicación web BlazeDemo
  Quiero iniciar sesión con mis credenciales
  Para poder acceder a mi cuenta

  Scenario: Inicio de sesión exitoso
    Given que el usuario se encuentra en la pagina de login de blazedemo
    When el ingresa sus credenciales
      | email              | password |
      | test@blazedemo.com | 123456   |
    Then deberia ver el mensaje de confirmacion
