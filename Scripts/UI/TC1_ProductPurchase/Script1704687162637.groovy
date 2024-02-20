import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.pages.SignIn as SignInPage
import com.pages.Home as HomePage
import com.pages.AddToCart as AddToCartPage
import com.pages.Checkout as CheckoutPage
import com.pages.SignOut as SignOutPage
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

/**
 * Test Case: User adding the product to cart and checkout
 * Description: This testcase covers the End to end flow of user searching for a product,adding to cart and checking out 
 *
 */

//SignInPage.ClickSignInLink()
//SignInPage.EnterDetailsAndLogin(Email, Password)
HomePage.ClickHomeButton()
HomePage.ProductSeach(ProductName)
HomePage.ClickProductName(ProductName)
AddToCartPage.AddtoCartButton()
AddToCartPage.ClickShoppingCart()
AddToCartPage.CartCheckout()
SignInPage.ClickSignInCheckoutButton()
CheckoutPage.AddressProceedToCheckoutButton()
CheckoutPage.PaymentAndDetails(PaymentMethod)
WebUI.verifyElementText(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/txt_Payment was successful'),
	'Payment was successful')
WebUI.click(findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/button_Confirm2'))

