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
@Investigaciones
Feature: Realizar investigaciones de bienes a los deudores
  Yo como usuario automatizador requiero investigar los bienes 
  de los deudores conformados en cobro coactivo

  Background: Inicio sesion
    Given Inicie sesion con usuario eliana y password admin.

  @InvestigacionBien
  Scenario: Investigaciones positivas
    Given Selecciono la opción Investigacion y control
      And Selecciono el tipo renta Infracciones De Tránsito
      And Selecciono el tipo proceso Investigación Supernotariado
     When Reviso que la bandeja investigación de bienes se encuentre cargada
      And Selecciono la opción posee bien Si y selecciono el bien Cámara de comercio, selecciono la entidad CAMARA DE COMERCIO DE BUENAVENTURA, ingreso el numero de matricula, selecciono la medida Embargo, ingreso el nombre del establecimiento Zenu, y fecha de matricula 25/02/2016, y razón social Fernandez A.S, radicado 3005, y juzgado JUZGADO PENAL, y tipo proceso DEMANDA, y demandante ARMANDO
      And Selecciono la opción posee bien Si y selecciono el bien RUNT, selecciono la entidad TRANSITO MEDELLIN, ingreso la placa, selecciono la medida Embargo, ingreso el chasis FG5F6HG6H, clse del vehiculo MOTOCICLETA, y linea del vehiculo PRO 250, ingreso la marca YAMAHA, ingreso el modelo 2015, el color NEGRO, el radicado 3005, y juzgado JUZGADO PENAL, y tipo proceso DEMANDA, y demandante ARMANDO
      And Selecciono la opción posee bien Si y selecciono el bien Supernotariado, selecciono la entidad OFICINA DE INSTRUMENTOS PUBLICOS PALMIRA, ingreso el numero de matricula, selecciono la medida Embargo, el radicado 3005, y juzgado JUZGADO PENAL, y tipo proceso DEMANDA, y demandante ARMANDO
      And Selecciono la opción posee bien Si y selecciono el bien FOSYGA, selecciono la entidad EMDISALUD ESS, selecciono la medida Embargo de Salario, ingreso la empresa donde labora QUIPUX, ingreso el NIT de la empresa, ingreso el IBC 54222265
      And Selecciono la opción posee bien Si y selecciono el bien CIFIN, selecciono la entidad BANCOLOMBIA, selecciono la medida Embargo Productos Financieros, ingreso la entidad del producto financiero BBVA, ingreso el numero producto, ingreso el estado del producto ACTIVO, ingreso el tipo de producto CUENTA CORRIENTE

    