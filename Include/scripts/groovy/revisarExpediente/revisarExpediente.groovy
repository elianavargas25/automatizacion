package revisarExpediente
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class revisarExpediente {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Selecciono la opción revisar expedientes")
	def clicRevisarExp() {
		WebUI.click(findTestObject('RevisionExpediente/a_revisarExpedientes'))
		WebUI.waitForJQueryLoad(GlobalVariable.TimeOut)
	}

	@When("Selecciono la renta (.*)")
	def seleccioneRenta(String renta) {
		WebUI.selectOptionByLabel(findTestObject('RevisionExpediente/select_Tipo_Renta'), renta, false)
		WebUI.delay(GlobalVariable.Delay)
	}

	@And("Selecciono proceso (.*)")
	def seleccioneProceso(String process) {
		def proceso = WebUI.getAttribute(findTestObject('RevisionExpediente/select_Proceso'), 'value')

		if (proceso.equals(null) || proceso.isEmpty()) {
			if (WebUI.verifyElementNotVisible(findTestObject('RevisionExpediente/table_pendienteCorreccion'), FailureHandling.CONTINUE_ON_FAILURE) ||
			WebUI.verifyElementNotVisible(findTestObject('RevisionExpediente/table_pendienteDevueltos'), FailureHandling.CONTINUE_ON_FAILURE)) {
				WebUI.selectOptionByLabel(findTestObject('RevisionExpediente/select_Proceso'), process, true)

				WebUI.click(findTestObject('RevisionExpediente/Page_Qits/BotonBuscar'))

				WebUI.delay(GlobalVariable.Delay)
			}
		} else if (proceso.equals('10')) {
			WebUI.click(findTestObject('RevisionExpediente/span_botonBuscar'))

			WebUI.delay(GlobalVariable.Delay)
		}
	}

	@And("Reviso que la bandeja pendiente revisión se encuentre cargada y realizo las siguientes validaciones (.*) con esta observación (.*) y motivo (.*)")
	def setRevision(String estado, String observacion, String motivo) {
		String separador = WebUI.getText(findTestObject('RevisionExpediente/inpit_cantidadPendienteRevision'))

		String[] parts = separador.split(': ')
		String[] estadoArray = estado.split('/')
		int maxEstado=0
		int minEstado=0
		int valor =0
		String casoEstado=''
		int casoEstadoRandom=0

		for(int i =0; i< estadoArray.size();i++){
			switch (estadoArray[i]){
				case 'Archivar':
					valor =1
					break
				case 'Corregir':
					valor =2
					break
				default:
					valor =3
					break
			}
			if(valor<minEstado || minEstado==0){
				minEstado = valor
			}
			if (valor>maxEstado){
				maxEstado=valor
			}
		}


		for (int i = 0; i < Integer.parseInt(parts[1]); i++) {
			WebUI.click(findTestObject('RevisionExpediente/span_botonPentRevisar', [('k') : 0]))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('RevisionExpediente/a_expediente'))

			WebUI.comment(WebUI.getAttribute(findTestObject('RevisionExpediente/input_cantidadExpediente'), 'innerHTML'))

			String cantExped = WebUI.getAttribute(findTestObject('RevisionExpediente/input_cantidadExpediente'), 'innerText')

			int cant = Integer.parseInt(cantExped)

			for (int j = 0; j < cant; j++) {
				WebUI.click(findTestObject('RevisionExpediente/span_botonEvaluarPR', [('k') : j]))

				WebUI.delay(GlobalVariable.Delay)


				if (!WebUI.verifyElementPresent(findTestObject('RevisionExpediente/fieldset_alerta'), GlobalVariable.TimeOut, FailureHandling.OPTIONAL)) {

					casoEstadoRandom =Math.abs(new Random().nextInt() % maxEstado) + 1
					switch (casoEstadoRandom){
						case 1:
							casoEstado ='Archivar'
							break
						case 2:
							casoEstado ='Corregir'
							break
						default:
							casoEstado ='Aprobar'
							break
					}
					WebUI.selectOptionByLabel(findTestObject('RevisionExpediente/select_Estado'), casoEstado,false)
				}

				WebUI.delay(GlobalVariable.Delay)

				def pestado = WebUI.getAttribute(findTestObject('RevisionExpediente/select_Estado'), 'value')

				if (!(pestado.equals('30'))) {
					//30= Aprobar

					WebUI.selectOptionByLabel(findTestObject('RevisionExpediente/select_TipoMotivo'), motivo , false)

					WebUI.delay(GlobalVariable.Delay)
				}

				WebUI.setText(findTestObject('RevisionExpediente/textarea_observaciones'), observacion)

				WebUI.delay(GlobalVariable.Delay)

				WebUI.click(findTestObject('RevisionExpediente/span_botonAceptarPR'))

				WebUI.delay(GlobalVariable.Delay)
			}

			WebUI.click(findTestObject('RevisionExpediente/span_botonGuardar'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.verifyElementPresent(findTestObject('RevisionExpediente/div_mensaje'), GlobalVariable.TimeOut)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('RevisionExpediente/span_botonVolver'))
		}
		WebUI.delay(GlobalVariable.Delay)
	}

	@And("Verifico que no hayan registros en la bandeja")
	def bandejaVacia() {
		WebUI.verifyElementNotPresent(findTestObject('RevisionExpediente/table_pendienteRevision'), 1,FailureHandling.CONTINUE_ON_FAILURE)
	}
}