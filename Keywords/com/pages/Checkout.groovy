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

// Common methods for Checkout Page

public class Checkout {

	//method to click on checkout and proceed button in checkout page
	def static void AddressProceedToCheckoutButton() {
		WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Proceed to checkout_1_2'))
	}

	/**
	 * Method to enter the details in the mandatory fields when user selects a particular payment method
	 * @param :Payment method selected by the user, 
	 * includes Bank transfer, Cash on delivery,credit card,buy now and pay later and gift card options
	 *  
	 */
	def static void PaymentAndDetails(PaymentMethod) {


		switch(PaymentMethod) {
			case "Bank Transfer":
				WebUI.selectOptionByValue(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/select_paymentMethod'),'1: Bank Transfer', true)
				WebUI.setText(findTestObject('Object Repository/Checkout/txt_bankName'),'HDFC')
				WebUI.setText(findTestObject('Object Repository/Checkout/txt_accountName'),'testName')
				WebUI.setText(findTestObject('Object Repository/Checkout/txt_accountNumber'),'123456789')
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm'))
				WebUI.verifyElementText(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/txt_Payment was successful'),
						'Payment was successful')
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm2'))
				break
			case "Cash on Delivery":
				WebUI.selectOptionByValue(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/select_paymentMethod'),'2: Cash on Delivery', true)
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm'))
				WebUI.verifyElementText(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/txt_Payment was successful'),
						'Payment was successful')
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm2'))
				break
			case "Credit Card":
				WebUI.selectOptionByValue(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/select_paymentMethod'),'3: Credit Card', true)
				WebUI.setText(findTestObject('Object Repository/Checkout/txt_creditCardNumber'),'1070-1212-8565-9999')
				WebUI.setText(findTestObject('Object Repository/Checkout/txt_expirationDate'),'12/2024')
				WebUI.setText(findTestObject('Object Repository/Checkout/txt_CVV'),'121')
				WebUI.setText(findTestObject('Object Repository/Checkout/txt_cardHolderName'),'test')
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm'))
				WebUI.verifyElementText(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/txt_Payment was successful'),
						'Payment was successful')
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm2'))

				break
			case "Buy Now Pay Later":
				WebUI.selectOptionByValue(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/select_paymentMethod'),'4: Buy Now Pay Later', true)
				WebUI.selectOptionByValue(findTestObject('Object Repository/Checkout/select_Choose your monthly installments'),'3', true)
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm'))
				WebUI.verifyElementText(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/txt_Payment was successful'),
						'Payment was successful')
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm2'))
				break
			case "Gift Card":
				WebUI.selectOptionByValue(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/select_paymentMethod'),'5: Gift Card', true)
				WebUI.setText(findTestObject('Object Repository/Checkout/txt_cardNumber'),'123456')
				WebUI.setText(findTestObject('Object Repository/Checkout/txt_validationCode'),'121')
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm'))
				WebUI.verifyElementText(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/txt_Payment was successful'),
						'Payment was successful')
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm2'))
				break
			default:break
		}
	}
}
