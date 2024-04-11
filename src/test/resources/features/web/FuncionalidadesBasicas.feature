@web
Feature: Funcionalidades Básicas
  Yo como usuario
  necesito ingresar a la pagina principal
  y hacer uso de ella.

  @CPW01
  Scenario: Validacion de pagina de inicio
    When que el usuario ingresa a la pagina principal
    Then valida que la web funciona correctamente

  @CPW02
  Scenario Outline: Verificacion de navegador sidebar
    Given que el usuario ingresa a la pagina principal
    When valida que la web funciona correctamente
    And ingresa a la pagina documentacion
    And selecciona un articulo del navegador "<articulo>"
    Then Verifica que la redireccion a la pagina "<articulo>" funciona correctamente
    Examples:
      | articulo |
      | Overview |

  @CPW03
  Scenario Outline: Validacion de buscador
    Given que el usuario ingresa a la pagina principal
    When valida que la web funciona correctamente
    And ingresa a la pagina documentacion
    And realiza una busqueda con la palabra "<articulo>"
    Then Verifica que la redireccion a la pagina "<articulo>" funciona correctamente
    Examples:
      | articulo  |
      | WebDriver |