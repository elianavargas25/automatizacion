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

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/label_entidad'))

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/li_entidad', [('ENTIDAD') : 'SECRETARIA DE TRANSITO Y TRANSPORTE MUNICIPAL POPA']))

WebUI.delay(GlobalVariable.Delay)

def placa = CustomKeywords.'utils.Aleatorios.retornarPlaca'()

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_placa'), placa.toString())

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/select_tipoMedida'))

WebUI.delay(GlobalVariable.Delay)

WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/select_tipoMedida'), '4', 
    true)

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_chasis'), 'T5T54T54T')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_clase'), 'TY56Y6Y')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_linea'), 'MOTO')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_marca'), 'YAMAHA')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_modelo'), '2016')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_color'), 'NEGRO')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_radProceso'), 'RAD 4525')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_nombreJuzgado'), 'JUZGADO PENAL')

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/span_adicionar'))

WebUI.delay(GlobalVariable.Delay)

WebUI.callTestCase(findTestCase('Investigacion/direccion_Juzgado'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/span_guardarJuz'))

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_tipoProceso'), 'DEMANDA')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionRunt/input_demandante'), 'ROBERTO')

