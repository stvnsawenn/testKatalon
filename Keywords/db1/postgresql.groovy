package db1

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

import java.sql.ResultSet
import org.postgresql.Driver
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import org.postgresql.jdbc.PgConnection
import org.postgresql.jdbc.PgResultSet
import org.postgresql.jdbc.PgStatement
import java.sql.*
import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable

public class postgresql {
	private static PgConnection connection = null;

	@Keyword		// Connect to database
	def connectDB(String url, String dbname, String username, String password) {
		String link = "jdbc:postgresql://" + url + "/" + dbname
		if (connection != null && connection.isClosed()) {
			connection.close()
		}
		connection =  DriverManager.getConnection(link, username, password)
		return connection
	}

	@Keyword		// Execute query
	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet resultSet = stm.executeQuery(queryString)
		ResultSetMetaData metadata = resultSet.getMetaData()
		int columnCount = metadata.getColumnCount()
		List<List<String>> rowList = new LinkedList<List<String>>()
		while (resultSet.next()) {
			List<String> row = new LinkedList<>()
			for(int i = 1; i <= columnCount; i++) {
				Objects value = resultSet.getObject(i)
				row.add(value)
			}
			rowList.add(row)
		}
		for(List<String> row: rowList) {
			for(String data: row) {
				System.out.print(data + " ")
			}
			System.out.println()
		}
		return rowList
	}

	@Keyword 		// Closing the connection
	def closeDatabaseConnection() {
		if (connection != null && !connection.isClosed()) {
			connection.close()
		}
		connection = null
	}
}
