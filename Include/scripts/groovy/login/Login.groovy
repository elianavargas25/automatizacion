package login
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


class Login {
	/**
	 * Estos son los pasos para el inicio de sesión del sistema
	 */
	@Given("El usuario se encuentra en la pagina de inicio de sesion")
	def paginaPrincipal() {
		WebUI.openBrowser(GlobalVariable.Url)
	}

	@When("Se ingresa el nombre de usuario (.*)")
	def setUserName(String UserName) {
		WebUI.setText(findTestObject('Login/UserName'), UserName)
	}

	@And("Se ingresa el password (.*)")
	def setPassword(String password) {
		WebUI.setText(findTestObject('Login/Password'), password)
	}

	@And("Selecciono la opción ingresar")
	def clickIngresar() {
		WebUI.click(findTestObject('Login/Ingresar sesion'))
	}

	@Then("Verifico que se inicie sesión correctamente (.*)")
	def validarIngreso(String estado) {
		if(estado.equals("Ok")){
			WebUI.verifyElementPresent(findTestObject('Login/Menu Cobro'),GlobalVariable.TimeOut )
		}else{
			WebUI.verifyTextPresent("No se puede determinar que las credenciales proporcionadas sean auténticas.", false)
		}
	}

	@Given("Inicie sesion con usuario (.*) y password (.*).")
	def inicioSesion(String UserName, String password){
		WebUI.openBrowser(GlobalVariable.Url)
		WebUI.waitForJQueryLoad(GlobalVariable.TimeOut)
		WebUI.maximizeWindow()
		WebUI.setText(findTestObject('Login/input_userName'), UserName)
		WebUI.setText(findTestObject('Login/input_password'), password)
		WebUI.click(findTestObject('Login/input_ingresarSesion'))
		WebUI.verifyElementPresent(findTestObject('Login/a_menucobro'),GlobalVariable.TimeOut )
	}
}