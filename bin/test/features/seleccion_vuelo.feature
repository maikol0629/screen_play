Feature: Seleccion de un Vuelo de la Lista de Resultados
  Como viajero que ya consulto la disponibilidad
  Quiero elegir un vuelo especifico de la lista de resultados
  Para continuar con el proceso de reserva de ese trayecto

  Scenario: Seleccion exitosa de un vuelo de la lista de resultados
    Given que el viajero ha consultado la disponibilidad de vuelos y el sistema ha presentado los resultados
    When el viajero elige uno de los vuelos disponibles en la lista de resultados
    Then el sistema debe habilitar el proceso de reserva para ese vuelo especifico
    And el sistema debe reflejar los datos del vuelo seleccionado (aerolinea, precio) en el formulario de reserva
