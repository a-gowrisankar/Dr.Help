package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Dr.Help.Admin_Screen;
import Dr.Help.IssueDescription;
import Dr.Help.Login_All;
import Dr.Help.Management_Report;
import Dr.Help.UserAppConfirmation;
import ErrorHandler.Login_Error;

public class ResultSetFetch {
	static	ResultSet rs;
	static int EmailID_Check;
	static String PasswordFromDB;
	static int TicketID_Validate;
	
	static Login_Error LE = new Login_Error();
	
	
	// Validate Login Details
	public static  ResultSet  getLoginDetails(String EmailId, String Password, String Category) throws Exception
	{
			System.out.println(Category);
			if(Category.equals("USER"))
			 {
				
					
					String result =(getEmailCount(Category, EmailId)); // Check for the Category and EmailID 
					System.out.println("Method Over Now Results");
					System.out.println("Password from DB is "+result);
					System.out.println("Password From LoginScreen is "+Password);
					
					if(result.equals(Password))
					{
						System.out.println("Password Validation done");
						String AccountLocked = getAccountStatus(Category,EmailId);
							if(AccountLocked.equals("N"))
							{
								new IssueDescription();
								updateLoginTime(Category, EmailId);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Your Account is Locked. Please Raise a Request To Get Your Account Unlocked");
								LE.accountLockedUser();
								new Login_All();
							}
					}
					else if(result.equals("0"))
					{
						JOptionPane.showMessageDialog(null, "UserName Not Found. Please Register Yourself To Access Dr.Help");
						LE.wrongDomainLoginUser();
						new Login_All();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Incorrect Password For the Registered User. Please Try Again");
						LE.wrongEmailIDAndPasswordUser();
						new Login_All();
					}
					
			  }
					
			
			else if(Category.equals("DOCTOR"))
			{
				System.out.println("Searching Doctor Table");
				String result =(getEmailCount(Category, EmailId));
				System.out.println("Method Over Now Results");
				System.out.println("Password from DB is "+result);
				System.out.println("Password From LoginScreen is "+Password);
				
				if(result.equals(Password))
					{
				    	System.out.println("Password Validation done");
						String AccountLocked = getAccountStatus(Category,EmailId);
							if(AccountLocked.equals("N"))
							{
								updateLoginTime(Category, EmailId);
								JOptionPane.showMessageDialog(null, "Under Construction");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Your Account is Locked. Please Raise a Request To Get Your Account Unlocked");
								LE.accountLockedUserDoc();
								new Login_All();
							}
					}
					else if(result.equals("0"))
					{
						JOptionPane.showMessageDialog(null, "DoctorName Not Found. Please Register Yourself To Access Dr.Help");
						LE.wrongDomainLoginUserDoc();
						new Login_All();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Incorrect Password For the Registered User. Please Try Again");
						LE.wrongEmailIDAndPasswordDoc();
						new Login_All();
					}
					
				
			}
			else if(Category.equals("MANAGEMENT"))
			{
				System.out.println("Searching MANAGER Table");
				String result =(getEmailCount(Category, EmailId));
				System.out.println("Method Over Now Results");
				System.out.println("Password from DB is "+result);
				System.out.println("Password From LoginScreen is "+Password);
				
				if(result.equals(Password))
				{
					System.out.println("Password Validation done");
					System.out.println("Password Validation done");
					String AccountLocked = getAccountStatus(Category,EmailId);
						if(AccountLocked.equals("N"))
						{
							updateLoginTime(Category, EmailId);
							new Management_Report();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Your Account is Locked. Please Raise a Request To Get Your Account Unlocked");
							LE.accountLockedMgmt();
							new Login_All();
						}
				}
				else if(result.equals("0"))
				{
					JOptionPane.showMessageDialog(null, "Manager Name Not Found. Please Register Yourself To Access Dr.Help");
					LE.wrongDomainLoginMgmt();
					new Login_All();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Incorrect Password For the Registered User. Please Try Again");
					LE.wrongEmailIDAndPasswordMgmt();
					new Login_All();
				}
				
			}
			else if(Category.equals("ADMIN"))
			{
				System.out.println("Searching Admin Table");
				String result =(getEmailCount(Category, EmailId));
				System.out.println("Method Over Now Results");
				System.out.println("Password from DB is "+result);
				System.out.println("Password From LoginScreen is "+Password);
				
				if(result.equals(Password))
				{
					
					System.out.println("Password Validation done");
					String AccountLocked = getAccountStatus(Category,EmailId);
						if(AccountLocked.equals("N"))
						{
							updateLoginTime(Category, EmailId);
							new Admin_Screen();
							
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Your Account is Locked. Please Raise a Request To Get Your Account Unlocked");
							LE.accountLockedAdmin();
							new Login_All();
						}
				}
				else if(result.equals("0"))
				{
					JOptionPane.showMessageDialog(null, "Admin Name Not Found. Please Register Yourself To Access Dr.Help");
					LE.wrongDomainLoginAdmin();
					new Login_All();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Incorrect Password For the Registered User. Please Try Again");
					LE.wrongEmailIDAndPasswordAdmin();
					new Login_All();
				}
				
			}
			else
			{
				System.out.println("No Errors");
			}
			return null;
		}
		
		
		
		
	
