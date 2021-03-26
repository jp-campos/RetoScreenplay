Feature: Hacer una reserva en Viva Air
  Como un turista
  Quiero hacer una reserva para un vuelo
  Para poder viajar

  Scenario: Hacer la  reserva más barata para mañana entre Bogota - Medellin
    Given Tulio esta navegando por el internet
    When Reserva el vuelo mas barato entre Bogota y Medellin
    Then El valor inicial del vuelo deberia ser el mismo al final de la transaccion