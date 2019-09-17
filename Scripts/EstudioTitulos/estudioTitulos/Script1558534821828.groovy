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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Login/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('EstudioTitulos/Page_ Qits/a_investigacinControl'))

WebUI.selectOptionByValue(findTestObject('EstudioTitulos/Page_ Qits/select_tipoRenta'), '1', true)

WebUI.delay(GlobalVariable.Delay)

if (WebUI.verifyElementNotPresent(findTestObject('EstudioTitulos/Page_ Qits/fieldset_tableEstudioTitulos'), 3, FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.delay(GlobalVariable.Delay)

    WebUI.selectOptionByValue(findTestObject('EstudioTitulos/Page_ Qits/select_proceso'), '2', true)

    WebUI.delay(GlobalVariable.Delay)

    //WebUI.selectOptionByValue(findTestObject('EstudioTitulos/Page_ Qits/select_criterioIdentificacion'), '11', true)
    //WebUI.selectOptionByValue(findTestObject('EstudioTitulos/Page_ Qits/select_select_tipoIdentificacion'), TIPO_DOCUMENTO, 
    //   true)
    //WebUI.delay(GlobalVariable.Delay)
    //WebUI.setText(findTestObject('EstudioTitulos/Page_ Qits/input_nroDocumento'), NRO_DOCUMENTO)
    WebUI.delay(GlobalVariable.Delay)

    WebUI.click(findTestObject('EstudioTitulos/Page_ Qits/span_buscar'))

    WebUI.delay(7)
}

WebUI.delay(4)

WebUI.scrollToPosition(5555555, 55555555)
WebUI.delay(2)

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