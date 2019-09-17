package estudioTitulos
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


class estudioTitulos {
	@And("Selecciono el proceso (.*)")
	def seleccionProceso(String proceso){
		WebUI.delay(GlobalVariable.Delay)
		if (WebUI.verifyElementNotPresent(findTestObject('EstudioTitulos/Page_ Qits/fieldset_tableEstudioTitulos'), 3, FailureHandling.CONTINUE_ON_FAILURE)) {
			WebUI.delay(GlobalVariable.Delay)

			WebUI.selectOptionByLabel(findTestObject('EstudioTitulos/Page_ Qits/select_proceso'), proceso, false)

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('EstudioTitulos/Page_ Qits/span_buscar'))

			WebUI.waitForJQueryLoad(GlobalVariable.TimeOut)
		}
	}

	@When("Reviso que la bandeja Estudio de títulos se encuentre cargada")
	def bandejaEstudioTitulos() {
		WebUI.scrollToPosition(5555555, 55555555)

		WebUI.waitForJQueryLoad(GlobalVariable.TimeOut)

		WebUI.delay(8)

		WebDriver driver = DriverFactory.getWebDriver()

		WebElement Table = driver.findElement(By.xpath('//*[@id="formInvestigacionControl:tableEstudioTitulos"]/div[1]/table'))

		'To locate rows of table it will Capture all the rows available in the table '
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))

		println('No. of rows: ' + Rows.size())

		int numeroFilas = Rows.size()

		WebUI.delay(GlobalVariable.Delay)

		for (int i = 1; i < numeroFilas; i++) {
			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/span_procesar'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/a_InvestigacinBienes'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.scrollToPosition(9999999, 999999999)

			def BanderaX = WebUI.verifyTextPresent('Medida cautelar', false, FailureHandling.CONTINUE_ON_FAILURE)

			if (!(BanderaX)) {
				if (WebUI.verifyElementPresent(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/div_radioActivo'), 3,
				FailureHandling.CONTINUE_ON_FAILURE)) {
					WebUI.click(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/div_radioActivo'))
				}

				WebUI.delay(GlobalVariable.Delay)
			} else if (!(WebUI.verifyElementVisible(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/fieldset_alertaAcumulacion'),
			FailureHandling.CONTINUE_ON_FAILURE))) {
				if (WebUI.verifyElementClickable(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/div_radio'), FailureHandling.CONTINUE_ON_FAILURE)) {
					WebUI.click(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/div_radio'))
				}

				WebUI.delay(GlobalVariable.Delay)
			}

			WebUI.click(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/span_mandamiento'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/span_si'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.click(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/span_conDireccin'))

			WebUI.delay(GlobalVariable.Delay)

			WebUI.verifyElementVisible(findTestObject('Object Repository/EstudioTitulos/Page_ Qits/div_mensaje'), FailureHandling.STOP_ON_FAILURE)
		}
	}

	@Then("Verifico que la bandeja este vacia")
	def bandejaSinDatos() {
		WebUI.verifyElementNotPresent(findTestObject('EstudioTitulos/Page_ Qits/fieldset_tableEstudioTitulos'), 1, FailureHandling.CONTINUE_ON_FAILURE)
	}
}