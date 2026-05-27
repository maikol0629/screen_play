Feature: Confirmacion de la Reserva
  Como viajero que ha completado el proceso de compra
  Quiero recibir una confirmacion explicita de mi reserva con un identificador unico
  Para tener evidencia de que mi trayecto fue registrado exitosamente en el sistema

  Scenario: Visualizacion del comprobante de reserva exitosa
    Given que el viajero ha completado el proceso de pago con datos validos
    And el sistema ha procesado la transaccion exitosamente
    When el sistema presenta la pantalla de resultado de la transaccion
    Then el viajero debe visualizar un numero de orden unico que identifica su reserva
    And el comprobante debe incluir el precio total cobrado por la reserva
    And el estado de la reserva debe indicar que fue confirmada satisfactoriamente
