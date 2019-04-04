package Models;

import java.sql.Connection;
import java.sql.Statement;

public class DBTables {

	public static Connection createTableDH_USERS() throws Exception {
		try {

			Connection conn = Connector.getConnection();

			String createTabCmd = "CREATE TABLE DH_USERS\r\n" + "(\r\n" + "U_ID INTEGER,\r\n" + "NAME VARCHAR2(50),\r\n"
					+ "PASSWORD VARCHAR2(50),\r\n" + "DOB DATE,\r\n" + "EMAIL_ID VARCHAR2(50) NOT NULL PRIMARY KEY,\r\n"
					+ "MOBILE INTEGER,\r\n" + "DATE_OF_REGISTRATION DATE DEFAULT SYSTIMESTAMP,\r\n"
					+ "LAST_LOGIN TIMESTAMP, \r\n" + "LAST_LOGOUT TIMESTAMP\r\n" + ")";
			System.out.println(createTabCmd);
			Statement stmt = conn.createStatement();

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

	
}
