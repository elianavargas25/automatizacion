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
@estudioTitulos
Feature: Generar mandamiento de pago a los proceso de cobro coactivo
  Yo como usuario automatizador quiero generar mandamiento  de pago a los procesos conformados en cobro coactivo

  Background: Inicio sesion
    Given Inicie sesion con usuario eliana y password admin.

  @mandamiento
  Scenario: Generar mandamiento de pago
    Given Selecciono la opción Investigacion y control
      And Selecciono el tipo renta Infracciones De Tránsito
      And Selecciono el proceso Estudio de títulos
     When Reviso que la bandeja Estudio de títulos se encuentre cargada
     Then Verifico que la bandeja este vacia
