import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
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

WebUI.callTestCase(findTestCase('Login/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/a_investigacinControl'))

WebUI.delay(GlobalVariable.Delay)

WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/Investigacion/select_tipoRenta'), '1', true)

WebUI.delay(GlobalVariable.Delay)

if (WebUI.verifyElementNotPresent(findTestObject('Investigacion/InvestigacionBienes/Investigacion/fieldset_tableInvestigacion'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/Investigacion/select_proceso'), '3', true)

    WebUI.delay(GlobalVariable.Delay)

    WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_buscar'))
}

WebUI.delay(5)

WebDriver driver = DriverFactory.getWebDriver()

WebElement Table = driver.findElement(By.xpath('//*[@id="formInvestigacionControl:tableInvestigacion"]/div[1]/table'))

'To locate rows of table it will Capture all the rows available in the table '
List<WebElement> Rows = Table.findElements(By.tagName('tr'))

println('No. of rows: ' + Rows.size())

numeroFilas = Rows.size()

for (int i = 1; i < numeroFilas; i++) {
    WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_procesar'))

    WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/a_investigacionBienes'))

    WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_adicionar'))

    WebUI.delay(GlobalVariable.Delay)

    for (int j = 1; j < 6; j++) {
        def opcionPoseeBien = 'Si'

        WebUI.selectOptionByValue(findTestObject('Investigacion/InvestigacionBienes/Investigacion/select_tipoBien'), j.toString(), 
            true)

        WebUI.delay(GlobalVariable.Delay)

        if (opcionPoseeBien.equals('No')) {
            WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_poseeBien' //Camara de comercio
                    //Cifin
                    ) //Super
                ) //Runt
            //Fosyga
            /* Linea que llama el caso de cargue de archivo
       *  WebUI.callTestCase(findTestCase('Investigacion/cargarArchivo'), [:], FailureHandling.STOP_ON_FAILURE)*/
        } else {
            switch (WebUI.getAttribute(findTestObject('Investigacion/InvestigacionBienes/Investigacion/select_tipoBien'), 
                'value')) {
                case '1':
                    WebUI.delay(GlobalVariable.Delay)

                    WebUI.callTestCase(findTestCase('Investigacion/InvCamaraComercio'), [:], FailureHandling.STOP_ON_FAILURE)

                    break
                case '2':
                    WebUI.callTestCase(findTestCase('Investigacion/InvCifin'), [:], FailureHandling.STOP_ON_FAILURE)

                    break
                case '3':
                    WebUI.callTestCase(findTestCase('Investigacion/InvSupernotariado'), [:], FailureHandling.STOP_ON_FAILURE)

                    break
                case '4':
                    WebUI.callTestCase(findTestCase('Investigacion/InvRunt'), [:], FailureHandling.STOP_ON_FAILURE)

                    break
                case '5':
                    WebUI.callTestCase(findTestCase('Investigacion/InvFosyga'), [:], FailureHandling.STOP_ON_FAILURE)

                    break
                default:
                    break
            }
        }
    }
    
    WebUI.delay(GlobalVariable.Delay)

    WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_volver'))

    WebUI.delay(GlobalVariable.Delay)

    WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_continuar'))

    WebUI.delay(GlobalVariable.Delay)

    WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_continuarProceso'))

    WebUI.delay(GlobalVariable.Delay)

    WebUI.click(findTestObject('Investigacion/InvestigacionBienes/Investigacion/span_guardar'))

    WebUI.delay(GlobalVariable.Delay)
}

//Linea para verificar el mensaje de almacenamiento
WebUI.verifyElementPresent(findTestObject('Investigacion/InvestigacionBienes/Investigacion/div_mensajeAlmacenamiento'), 
    GlobalVariable.TimeOut)