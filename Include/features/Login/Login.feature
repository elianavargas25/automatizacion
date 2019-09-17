#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Inicio de sesión en Cobro Coactivo
  Yo como usuario automatizador quiero iniciar sesión en el aplciativo de cobro coactivo

  @tag1
  Scenario Outline: Ingreso exitoso
    Given El usuario se encuentra en la pagina de inicio de sesion
     When Se ingresa el nombre de usuario <usuario>
      And Se ingresa el password <password>
      And Selecciono la opción ingresar
     Then Verifico que se inicie sesión correctamente <estado>

    Examples: 
      | usuario | password | estado |
      | eliana  | admin    | Ok     |
      | eliana  |        7 | Fail   |
