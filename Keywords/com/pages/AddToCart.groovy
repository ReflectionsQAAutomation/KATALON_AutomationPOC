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
import org.openqa.selenium.WebElement as WebElement

import internal.GlobalVariable

// Common methods for Add to cart Page

public class AddToCart {

	//method to add the product to cart and checking the success message
	def static void AddtoCartButton() {
		WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Add to cart'))
		WebUI.verifyElementText(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/div_Product added to shopping cart'),'Product added to shopping cart.')
		WebUI.delay(5)
	}

	//method to navigate to the shopping cart
	def static void ClickShoppingCart() {
		WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/i_Sign out_fa fa-shopping-cart px-1'))
	}

	//method to click on checkout and proceed button in add to cart
	def static void CartCheckout() {
		WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Proceed to checkout'))
	}

	def static void DeleteItem(deleteItem) {
		TestObject testObj = findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/cart_ItemProductName')
		List<WebElement> productAdded = WebUI.findWebElements(testObj, 10)
		def indx =1
		for (WebElement item : productAdded)
		{

			println('chartName:++++++' + item.getText())
			println('++++++++++ExcelSplitName:++++++' + deleteItem)
			if(item.getText().trim().equals(deleteItem.trim()))
			{
				println('---------------Ethil keri---------')
				println(indx)
				WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/cart_ItemCloseButton', ['index' : indx]))
				break;
			}
			indx++
		}
	}
}
