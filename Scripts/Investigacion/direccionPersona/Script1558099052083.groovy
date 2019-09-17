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

int ramdon = Math.abs(new Random().nextInt() % 100) + 1

String valor = ''

valor = findTestData('getDirecciones').getValue(1, ramdon)

WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/select_departamento'), valor, 
    true)

WebUI.delay(GlobalVariable.Delay)

valor = findTestData('getDirecciones').getValue(2, ramdon)

WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/select_ciudad'), valor, true)

WebUI.delay(GlobalVariable.Delay)

valor = findTestData('getDirecciones').getValue(3, ramdon)

WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/select_tipoVia'), valor, true)

WebUI.delay(GlobalVariable.Delay)

valor = findTestData('getDirecciones').getValue(4, ramdon)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/input_numeroVia'), valor)

WebUI.delay(GlobalVariable.Delay)

valor = findTestData('getDirecciones').getValue(5, ramdon)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/input_primerNumero'), valor)

WebUI.delay(GlobalVariable.Delay)

valor = findTestData('getDirecciones').getValue(6, ramdon)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/input_autorizaEnvioInformacin', [('k') : valor]))

WebUI.delay(GlobalVariable.Delay)

valor = findTestData('getDirecciones').getValue(7, ramdon)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/input_activo', [('j') : valor]))

WebUI.delay(GlobalVariable.Delay)

valor = findTestData('getDirecciones').getValue(8, ramdon) 
WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/DireccionPersona/textarea_complemento'), valor)

WebUI.delay(GlobalVariable.Delay)

