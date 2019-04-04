package Dr.Help;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ErrorHandler.EmptyFields_Error_Handler;
import Models.ResultSetFetch;

public class Admin_DCL_Execute {
	
	
	//Declare Swing Components
	JFrame ADCLE = new JFrame("Admin DCL Execute Screen");
	JLabel cp,cpn,conText, lImg, welcomSec, TicketNumber, QueryName;
	JButton ticketStatus, ddlOperation, dmlOperation, validateSQL, goBack;
	JTextField tTicketNumber;
	JTextArea tQuery;
	ImageIcon img;
	Color c;
	
	
	//To populate DCL Syntax in the Text Area
	String Grant= "GRANT [PRIVILEGE_TYPE] ON [TABLE_NAME] TO [GRANTEES]";
	String Revoke = "GRANT [PRIVILEGE_TYPE] ON [TABLE_NAME] FROM [GRANTEES]";
	
	String TicketAvailable; //Validate ticketNumber
	int Ticketresult; // Ticket available or not
	
	
	// Reference Objects for handling Empty Fields
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
		
	
	/*
	 * 
	 * Below is to Generate DCL Grant Operations Screen
	 * 
	 */
	public void Admin_DDL_Grant()
	{
		
		//Display Symbol of medicine
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADCLE.getContentPane().setBackground(c);
		
		
		//Header Text
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		//JLabel Attributes
		welcomSec = new JLabel("Enter Your Database Query");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		//Copyrights of the project
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		//Ticket Number Label
		TicketNumber = new JLabel("Enter Reference Ticket Number");
		TicketNumber.setFont(new Font("Calibri", Font.PLAIN, 15));
		TicketNumber.setBounds(550, 200, 250, 20);
		
		
		//Ticket Number Text
		tTicketNumber = new JTextField();
		tTicketNumber.setFont(new Font("Calibri", Font.PLAIN, 15));
		tTicketNumber.setBounds(820, 200, 120, 20);
		
		//Display Grant Query Syntax
		QueryName = new JLabel("Grant Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Grant);
		
		
		//Go Back one screen
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DCL(); // Navigate to DCL Main Menu Screen
				ADCLE.setVisible(false);
			}
		});
		
		validateSQL = new JButton("Validate SQL Query");
		validateSQL.setFont(new Font("Calibri", Font.PLAIN, 15));
		validateSQL.setBounds(730, 450, 170, 20);
		validateSQL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tTicketNumber.getText().equals("")) // Check whether Ticket Number field is empty
				{
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number"); //Display Message
					EEH.TicketNumberEmpty("Admin DML Drop");
				}
				else
				{
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{
				try {
					ResultSetFetch.validateSQLQueryDML(tQuery.getText(), "GRANT STATEMENT", tTicketNumber.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
					}
				}
			}
		});
		
		
		ADCLE.add(cp);
		ADCLE.add(cpn);
		ADCLE.add(lImg);
		ADCLE.add(conText);
		ADCLE.add(welcomSec);
		ADCLE.add(goBack);
		ADCLE.add(TicketNumber);
		ADCLE.add(tTicketNumber);
		ADCLE.add(tQuery);
		ADCLE.add(QueryName);
		ADCLE.add(validateSQL);
		ADCLE.setSize(1500, 1500);
		ADCLE.setLayout(null);
		ADCLE.setVisible(true);
	}
	
	public void Admin_DDL_Revoke()
	{
		img = new ImageIcon("C:\\Users\\Wayne-PC\\Desktop\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADCLE.getContentPane().setBackground(c);
		
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		
		welcomSec = new JLabel("Enter Your Database Query");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		TicketNumber = new JLabel("Enter Reference Ticket Number");
		TicketNumber.setFont(new Font("Calibri", Font.PLAIN, 15));
		TicketNumber.setBounds(550, 200, 250, 20);
		
		
		tTicketNumber = new JTextField();
		tTicketNumber.setFont(new Font("Calibri", Font.PLAIN, 15));
		tTicketNumber.setBounds(820, 200, 120, 20);
		
		
		QueryName = new JLabel("Select Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Revoke);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DCL();
				ADCLE.setVisible(false);
			}
		});
		
		validateSQL = new JButton("Validate SQL Query");
		validateSQL.setFont(new Font("Calibri", Font.PLAIN, 15));
		validateSQL.setBounds(730, 450, 170, 20);
		validateSQL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tTicketNumber.getText().equals(""))
				{
					JOptionPane.showMessageDialog(tTicketNumber, "Please Input Your Reference Number");
					EEH.TicketNumberEmpty("Admin DML Drop");
				}
				else
				{
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{
				
				try {
					ResultSetFetch.validateSQLQueryDML(tQuery.getText(), "REVOKE STATEMENT",tTicketNumber.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
					}
				}
			}
		});
		
		
		ADCLE.add(cp);
		ADCLE.add(cpn);
		ADCLE.add(conText);
		ADCLE.add(lImg);
		ADCLE.add(welcomSec);
		ADCLE.add(goBack);
		ADCLE.add(TicketNumber);
		ADCLE.add(tTicketNumber);
		ADCLE.add(tQuery);
		ADCLE.add(QueryName);
		ADCLE.add(validateSQL);
		ADCLE.setSize(1500, 1500);
		ADCLE.setLayout(null);
		ADCLE.setVisible(true);
	}
	
	//Validate TicketNumber against DB
	public int validateTicket()
	{
		
		
		System.out.println(tQuery.getText());
		try {
			
			TicketAvailable = Models.ResultSetFetch.validateTicketNumber(tTicketNumber.getText());
			if(TicketAvailable.equals("1"))
			{
				return 1;
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Invalid Ticket Number or Ticket is Not Open");
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return 0;
		
		
	}
}