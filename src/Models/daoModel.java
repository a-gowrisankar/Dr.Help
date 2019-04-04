package Models;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;



public class daoModel {
	 Connection conn = null;
	   Statement stmt = null;

	public static Connection createTableDBMS() throws Exception {
		try {

		   Connection conn = Connector.getConnection();
			
			String createTabCmd = "CREATE TABLE AC_CHAN_TAB (PID INTEGER , ID VARCHAR2(10) NOT NULL PRIMARY KEY, INCOME NUMBER(8,2), PEP VARCHAR(3))";
			Statement stmt = conn.createStatement();
			System.out.println(createTabCmd);
			int result = stmt.executeUpdate(createTabCmd);
			if (result == 0) {
				System.out.println("Table Creation Success in Papa Server");
			
			} else {
				System.out.println("Table Creation Failed in Papa Server");
			}
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
}

public static void main(String[] args) throws Exception
{
	Models.Connector.getConnection();
	createTableDBMS();
}
	
}
