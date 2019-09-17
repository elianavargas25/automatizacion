package investigacion
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
import utils.Aleatorios as Aleatorios

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class investigacionBienes {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Selecciono la opción Investigacion y control")
	def opcionInvestigacion() {
		WebUI.click(findTestObject('EstudioTitulos/Page_ Qits/a_investigacinControl'))
	}

	@And("Selecciono el tipo renta (.*)")
	def selectRenta(String renta) {
		def valor = WebUI.getAttribute(findTestObject('EstudioTitulos/Page_ Qits/select_tipoRenta'), 'value')
		if(!valor.equals("1")){
			WebUI.selectOptionByLabel(findTestObject('EstudioTitulos/Page_ Qits/select_tipoRenta'), renta , true)
		}
	}

	@And("Selecciono el tipo proceso (.*)")
	def selectProceso(String proceso) {
		if (WebUI.verifyElementNotPresent(findTestObject('Investigacion/InvestigacionBienes/Investigacion/fieldset_tableInvestigacion'),
		2, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/Investigacion/select_proceso'), proceso, false)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_buscar'))
		}
	}

	@When("Reviso que la bandeja investigación de bienes se encuentre cargada")
	def setInvestigacion() {
		WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_procesar'))

		WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/a_investigacionBienes'))

		WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_adicionar'))

		WebUI.delay(GlobalVariable.Delay)
	}

	@And("Selecciono la opción posee bien (.*) y selecciono el bien (.*), selecciono la entidad (.*), ingreso el numero de matricula, selecciono la medida (.*), ingreso el nombre del establecimiento (.*), y fecha de matricula (.*), y razón social (.*), radicado (.*), y juzgado (.*), y tipo proceso (.*), y demandante (.*)")
	def invCamara(String poseeBien, String bien, String entidad, String medida, String nombre, String fecha, String razonSocial, String juzgado, String radicado, String tproceso, String demandante) {
		def opcionPoseeBien = poseeBien

		WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/Investigacion/select_tipoBien'), bien ,
				false)

		WebUI.delay(GlobalVariable.Delay)

		if (opcionPoseeBien.equals('No')) {
			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_poseeBien'))
		} else {

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/label_entidad'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/li_entidad', [('CAMARA') : entidad]))

			WebUI.delay(2)

			final matricula = utils.Aleatorios.getTimeStamp()

			//def matricula = CustomKeywords.'utils.Aleatorios.getTimeStamp'()

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_identificadorBien'), matricula.toString())

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/select_tipoMedida'))

			WebUI.delay(4)

			WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/select_tipoMedida'), medida, false)

			WebUI.delay(GlobalVariable.Delay)

			def nit = utils.Aleatorios.getTimeStamp()
			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_numeroNIT'), nit.toString())

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_nombreEstablecimiento'), nombre)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/span_adicionarPer'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.callTestCase(findTestCase('Investigacion/direccionPersona'), [:], FailureHandling.STOP_ON_FAILURE)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/span_guarda'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_fechaActualizacinMatrcula'), fecha)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_raznSocial'), razonSocial)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_radProceso'), radicado)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_nombreJuzgado'), juzgado)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/DireccionJuzgado/span_adicionarJuzg'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.callTestCase(findTestCase('Investigacion/direccion_Juzgado'), [:], FailureHandling.STOP_ON_FAILURE)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/DireccionJuzgado/span_guardarJuzg'))

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_tipoProceso'), tproceso)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_demandante'), demandante)
		}
	}

	@And("Selecciono la opción posee bien (.*) y selecciono el bien (.*), selecciono la entidad (.*), ingreso la placa, selecciono la medida (.*), ingreso el chasis (.*), clse del vehiculo (.*), y linea del vehiculo (.*), ingreso la marca (.*), ingreso el modelo (.*), el color (.*), el radicado (.*), y juzgado (.*), y tipo proceso (.*), y demandante (.*)")
	def invRunt(String poseeBien, String bien, String entidad, String medida, String chasis, String clase, String linea, String marca, String modelo, String color, String radicado, String juzgado,  String tproceso, String demandante) {
		def opcionPoseeBien = poseeBien

		WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/Investigacion/select_tipoBien'), bien ,
				false)

		WebUI.delay(GlobalVariable.Delay)

		if (opcionPoseeBien.equals('No')) {
			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_poseeBien'))
		} else {

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/label_entidad'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/li_entidad', [('ENTIDAD') : entidad]))

			WebUI.delay(GlobalVariable.Delay)


			def placa = utils.Aleatorios.retornarPlaca()
			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_placa'), placa.toString())

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/select_tipoMedida'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/select_tipoMedida'), medida,
					false)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_chasis'), chasis)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_clase'), clase)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_linea'), linea)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_marca'), marca)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_modelo'), modelo)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_color'), color)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_radProceso'), radicado)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_nombreJuzgado'), juzgado)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/span_adicionar'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.callTestCase(findTestCase('Investigacion/direccion_Juzgado'), [:], FailureHandling.STOP_ON_FAILURE)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/span_guardarJuz'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_tipoProceso'), tproceso)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_demandante'), demandante)
		}
	}

	@And("Selecciono la opción posee bien (.*) y selecciono el bien (.*), selecciono la entidad (.*), ingreso el numero de matricula, selecciono la medida (.*), el radicado (.*), y juzgado (.*), y tipo proceso (.*), y demandante (.*)")
	def invSuper(String poseeBien, String bien, String entidad, String medida, String radicado, String juzgado,  String tproceso, String demandante) {
		def opcionPoseeBien = poseeBien

		WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/Investigacion/select_tipoBien'), bien ,
				false)

		WebUI.delay(GlobalVariable.Delay)

		if (opcionPoseeBien.equals('No')) {
			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_poseeBien'))
		} else {

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/label_entidad'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/li_entidad', [('OFICINA') : entidad]))

			WebUI.delay(GlobalVariable.Delay)

			def matricula = utils.Aleatorios.getTimeStamp()
			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/input_identificadorBien'),  matricula.toString())

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/select_tipoMedida'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/select_tipoMedida'),medida, false)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/span_adicionar'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.callTestCase(findTestCase('Investigacion/direccionPersona'), [:], FailureHandling.STOP_ON_FAILURE)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/span_guardar'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/input_radProceso'), radicado)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/input_juzgado'), juzgado)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/span_adicionarJuzg'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.callTestCase(findTestCase('Investigacion/direccion_Juzgado'), [:], FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/span_guardarJuzg'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/input_tipoProceso'), tproceso)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/input_demandante'), demandante)

			WebUI.delay(GlobalVariable.Delay)
		}
	}

	@And("Selecciono la opción posee bien (.*) y selecciono el bien (.*), selecciono la entidad (.*), selecciono la medida (.*), ingreso la empresa donde labora (.*), ingreso el NIT de la empresa, ingreso el IBC (.*)")
	def invFosyga(String poseeBien, String bien, String entidad, String medida, String empresa, String salario) {
		def opcionPoseeBien = poseeBien

		WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/Investigacion/select_tipoBien'), bien ,
				false)

		WebUI.delay(GlobalVariable.Delay)

		if (opcionPoseeBien.equals('No')) {
			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_poseeBien'))
		} else {

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/label_entidad'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/li_entidad', [('empresa') : entidad]))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/select_tipoMedida'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/select_tipoMedida'), medida, false)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/input_empresaLabora'), empresa)

			WebUI.delay(GlobalVariable.Delay)

			def numero = utils.Aleatorios.getTimeStamp()
			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/input_numeroNIT'), numero.toString())

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/input_empresaLabora'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/span_adicionar'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.callTestCase(findTestCase('Investigacion/direccionPersona'), [:], FailureHandling.STOP_ON_FAILURE)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/span_guardar'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/input_salario'), salario)
		}
	}

	@And("Selecciono la opción posee bien (.*) y selecciono el bien (.*), selecciono la entidad (.*), selecciono la medida (.*), ingreso la entidad del producto financiero (.*), ingreso el numero producto, ingreso el estado del producto (.*), ingreso el tipo de producto (.*)")
	def invCifin(String poseeBien, String bien, String entidad, String medida, String empresa, String estado, String tproducto) {
		def opcionPoseeBien = poseeBien

		WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/Investigacion/select_tipoBien'), bien ,
				false)

		WebUI.delay(GlobalVariable.Delay)

		if (opcionPoseeBien.equals('No')) {
			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_poseeBien'))
		} else {

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/label_entidad'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/li_entidad', [('entidad') : entidad]))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.selectOptionByLabel(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/select_tipoMedida'), medida,
					true)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/input_entidad'), empresa)

			WebUI.delay(GlobalVariable.Delay)

			def numero = utils.Aleatorios.getTimeStamp()
			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/input_nroProducto'), numero.toString())

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/input_estadoProd'), estado)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/input_tipoProducto'), tproducto)

			WebUI.delay(GlobalVariable.Delay)
		}
	}
}


