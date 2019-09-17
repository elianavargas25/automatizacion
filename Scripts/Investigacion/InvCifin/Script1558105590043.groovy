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

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/label_entidad'))

WebUI.delay(GlobalVariable.Delay)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/li_entidad', [('entidad') : 'BANCOLOMBIA']))

WebUI.delay(GlobalVariable.Delay)

WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/select_tipoMedida'), '20', 
    true)

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/input_entidad'), 'BBVA')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/input_nroProducto'), '465464654')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/input_estadoProd'), 'ACTIVO')

WebUI.delay(GlobalVariable.Delay)

WebUI.setText(findTestObject('Investigacion/InvestigacionBienes/InvestigacionCifin/input_tipoProducto'), 'CUENTA CORRIENTE')

WebUI.delay(GlobalVariable.Delay)

