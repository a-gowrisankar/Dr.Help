/*
 * 
 * Author: AnanthaRaman Chandar
 * Course: Object Oriented Analysis and Design ITMD 510
 * Description: Bank of IIT Record Generation Lab Program - This program performs the below functionalities 
 * --> Initiates DB Connection to Papa Server
 */

package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Connector {

	//Papa Server DB Connection
	public static Connection getConnection() throws Exception {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@www.papademas.net:1521:orcl";
			String username = "ora_aag";
			String password = "oracle";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);

			
			return conn;
		}
		
		catch (Exception e) 
			{
			System.out.println("Error "+e);
			}

			return null;
	}
	
	
	
}
