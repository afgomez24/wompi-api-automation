Feature: API de Transacciones Wompi

  Scenario: Transacción exitosa con PSE
    Given que tengo datos de pago válidos
    When creo una transacción con PSE
    Then el código de respuesta debe ser 422

  Scenario: Transacción con monto inválido
    Given que tengo datos de pago válidos
    When envío una transacción con monto 0
    Then el código de respuesta debe ser 422

  Scenario: Transacción sin autenticación
    Given que tengo datos de pago válidos
    When envío la solicitud sin autenticación
    Then el código de respuesta debe ser 401
