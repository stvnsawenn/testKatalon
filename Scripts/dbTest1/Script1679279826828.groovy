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

import java.sql.ResultSetMetaData
import org.postgresql.jdbc.PgResultSet


//String url = 'localhost:5433'
//String dbname = 'kingpack_db_0309'
//String username = 'odoo2'
//String password = 'odoo2'

String url = 'localhost:5432'
String dbname = 'porto_db_01_30'
String username = 'odoo'
String password = 'odoo'

// Connect to database
CustomKeywords.'db1.postgresql.connectDB'(url, dbname, username, password)

// Execute query
String selectData = 'SELECT * FROM res_partner'
List<Map<String, Object>> rowList = CustomKeywords.'db1.postgresql.executeQuery'(selectData)

// Display result
//println('--------------- Lokasi = ' + rowList.get(0).get(1) + '---------------')
println(rowList.get(0).get('name'))

// Disconnect
CustomKeywords.'db1.postgresql.closeDatabaseConnection'()

