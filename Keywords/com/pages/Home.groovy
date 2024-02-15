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

// Common methods for Home Page

public class Home {

	//method to navigate to the home page by clicking on the Home link in the main menu
	def static void ClickHomeButton() {
		WebUI.click(findTestObject('Object Repository/Page_Homepage/a_Home'))
	}


		/**
		 * Method to enter the product name and click on search button
		 * @param :Product Name
		 *
		 */
		def static void ProductSeach(productName) {
			int aScreen = WebUI.getPageWidth()
			println(aScreen)
			if (aScreen < 1440) {
				println('Entered the resposive web ')
				WebUI.delay(5)
				println('before clicking Filters ')
				WebUI.click(findTestObject('Page_Homepage/a_Filters'))
			}
			WebUI.setText(findTestObject('Object Repository/Page_Homepage/input_SearchBox'), productName)
			WebUI.click(findTestObject('Object Repository/Page_Homepage/buttonSearch'))
		}

		/**
		 * Method to check the search results in the home page contain the passed product name
		 * @param :Product Name
		 *
		 */
		def static void CheckProductSearchResult(productName) {
			TestObject testObj = findTestObject('Object Repository/Page_Homepage/searchResult')
			List<WebElement> searchData = WebUI.findWebElements(testObj, 10)
			for (WebElement item : searchData) {
				println('chartName:++++++' + item.getText())

				WebUI.verifyMatch(item.getText(), ('^.*' + productName) + '.*', true, FailureHandling.STOP_ON_FAILURE)
			}
		}

		/**
		 * Method to click on the first product after the search
		 * @param :Product Name
		 *
		 */
		def static void ClickProductName(productName) {
			WebUI.click(findTestObject('Object Repository/Page_Homepage/searchResult'))
		}
	}
