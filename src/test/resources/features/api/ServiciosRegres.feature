@api
Feature: Verificacion de servicios rest en Regres.in
  Yo como usuario deseo verificiar los servicios de regres


  @CPAPI01
  Scenario Outline: : Obtener lista de usuarios con parámetro de página válido
    Given que se obtiene la lista de usuarios con la página <pagina>
    When se envía la solicitud para obtener la lista de usuarios
    And debería devolver el código de estado 200
    And el cuerpo de la respuesta debería tener la página <pagina>
    Then validar el esquema JSON de la lista de usuarios
    Examples:
      | pagina |
      | 1      |
      | 2      |

  @CPAPI02
  Scenario Outline: : Publicar crear nuevo usuario con JSON válido
    Given que se publica crear usuario con JSON válido
    When se envía la solicitud para crear un usuario
    And debería devolver el código de estado 201
    And el cuerpo de la respuesta debería tener el nombre "<nombre>" y el trabajo "<trabajo>"
    Then validar el esquema JSON para crear usuario
    Examples:
      | nombre         | trabajo     |
      | Suci Nascaisar | QA Engineer |

  @CPAPI02
  Scenario Outline: Actualizar usuario con JSON válido
    Given que se actualiza un usuario con JSON válido con el ID 2
    When se envía la solicitud para actualizar el usuario
    And debería devolver el código de estado 200
    And el cuerpo de la respuesta debería tener el nombre "<nombre>" y el trabajo "<trabajo>"
    Then validar el esquema JSON de actualización de usuario
    Examples:
      | nombre         | trabajo         |
      | Suci Nascaisar | QA Engineer |