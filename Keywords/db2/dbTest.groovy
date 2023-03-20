package db2

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

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.Driver

public class dbTest {

	private static Connection connection = null;

	@Keyword		// Connect to database
	def connectDB(String url, String dbname, String username, String password) {
		String link = "jdbc:postgresql://" + url + "/" + dbname
		if (connection != null && connection.isClosed()) {
			connection.close()
		}
		connection =  DriverManager.getConnection(link, username, password)
		return connection
	}

	@Keyword
	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)
//		rs.next()
		while(rs.next()) {
			println(rs.getString("name") + " - " + rs.getString("city"))
		}
	}

	@Keyword 		// Closing the connection
	def closeDatabaseConnection() {
		if (connection != null && !connection.isClosed()) {
			connection.close()
		}
		connection = null
	}
}
