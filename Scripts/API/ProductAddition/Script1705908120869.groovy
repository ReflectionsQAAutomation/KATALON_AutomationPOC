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
import groovy.json.JsonSlurper as JsonSlurper

// getting the product List details that need to be added into cart  and storing in  variable products
responseProduct = WS.sendRequestAndVerify(findTestObject('API Repository/GetProducts'))
WS.verifyResponseStatusCode(responseProduct, 200)
products = WS.getElementPropertyValue(responseProduct, 'data.id')
println('Product List---' + products)

// creating a new cart and storing the cart id
responseNewCart = WS.sendRequestAndVerify(findTestObject('API Repository/CreateNewCart'))
WS.verifyResponseStatusCode(responseNewCart, 201)
JsonSlurper slurper = new JsonSlurper()
Map parsedJson = slurper.parseText(responseNewCart.getResponseText())
String cart_Id = parsedJson.id
println(cart_Id)
GlobalVariable.CART_ID = cart_Id
println(GlobalVariable.CART_ID)

// Getting the details of the cart using  get cart details API and verify the id of the cart in the response is same as the created cart.
responseAddCart = WS.sendRequestAndVerify(findTestObject('API Repository/GetCartDetails'))
WS.verifyResponseStatusCode(responseAddCart, 200)
def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(responseAddCart.getResponseText())
println(jsonResponse.id)
//verifying the card id is same as the id in the response of the getCartDetails API
WS.verifyMatch(jsonResponse.id, cart_Id, false)

// Adding the product  into the cart that is created before. Add Product Cart API is called.
for(int n=0; n<3; n++)
{
responseAddedProducts = WS.sendRequestAndVerify(findTestObject('API Repository/AddProductsCart',[('productID'):(products[n])]))
WS.verifyResponseStatusCode(responseAddedProducts, 201)
}
// getting the details in the cart by calling GetCartDetails
responseViewCart = WS.sendRequestAndVerify(findTestObject('API Repository/GetCartDetails'))
WS.verifyResponseStatusCode(responseViewCart, 200)
def jsonResponseViewCart = jsonSlurper.parseText(responseViewCart.getResponseText())
println(jsonResponseViewCart.cart_items.product_id)

//verifying the product id listed in the Cart is same as the one that is added
for(int n=0; n<3; n++)
{
WS.verifyMatch(jsonResponseViewCart.cart_items[n].product_id,products[n], false)
}	
WS.delay(20)

