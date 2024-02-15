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

// Common methods for Sign- In Page

public class SignIn {

	/**
	 * Method to Login using email and password
	 * @param :Email: email address, Password: password  use to register the email while SignIn
	 *
	 */
	def static void EnterDetailsAndLogin(Email,Password) {
		WebUI.verifyElementVisible(findTestObject('Object Repository/Page_SignIn/txtBox_email'), FailureHandling.STOP_ON_FAILURE)
		println('Login Page')
		WebUI.setText(findTestObject('Object Repository/Page_SignIn/txtBox_email'), Email)
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_SignIn/txtBox_Password'), Password)
		WebUI.click(findTestObject('Object Repository/Page_SignIn/btnLogin'))
		println('Login Clicked')
		WebUI.delay(5)
		WebUI.verifyElementText(findTestObject('Object Repository/Page_SignIn/txt_LoginMessage'), 'Here you can manage your profile, favorites and orders.')

	}

	//method to click on the SignIn link
	def static void ClickSignInLink() {
		int aScreen = WebUI.getPageWidth()
		println(aScreen)
		if (aScreen < 1440) {
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
			WebUI.click(findTestObject('Object Repository/Page_SignIn/menu_Sign in'))
			println('Clicked in Sign In')
		}
		else
		{
			WebUI.delay(5)
			WebUI.click(findTestObject('Object Repository/Page_SignIn/menu_Sign in'))
			WebUI.delay(3)
		}
	}

	//method to click on checkout and proceed button in signIn page
	def static void ClickSignInCheckoutButton() {
		WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Proceed to checkout_1'))
	}
}
