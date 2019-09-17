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

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/label_entidad'))

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/li_entidad', [('OFICINA') : 'OFICINA DE INSTRUMENTOS PUBLICOS PALMIRA']))

WebUI.delay(GlobalVariable.Delay)

def matricula = CustomKeywords.'utils.Aleatorios.getTimeStamp'()
WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/input_identificadorBien'),  matricula.toString())

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/select_tipoMedida'))

WebUI.delay(GlobalVariable.Delay)

WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/select_tipoMedida'), 
    '1', true)

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/span_adicionar'))

WebUI.delay(GlobalVariable.Delay)

WebUI.callTestCase(findTestCase('Investigacion/direccionPersona'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/span_guardar'))

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/input_radProceso'), 'RAD 858')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/input_juzgado'), 'JUZGADO PENAL')

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/span_adicionarJuzg'))

WebUI.delay(GlobalVariable.Delay)

WebUI.callTestCase(findTestCase('Investigacion/direccion_Juzgado'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/span_guardarJuzg'))

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/input_tipoProceso'), 'DEMANDA')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionSupernotariado/input_demandante'), 'ROBERTO')

WebUI.delay(GlobalVariable.Delay)