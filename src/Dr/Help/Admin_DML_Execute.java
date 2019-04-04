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

public class Admin_DML_Execute {

	JFrame ADMLE = new JFrame("Admin DDL Execute Screen");
	JLabel cp,cpn,conText, lImg, welcomSec, TicketNumber, QueryName;
	JButton ticketStatus, ddlOperation, dmlOperation, validateSQL, goBack;
	JTextField tTicketNumber;
	JTextArea tQuery;
	ImageIcon img;
	Color c;
	
	String Create = "CREATE TABLE [ENTER_TABLE_NAME] [ENTER COLUMN_NAME AND DATATYPE]";
	String Alter = "ALTER TABLE [ENTER_TABLE_NAME] CONSTRAINT COLUMN_NAME";
	String Drop = "DROP TABLE [ENTER_TABLE_NAME]";
	String TicketAvailable;
	int Ticketresult, ConfirmMessage;
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	public void Admin_DDL_Create()
	{
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADMLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Create Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Create);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DML();
				ADMLE.setVisible(false);
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
					EEH.TicketNumberEmpty("Admin DML Create");
				}
				else
				{
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{
				
				try {
					ResultSetFetch.validateSQLQueryDML(tQuery.getText(), "CREATE STATEMENT",tTicketNumber.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
					}
				}
			}
		});
		
		
		ADMLE.add(cp);
		ADMLE.add(cpn);
		ADMLE.add(lImg);
		ADMLE.add(conText);
		ADMLE.add(welcomSec);
		ADMLE.add(goBack);
		ADMLE.add(TicketNumber);
		ADMLE.add(tTicketNumber);
		ADMLE.add(tQuery);
		ADMLE.add(QueryName);
		ADMLE.add(validateSQL);
		ADMLE.setSize(1500, 1500);
		ADMLE.setLayout(null);
		ADMLE.setVisible(true);
	}
	
	public void Admin_DDL_Alter()
	{
		img = new ImageIcon("C:\\Users\\Wayne-PC\\Desktop\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADMLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Alter Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Alter);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DML();
				ADMLE.setVisible(false);
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
					EEH.TicketNumberEmpty("Admin DML Alter");
				}
				else
				{
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{
				try 
				{
					ResultSetFetch.validateSQLQueryDML(tQuery.getText(), "ALTER STATEMENT",tTicketNumber.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
					}}
			}
		});
		
		
		ADMLE.add(cp);
		ADMLE.add(cpn);
		ADMLE.add(lImg);
		ADMLE.add(conText);
		ADMLE.add(welcomSec);
		ADMLE.add(goBack);
		ADMLE.add(TicketNumber);
		ADMLE.add(tTicketNumber);
		ADMLE.add(tQuery);
		ADMLE.add(QueryName);
		ADMLE.add(validateSQL);
		ADMLE.setSize(1500, 1500);
		ADMLE.setLayout(null);
		ADMLE.setVisible(true);
	}
	
	public void Admin_DDL_Drop()
	{
		img = new ImageIcon("C:\\Users\\Wayne-PC\\Desktop\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADMLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Drop Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Drop);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DML();
				ADMLE.setVisible(false);
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
					ConfirmMessage = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Execute Drop Statement");
					if(ConfirmMessage == JOptionPane.YES_OPTION)
					{
					ResultSetFetch.validateSQLQueryDML(tQuery.getText(), "DROP STATEMENT",tTicketNumber.getText());
					}
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
					}
				}
			}
		});
		
		ADMLE.add(cp);
		ADMLE.add(cpn);
		ADMLE.add(lImg);
		ADMLE.add(conText);
		ADMLE.add(welcomSec);
		ADMLE.add(goBack);
		ADMLE.add(TicketNumber);
		ADMLE.add(tTicketNumber);
		ADMLE.add(tQuery);
		ADMLE.add(QueryName);
		ADMLE.add(validateSQL);
		ADMLE.setSize(1500, 1500);
		ADMLE.setLayout(null);
		ADMLE.setVisible(true);
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