	//UserName Access
	private static  String getEmailCount(String Category, String EmailId) throws Exception 
	{
	
		System.out.println("Searching " + Category + " Table");
		Connection conn = Models.Connector.getConnection();
			String sqlSearch = "SELECT COUNT(*)C FROM "
								+ "DH_"  + Category+"S_1" 
								+ " WHERE" + " EMAIL_ID" + "=" + "'"+ EmailId+"'" ;
		
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs = stmt.executeQuery(sqlSearch);
		while(rs.next())
		{
			EmailID_Check = rs.getInt("C");
		}
		
		if(EmailID_Check == 1)
		{
			System.out.println("Going For PD Verification");
			PasswordFromDB=getPasswordValidation(Category, EmailId);
			return PasswordFromDB;
		}
		else
			return "0";
	}
	
	//Password Validation
	private static String getPasswordValidation(String Category, String EmailId) throws Exception
	{
		
		Connection conn = Models.Connector.getConnection();
		String sqlSearch="SELECT PASSWORD FROM " 
						 +"DH_"+ Category+"S_1" 
						 + " WHERE EMAIL_ID =" + "'"+EmailId +"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs = stmt.executeQuery(sqlSearch);
		while(rs.next())
		{
			return rs.getString("PASSWORD");
			
		}
		return "1";
	}
	
	
	//Check If Account is Locked or Not
	private static String getAccountStatus(String Category, String EmailId) throws Exception 
	{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT ACCOUNT_LOCKED FROM DH_"
						  		+ Category + "S_1" 
						  		+ " WHERE EMAIL_ID ='"
						  		+ EmailId +"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs = stmt.executeQuery(sqlSearch);
		while(rs.next())
		{
			return rs.getString("ACCOUNT_LOCKED");
		}
				
		return "3";
	}
	
	
	private static void updateLoginTime(String Category, String EmailId) throws Exception
	{
	
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "UPDATE DH_"+ Category +"S_1" 
							+ " SET LAST_LOGIN = SYSTIMESTAMP"
							+" WHERE EMAIL_ID =" +"'" + EmailId +"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		stmt.executeQuery(sqlSearch);
		
	}
	
