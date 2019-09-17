@RevisarExpediente
Feature: Revisar expedientes conformados en cobro coactivo
  Yo como usuario automatizador requiero revisar los expedientes conformados en cobro coactivo

  Background: Inicio sesion
  Given Inicie sesion con usuario eliana y password admin.

  @PendienteRevisión
  Scenario: Revisar Expedientes
    Given Selecciono la opción revisar expedientes
     When Selecciono la renta Infracciones De Tránsito
      And Selecciono proceso Pendiente revisión
      And Reviso que la bandeja pendiente revisión se encuentre cargada y realizo las siguientes validaciones Archivar/Corregir/Aprobar con esta observación prueba y motivo Error En El Auto Aclaratorio
     Then Verifico que no hayan registros en la bandeja
