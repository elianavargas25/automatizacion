import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())


RunConfiguration.setExecutionSettingFile('C:\\Users\\eliana.vargas\\AppData\\Local\\Temp\\Katalon\\20190516_071328\\execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runWSVerificationScript(new TestCaseBinding('',[:]), 'import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI\nimport com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile\nimport com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW\nimport com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS\nimport static com.kms.katalon.core.testobject.ObjectRepository.findTestObject\nimport static com.kms.katalon.core.testdata.TestDataFactory.findTestData\nimport static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase\nimport static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint\nimport com.kms.katalon.core.model.FailureHandling as FailureHandling\nimport com.kms.katalon.core.testcase.TestCase as TestCase\nimport com.kms.katalon.core.testdata.TestData as TestData\nimport com.kms.katalon.core.testobject.TestObject as TestObject\nimport com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint\nimport internal.GlobalVariable as GlobalVariable\nimport org.openqa.selenium.Keys as Keys\n\nWebUI.openBrowser(\'\')\n\nWebUI.navigateToUrl(\'https://qxnucleo3.quipux.local:8282/qxcobrocoactivo/\')\n\nWebUI.click(findTestObject(\'Page_. Qits ./div_Versin QITS 6.0_Cabezalogin\'))\n\nWebUI.setText(findTestObject(\'Page_. Qits ./input_U_username\'), \'eliana\')\n\nWebUI.setEncryptedText(findTestObject(\'Page_. Qits ./input_C_password\'), \'RAIVpflpDOg=\')\n\nWebUI.click(findTestObject(\'Page_. Qits ./input_C_submit\'))\n\nWebUI.click(findTestObject(\'Page_. Qits ./a_Investigacin y control\'))\n\nWebUI.click(findTestObject(\'Page_. Qits ./span_Procesar\'))\n\nWebUI.click(findTestObject(\'Page_. Qits ./a_Investigacin de bienes\'))\n\nWebUI.click(findTestObject(\'Page_. Qits ./span_Adicionar\'))\n\nWebUI.selectOptionByValue(findTestObject(\'Page_. Qits ./select_Cmara de comercioCIFINFOSYGARUNTSupernotariado\'), \'1\', true)\n\nWebUI.click(findTestObject(\'Page_. Qits ./span_Si\'))\n\nWebUI.click(findTestObject(\'Page_. Qits ./span_Seleccionar\'))\n\n', FailureHandling.STOP_ON_FAILURE, true)

