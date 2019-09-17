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
import java.sql.ResultSet


def checkDBQITS = CustomKeywords.'co.com.quipux.wat.checkDataBase.checkDB'(GlobalVariable.hostQITS, GlobalVariable.nameQITS, 
    GlobalVariable.portQITS, GlobalVariable.userNameQITS, GlobalVariable.passwordQITS)

assert checkDBQITS

def checkDBQX = CustomKeywords.'co.com.quipux.wat.checkDataBase.checkDB'(GlobalVariable.hostQX, GlobalVariable.nameQX, GlobalVariable.portQX, 
    GlobalVariable.userNameQX, GlobalVariable.passwordQX)

assert checkDBQX

CustomKeywords.'co.com.quipux.wat.checkDataBase.connectDB'(GlobalVariable.hostQITS, GlobalVariable.nameQITS, GlobalVariable.portQITS, 
    GlobalVariable.userNameQITS, GlobalVariable.passwordQITS)

def selectData = 'SELECT CASE WHEN LENGTH(DIRECCION.ID)>0 THEN 1 ELSE 0 END AS ENCONTRADO FROM DUAL LEFT JOIN(\nSELECT PI.ID_PERSONA AS ID FROM CORE_MEDELLIN.PERSONA_IDENTIFICACION PI \nINNER JOIN CORE_MEDELLIN.MAESTRO_PERSONA MP ON PI.ID_PERSONA = MP.ID_PERSONA\nLEFT JOIN CORE_MEDELLIN.DIRECCION_PERSONA DP ON MP.ID_PERSONA = DP.ID_PERSONA \nLEFT JOIN CORE_MEDELLIN.MAESTRO_SEDE MS ON MS.ID_PERSONA_JURIDICA = MP.ID_PERSONA AND MS.ACTIVO =\'S\' \nINNER JOIN CORE_MEDELLIN.MAESTRO_DIRECCION MD ON MD.ID_DIRECCION = NVL(DP.ID_DIRECCION, MS.ID_DIRECCION) AND MD.ACTIVO =\'S\' AND MD.ENVIO_INFORMACION =\'S\'\nWHERE PI.NUMERO_DOCUMENTO =\'1054556722\') DIRECCION ON 1=1'

List<List> rs = CustomKeywords.'co.com.quipux.wat.checkDataBase.executeQuery'(selectData)
CustomKeywords.'co.com.quipux.wat.checkDataBase.closeDatabaseConnection'()
System.out.println(rs)