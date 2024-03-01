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
import org.openqa.selenium.WebElement as WebElement

/**
 * Test Case: User adding the product to cart and checkout
 * Description: This testcase covers the End to end flow of user searching for a product,adding to cart and checking out 
 *
 */
//SignInPage.ClickSignInLink()
//WebUI.delay(3)
//SignInPage.EnterDetailsAndLogin(Email, Password)
//extracting the product details from the excel which is sepearted using commas(,) and adding into the cart

for (def ProductName : Product.split(',')) {
    HomePage.ClickHomeButton()

    HomePage.ProductSeach(ProductName)

    HomePage.ClickProductName(ProductName)

    AddToCartPage.AddtoCartButton()

    WebUI.delay(5)
}

AddToCartPage.ClickShoppingCart()
WebUI.delay(5)

//extracting the product details from the excel which is sepearted using commas(,) and deleting from the cart
for (def deleteItem : DeleteProduct.split(',')) {
    AddToCartPage.DeleteItem(deleteItem)

    WebUI.delay(20)
}

//asserting to see if the deleteed items doesnot present in the cart
TestObject testObj = findTestObject('Object Repository/Checkout/Page_Practice Software Testing - Toolshop - v5.0/cart_ItemProductName')

List<WebElement> productAdded = WebUI.findWebElements(testObj, 10)

for (WebElement item : productAdded) {
    assert !(DeleteProduct.contains(item.getText().trim()))
}

