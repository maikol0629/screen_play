Feature: Busqueda de Vuelos Disponibles
  Como viajero que desea planificar un trayecto
  Quiero consultar los vuelos disponibles entre dos ciudades
  Para poder evaluar mis opciones antes de tomar una decision de compra

  Scenario Outline: Busqueda exitosa de vuelos entre ciudades con disponibilidad
    Given que el viajero se encuentra en el portal de la agencia de viajes
    And ha indicado "<origen>" como ciudad de origen y "<destino>" como ciudad de destino
    When el viajero solicita la consulta de vuelos disponibles
    Then el sistema debe presentar al menos un vuelo con aerolinea, numero de vuelo y precio estimado
    And el resultado debe corresponder al par de ciudades origen-destino seleccionado

    Examples:
      | origen        | destino          |
      | Boston        | New York         |
      | Paris         | Rome             |
      | San Diego     | London           |
      | Mexico City   | Buenos Aires     |
      | Philadelphia  | Dublin           |
      | Portland      | Cairo            |
      | São Paolo     | Berlin           |

  Scenario: Consulta con ciudades de origen y destino identicas
    Given que el viajero se encuentra en el portal de la agencia de viajes
    And ha indicado la misma ciudad tanto para el origen como para el destino
    When el viajero solicita la consulta de vuelos disponibles
    Then el sistema debe presentar los vuelos disponibles para ese trayecto
    