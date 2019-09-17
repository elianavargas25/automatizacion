package co.com.quipux.wat

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.ResultSetMetaData


import com.kms.katalon.core.annotation.Keyword
import oracle.jdbc.driver.OracleConnection as Connection

public class checkDataBase{


	private static Connection connection = null;

	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */

	@Keyword
	def boolean checkDB(String url, String dbname, String port, String username, String password){
		try {
			connectDB( url,  dbname,  port,  username,  password)
			closeDatabaseConnection()
			return true
		}
		catch (Exception e) {
			WebUI.comment(e.message)
			return false
		}
	}


	//Establishing a connection to the DataBase

	@Keyword
	def connectDB(String url, String dbname, String port, String username, String password){

		//Load driver class for your specific database type

		String conn = "jdbc:oracle:thin:@//" + url + ":" + port + "/" + dbname
		WebUI.comment(conn)

		Class.forName("oracle.jdbc.OracleDriver");

		//String connectionString = "jdbc:sqlite:" + dataFile

		if(connection != null && !connection.isClosed()){

			connection.close()

		}

		connection = DriverManager.getConnection(conn, username, password)

		return connection

	}

	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */

	//Executing the constructed Query and Saving results in resultset

	@Keyword

	def executeQuery(String queryString) {

		Statement stm = connection.createStatement()

		ResultSet rs = stm.executeQuery(queryString)

		ResultSetMetaData metadata = rs.getMetaData()
		int columnCount = metadata.getColumnCount()
		List<List<String>> rowList = new LinkedList<List<String>>()
		while (rs.next())
		{
			List<String> row = new LinkedList<>()
			for(int i = 1; i <=columnCount; i++) {
				Object value = rs.getObject(i)
				row.add(value)
			}
			rowList.add(row)
		}
		for(List<String> row: rowList) {

			for(String data: row) { System.out.print(data + " ") }
			System.out.println() }
		return rowList


	}

	//Closing the connection

	@Keyword

	def closeDatabaseConnection() {

		if(connection != null && !connection.isClosed()){

			connection.close()

		}

		connection = null

	}
	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */

	@Keyword

	def execute(String queryString) {

		Statement stm = connection.createStatement()

		boolean result = stm.execute(queryString)

		return result

	}

}