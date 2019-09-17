package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Aleatorios {

	@Keyword
	def static retornarNumero(){
		Random random = new Random();
		System.out.println("Random String " + new BigInteger(99, random).toString(32));
		// Un BigInteger, de 50 bits (10 caracteres * 5 bits por caracter)
		return  new BigInteger(30, random).toString()
		//return (random).toString()
	}

	@Keyword
	public static String getTimeStamp() {
		Date ahora = new Date();
		return ahora.time
	}

	@Keyword
	def static String retornarPlaca(){
		def retornado = this.retornarNumero()

		List list = retornado.split('')

		def tamano = list.size()

		WebUI.comment(list[0])

		def placa = ''

		for (int i = 0; i < 3; i++) {
			def num_letra = ''

			switch (list[i]) {
				case '1':
					num_letra = 'A'

					break
				case '2':
					num_letra = 'B'

					break
				case '3':
					num_letra = 'C'
					break
				case '4':
					num_letra = 'D'

					break
				case '5':
					num_letra = 'E'

					break
				case '6':
					num_letra = 'F'

					break
				case '7':
					num_letra = 'G'

					break
				case '8':
					num_letra = 'H'

					break
				case '9':
					num_letra = 'I'

					break
				case '0':
					num_letra = 'J'

					break
				default:
					num_letra = 'X'

					break
			}

			placa = ((placa + '') + num_letra)

			WebUI.comment(placa)
		}

		placa = (((placa + (list[3])) + (list[4])) + (list[5]))

		return placa
	}
}