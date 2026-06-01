@Pago @Regresion
Feature: Registro de Datos del Pasajero y Metodo de Pago
  Como viajero que ha seleccionado un vuelo
  Quiero proporcionar mis datos personales y de pago
  Para formalizar la reserva y que el sistema pueda procesar la transaccion

  Scenario: Registro exitoso con datos completos y validos
    Given que el viajero ha seleccionado un vuelo y el sistema ha habilitado el formulario de reserva
    And el viajero ha proporcionado sus datos personales completos y un metodo de pago valido
    When el viajero confirma la compra del tiquete
    Then el sistema debe procesar la transaccion y generar una reserva confirmada
    And el sistema debe presentar al viajero un numero de orden unico como comprobante de la reserva

  Scenario Outline: Registro exitoso con diferentes tipos de tarjeta
    Given que el viajero ha seleccionado un vuelo y el sistema ha habilitado el formulario de reserva
    And el viajero ha proporcionado una tarjeta de tipo "<tipo_tarjeta>"
    When el viajero confirma la compra del tiquete
    Then el sistema debe procesar la transaccion y generar una reserva confirmada
    And el sistema debe presentar al viajero un numero de orden unico como comprobante de la reserva

    Examples:
      | tipo_tarjeta       |
      | Visa               |
      | American Express   |
      | Diner's Club       |

  Scenario Outline: Intento de reserva con datos de pago incompletos
    Given que el viajero ha seleccionado un vuelo y el sistema ha habilitado el formulario de reserva
    And el viajero ha ingresado datos con el campo <campo_invalido> ausente o con formato incorrecto
    When el viajero intenta confirmar la compra del tiquete
    Then el sistema debe procesar la transaccion (el sistema no valida campos en el backend de demostracion)
    But esta prueba documenta el comportamiento esperado para cuando se implemente validacion

    Examples:
      | campo_invalido            |
      | "nombre del pasajero"     |
      | "numero de tarjeta"       |
      | "mes de vencimiento"      |
      | "ano de vencimiento"      |
