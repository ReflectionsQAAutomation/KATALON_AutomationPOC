package com.pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

// Common methods for Registration Page

public class Registration {

	//method to navigate to the Registration  Page
	def static void ClickRegistrationLink() {
		int aScreen = WebUI.getPageWidth()
		println(aScreen)
		if (aScreen < 1000) {
			println('Entered the resposive web ')
			WebUI.delay(5)
			println('before toggle ')
			try {
				WebUI.click(findTestObject('Page_Homepage/span_Hand Tools_navbar-toggler-icon'))
			} catch(Exception e) {
				println(e)
			}
			println('clicked toggle icon ')
			WebUI.delay(5)
		}
		WebUI.click(findTestObject('Object Repository/Page_SignIn/menu_Sign in'))
		println('Clicked in Sign In')
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Registration/link_RegisterYourAccount'), 'Register your account')
		WebUI.click(findTestObject('Object Repository/Page_Registration/link_RegisterYourAccount'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Registration/txt_CustomerRegistration'), 0)
	}



	/** Enter user registration details on the RegisterPage.
	 * @param FirstName: First name of the user
	 * LastName: Last name of the user
	 * DOB: Date of birth of the user
	 * Address: User's address
	 * Post code: Postal code of the user's location
	 * City: City of residence
	 * State: State or region of residence
	 * Country: Country of residence, Drop down list
	 * Phone: User's phone number
	 * Email: User's email address
	 * Password: User's chosen password
	 */
	def static void EnterRegistrationDetails(FirstName,LastName,DOB,Address,Postcode,City,State,Country,Phone,Email,Password) {
		WebUI.setText(findTestObject('Object Repository/Page_Registration/txtBox_FirstName'), FirstName)
		WebUI.setText(findTestObject('Object Repository/Page_Registration/txtBox_LastName'), LastName)
		WebUI.verifyElementPresent(findTestObject('Page_Registration/date_DOB'), 0)
		WebUI.setText(findTestObject('Page_Registration/date_DOB'), DOB)
		WebUI.click(findTestObject('Object Repository/Page_Registration/txtBox_Address'))
		WebUI.setText(findTestObject('Object Repository/Page_Registration/txtBox_Address'), Address)
		WebUI.setText(findTestObject('Object Repository/Page_Registration/txtBox_Postcode'), Postcode)
		WebUI.setText(findTestObject('Object Repository/Page_Registration/txtBox_City'), City)
		WebUI.setText(findTestObject('Object Repository/Page_Registration/txtBox_State'), State)
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Registration/select_Select your country Albanialand Isla_c10608'),
				Country, true)
		WebUI.setText(findTestObject('Object Repository/Page_Registration/txtBox_Phone'), Phone)
		WebUI.setText(findTestObject('Object Repository/Page_Registration/txtBox_EmailAddress'), Email)
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_Registration/txtBox_Password'), Password)
	}


	//method to click on the Registration Button
	def static void ClickRegisterButton() {
		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/Page_Registration/buttonRegister'))
	}

	//method to check  first name validation message is appearing
	def static void CheckFirstNameValidationMessage() {
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Registration/txt_FirstNameRequiredValidation'),'First name is required.')
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Registration/txt_FirstNameRequiredValidation'),300)
	}
}
