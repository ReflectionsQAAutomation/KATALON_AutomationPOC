import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.pages.Home as HomePage
import groovy.json.JsonSlurper
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class NewTestListener {
//	/**
//	 * Executes before every test case starts.
//	 * @param testCaseContext related information of the executed test case.
//	 */
//	@BeforeTestCase
//	def sampleBeforeTestCase() {
//		WebUI.openBrowser('')
//		WebUI.navigateToUrl(GlobalVariable.URL)
//		WebUI.maximizeWindow()
//	}
//
//	/**
//	 * Executes after every test case ends.
//	 * @param testCaseContext related information of the executed test case.
//	 */
//	@AfterTestCase
//	def sampleAfterTestCase() {
//		WebUI.closeBrowser()
//	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.URL)
		WebUI.maximizeWindow()
		
		 def responseLogin = WS.sendRequestAndVerify(findTestObject('API Repository/Login')) 
		JsonSlurper slurper = new JsonSlurper()
		Map parsedJson = slurper.parseText(responseLogin.getResponseText())
		String passwordToken = parsedJson.access_token	
		println("----------token---------------"+passwordToken)
		WebUI.executeJavaScript("window.localStorage.setItem('auth-token','"+passwordToken+"')", null)
		WebUI.waitForPageLoad(10)
//		TestObject testObj = findTestObject('Object Repository/Page_Homepage/a_Home')
//		WebElement element = WebUI.findWebElement(testObj, 5)
//		WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(element))

//		println('Home clicked')
		WebUI.click(findTestObject('Object Repository/Page_Homepage/icon_ToolShop'))
		//WebUI.navigateToUrl('https://practicesoftwaretesting.com/#/account')
		
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		WebUI.closeBrowser()
	}
}