	public static ResultSet getMedRecordsByLoc(String tLocName) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+ "HOSPITAL_NAME,ADDRESS,CITY,STATE,ZIPCODE,PHONE_NUMBER "
								+ "FROM DH_HOSPLIST_1 "
								+ " WHERE CITY LIKE '" + tLocName.toUpperCase() +"%'" ;
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	public static ResultSet getMedRecordsByZip(String tZipCode) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+ "HOSPITAL_NAME,ADDRESS,CITY,STATE,ZIPCODE,PHONE_NUMBER "
								+ "FROM DH_HOSPLIST_1 "
								+ " WHERE ZIPCODE ='" + tZipCode +"'";
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	
	public static ResultSet getDocList(String Start_Date, String End_Date) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+"NAME, ADDRESS, CITY, COUNTY, STATE, ZIP, MOBILE, EMAIL_ID,"
								+"DATE_OF_JOIN, CATEGORY, SALARY, RATING, ACTIVE"
								+ " FROM DH_DOC_LIST_1 "
								+ "  WHERE DATE_OF_JOIN BETWEEN TO_DATE('" + Start_Date +"', 'MM-DD-YY')" 
								+ "AND TO_DATE('"+ End_Date +"', 'MM-DD-YY')";
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}
	
	
	//Hosp Venture Data
	public static ResultSet getHospVenture(String Start_Date, String End_Date) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+"HOSPITAL_NAME, ADDRESS, CITY, STATE, ZIPCODE, PHONE_NUMBER, DATE_OF_VENTURE"
								+ " FROM DH_HOSP_VENTURE "
								+ "  WHERE DATE_OF_VENTURE BETWEEN TO_DATE('" 	+ Start_Date +"', 'MM-DD-YY')" 
								+ "AND TO_DATE('"+ End_Date +"', 'MM-DD-YY')";
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}
	
	public static ResultSet getHospCategory(int Count) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+"H_ID, HOSPITAL_NAME, ADDRESS, CITY, STATE, ZIPCODE, PHONE_NUMBER "
								+ " FROM DH_HOSPLIST_1 "
								+ "  WHERE CATEGORY = " + Count + "ORDER BY 1 ASC" ;
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}
	
	//Fetch Admin Tickets
	public static ResultSet admin_Tickets(String Status, String Priority) throws Exception {
		try {
			Connection conn = Models.Connector.getConnection();
			String selectStat = "SELECT "
								+"TICKET_NUMBER, RAISED_BY, CONTACT_NUMBER, ISSUE_CATEGORY, "
								+ "ISSUE_DESCRIPTION,PRIORITY_LEVEL, DATE_SUBMITTED, SLA_DAYS, HOURS_REMAINING, STATUS "
								+ " FROM DH_ADMIN_TICKETS "
								+ "  WHERE STATUS = "    +"'"   + Status  +"'"  
								+ " AND PRIORITY_LEVEL  = "           + Priority ;
			System.out.println(selectStat);
			Statement stat = conn.prepareStatement(selectStat);
			rs = stat.executeQuery(selectStat);
			System.out.println("Fetched Results from DB");
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}
	
	
	// SQL Syntax Error Handler and Admin Screen Options
			public static  void validateSQLQueryDDL(String Statment, String Screen, String TicketNumber) throws Exception {
				try {

					Connection conn = Models.Connector.getConnection();
					String ValidateSQLStatement= Statment;
					Statement stmt = conn.createStatement();
					System.out.println(ValidateSQLStatement);
					int result = stmt.executeUpdate(ValidateSQLStatement);
					System.out.println("Statement "+ result);
					if (result == 1) 
					{
						JOptionPane.showMessageDialog(null, "SQL Query Executed Successfully");
						updateClosedTicketTime(TicketNumber);
						new Admin_Screen();
					} 
					
				}
					catch (Exception e)
				{
					System.out.println("Error");
					InsertInToDB.SQLSyntaxErrorMessage(e.getMessage(), Statment, Screen);
					JOptionPane.showMessageDialog(null, "Syntax Error. Please Check DH_SQL_ERRORS_1 Table For More Details");
						
				}
				
			}
			
	
	   // SQL Syntax Error Handler and Admin Screen Options
		public static  void validateSQLQueryDML(String Statment, String Screen, String TicketNumber) throws Exception {
			try {

				Connection conn = Models.Connector.getConnection();
				String ValidateSQLStatement= Statment;
				Statement stmt = conn.createStatement();
				
				int result = stmt.executeUpdate(ValidateSQLStatement);
				System.out.println("Statement "+ result);
				if (result == 0) 
				{
					JOptionPane.showMessageDialog(null, "SQL Query Executed Successfully");
					updateClosedTicketTime(TicketNumber);
					new Admin_Screen();
				
				} 
				
			}
				catch (Exception e)
			{
				
				InsertInToDB.SQLSyntaxErrorMessage(e.getMessage(), Statment, Screen);
				JOptionPane.showMessageDialog(null, "Syntax Error. Please Check DH_SQL_ERRORS_1 Table For More Details");
					
			}
			
		}
		
		//Validate Ticket Number
	public static  String validateTicketNumber(String TicketNumber) throws Exception 
	{
	
		System.out.println("Searching Admin Tickets Table");
		Connection conn = Models.Connector.getConnection();
			String sqlSearch = "SELECT COUNT(*)C FROM "
								+ "DH_ADMIN_TICKETS"   
								+ " WHERE" + " TICKET_NUMBER" + "=" + "'"+ TicketNumber+"'"
								+ " AND STATUS = 'Open'";
		
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs = stmt.executeQuery(sqlSearch);
		while(rs.next())
		{
			TicketID_Validate = rs.getInt("C");
		}
		
		if(TicketID_Validate == 1)
		{
			return "1";
		}
		else
			return "0";
	}

	private static void updateClosedTicketTime(String TicketNumber) throws Exception
	{
	
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "UPDATE DH_ADMIN_TICKETS" 
							+ " SET STATUS = 'Closed'"      +","
							+ "TIME_CLOSED = SYSTIMESTAMP"
							+" WHERE  TICKET_NUMBER=" + TicketNumber ;
		Statement stmt = conn.prepareStatement(sqlSearch);
		stmt.executeQuery(sqlSearch);
		
	}
	public static ResultSet hosplist(String cityname,int i,int j) throws Exception
	{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT HOSPITAL_NAME FROM DH_HOSPLIST_1 WHERE CITY="+ "'"+cityname.toUpperCase()+"'"
		+"AND MEDICAL_INSURANCE="+i+"AND CATEGORY ="+1;
		System.out.println(sqlSearch);
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
	}
	
	public static ResultSet checkdate(String hosp,String date) throws Exception
	{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT TIME_SLOT FROM DH_APPOINTMENT WHERE HOSPITAL_NAME="+ "'"+hosp.toUpperCase()+"'"
		+"AND DATE_SCHEDULED="+"'"+date+"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
	}
	public static ResultSet getsummary(String dte,String time,String hosp,String uname) throws Exception
	{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT * FROM DH_APPOINTMENT WHERE DATE_SCHEDULED="+ "'"+dte+"'"
		+"AND HOSPITAL_NAME="+"'"+hosp+"'" +"AND U_EMAIL_ID ="+"'"+uname+"'"+"AND TIME_SLOT="+"'"+time+"'";
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
	}
	public static ResultSet docname(String hosp, String cityname,int i,int j) throws Exception
	{
		Connection conn = Models.Connector.getConnection();
		String sqlSearch = "SELECT DOCTOR_NAME FROM DH_HOSPLIST_1  WHERE HOSPITAL_NAME ='"+hosp+"'"+" AND CITY="+ "'"+cityname.toUpperCase()+"'"
		+"AND MEDICAL_INSURANCE="+i+"AND CATEGORY ="+1;
		Statement stmt = conn.prepareStatement(sqlSearch);
		rs=stmt.executeQuery(sqlSearch);
		return rs;
	}
	
}
