import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import utils.Aleatorios as Aleatorios

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/label_entidad'))

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/li_entidad', [('CAMARA') : 'CAMARA DE COMERCIO DE MEDELLIN PARA ANTIOQUIA']))

WebUI.delay(GlobalVariable.Delay)

def matricula = CustomKeywords.'utils.Aleatorios.getTimeStamp'()

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_identificadorBien'), matricula.toString())

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/select_tipoMedida'))

WebUI.delay(4)

WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/select_tipoMedida'), '7', 
    true)

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_numeroNIT'), '4455662')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_nombreEstablecimiento'), 'LOS PECAS')

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/span_adicionarPer'))

WebUI.delay(GlobalVariable.Delay)

WebUI.callTestCase(findTestCase('Investigacion/direccionPersona'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/span_guarda'))

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_fechaActualizacinMatrcula'), '015022016')

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_raznSocial'), 'LOS PECAS')

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_radProceso'), '78555')

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_nombreJuzgado'), 'JUZGADO PENAL')

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/DireccionJuzgado/span_adicionarJuzg'))

WebUI.delay(GlobalVariable.Delay)

WebUI.callTestCase(findTestCase('Investigacion/direccion_Juzgado'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/DireccionJuzgado/span_guardarJuzg'))

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_tipoProceso'), 'DEMANDA')

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCamara/input_demandante'), 'JOSE LUIS')