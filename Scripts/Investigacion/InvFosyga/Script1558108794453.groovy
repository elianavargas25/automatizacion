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

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/label_entidad'))

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/li_entidad', [('empresa') : 'EMDISALUD ESS']))

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/select_tipoMedida'))

WebUI.delay(GlobalVariable.Delay)

WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/select_tipoMedida'), '11', 
    true)

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/input_empresaLabora'), 'LOPEZ DE MESA')

WebUI.delay(GlobalVariable.Delay)

def numero = CustomKeywords.'utils.Aleatorios.getTimeStamp'()
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

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionFosyga/input_salario'), '15326655')

