import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.googlecode.javacv.cpp.swscale as swscale
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
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase as SwitchCase

WebUI.callTestCase(findTestCase('Login/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('RevisionExpediente/a_revisarExpedientes'))

WebUI.selectOptionByValue(findTestObject('RevisionExpediente/select_Tipo_Renta'), '1', true)

def proceso = WebUI.getAttribute(findTestObject('RevisionExpediente/select_Proceso'), 'value')


if (proceso.equals(null) || proceso.isEmpty()) {
    if (WebUI.verifyElementNotVisible(findTestObject('RevisionExpediente/table_pendienteCorreccion'), FailureHandling.CONTINUE_ON_FAILURE) || 
    WebUI.verifyElementNotVisible(findTestObject('RevisionExpediente/table_pendienteDevueltos'), FailureHandling.CONTINUE_ON_FAILURE)) {
        WebUI.selectOptionByValue(findTestObject('RevisionExpediente/select_Proceso'), '12', 
            true)

        WebUI.click(findTestObject('RevisionExpediente/Page_Qits/BotonBuscar'))

        WebUI.delay(GlobalVariable.Delay)
    }
} else if (proceso.equals('10')) {
    WebUI.click(findTestObject('RevisionExpediente/span_botonBuscar'))

    WebUI.delay(GlobalVariable.Delay)
}

String separador = WebUI.getText(findTestObject('RevisionExpediente/inpit_cantidadPendienteRevision'))

String[] parts = separador.split(': ')

int k = 0

for (int i = 0; i < Integer.parseInt(parts[1]); i++) {
    WebUI.click(findTestObject('RevisionExpediente/span_botonPentRevisar', [('k') : 0]))

    WebUI.delay(GlobalVariable.Delay)

    WebUI.click(findTestObject('RevisionExpediente/a_expediente'))

    WebUI.comment(WebUI.getAttribute(findTestObject('RevisionExpediente/input_cantidadExpediente'), 'innerHTML'))

    String cantExped = WebUI.getAttribute(findTestObject('RevisionExpediente/input_cantidadExpediente'), 'innerText')

    int cant = Integer.parseInt(cantExped)

    for (int j = 0; j < cant; j++) {
        WebUI.click(findTestObject('RevisionExpediente/span_botonEvaluarPR', [('k') : j]))

        WebUI.delay(GlobalVariable.Delay)

        int pEstado = 0

        if (WebUI.verifyElementPresent(findTestObject('RevisionExpediente/fieldset_alerta'), GlobalVariable.TimeOut, FailureHandling.OPTIONAL)) {
            pEstado = 45
        } else {
            WebUI.comment('Entro s')

            pEstado = 30

            WebUI.selectOptionByValue(findTestObject('RevisionExpediente/select_Estado'), pEstado.toString(), 
                false)
        }
        
        WebUI.delay(GlobalVariable.Delay)

        def estado = WebUI.getAttribute(findTestObject('RevisionExpediente/select_Estado'), 'value')

        if (!(estado.equals('30'))) {
            //30=Aprobar
            int pmotivo = 2

            WebUI.selectOptionByValue(findTestObject('RevisionExpediente/select_TipoMotivo'), '2', false)

            WebUI.delay(GlobalVariable.Delay)
        }
        
        WebUI.setText(findTestObject('RevisionExpediente/textarea_observaciones'), 'prueba')

        WebUI.delay(GlobalVariable.Delay)

        WebUI.click(findTestObject('RevisionExpediente/span_botonAceptarPR'))

        WebUI.delay(GlobalVariable.Delay)
    }
    
    WebUI.click(findTestObject('RevisionExpediente/span_botonGuardar'))

    WebUI.delay(GlobalVariable.Delay)

    WebUI.verifyElementPresent(findTestObject('RevisionExpediente/div_mensaje'), GlobalVariable.TimeOut)

    WebUI.delay(GlobalVariable.Delay)

    WebUI.click(findTestObject('RevisionExpediente/span_botonVolver'))
}