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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import java.util.Iterator;
import java.util.List
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.deleteAllCookies()

WebUI.navigateToUrl('https://ebay.com/')

WebUI.setText(findTestObject('Object Repository/Page_Electronics, Cars, Fashion, Collectibles  More  eBay/Search Bar'), 
    'iPhone')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Electronics, Cars, Fashion, Collectibl_475ffe/Select Category'), 
    '15032', true)

WebUI.click(findTestObject('Object Repository/Page_Electronics, Cars, Fashion, Collectibl_475ffe/Search Button'))

result = WebUI.getText(findTestObject('Object Repository/Page_iPhone in Cell Phones  Accessories for_674848/Results for iPhone'))

println(result)

nthProduct = WebUI.getText(findTestObject('Page_iPhone in Cell Phones  Accessories for_674848/NthProduct'))

println(nthProduct)

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> allProducts = driver.findElements(By.xpath("//div[@id='srp-river-results']/ul/li"))
Iterator<WebElement> iteratorAllProducts = allProducts.iterator();

Actions action = new Actions(driver)

while (iteratorAllProducts.hasNext()) {
    product = iteratorAllProducts.next()

    action.moveToElement(product).build().perform()

    println(product.getText())

    println('------------------------------------------------------------')
}

WebUI.closeBrowser()

