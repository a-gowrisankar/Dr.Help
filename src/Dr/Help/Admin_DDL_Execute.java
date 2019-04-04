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

public class Admin_DDL_Execute {

	
	JFrame ADDLE = new JFrame("Admin DDL Execute Screen");
	JLabel cp,cpn,conText, lImg, welcomSec, TicketNumber, QueryName;
	JButton ticketStatus, ddlOperation, dmlOperation, validateSQL, goBack;
	JTextField tTicketNumber;
	JTextArea tQuery;
	ImageIcon img;
	Color c;
	
	String Select = "SELECT * FROM [ENTER_TABLE_NAME] ";
	String Insert = "INSERT INTO [ENTER_TABLE_NAME] VALUES[ENTER VALUES]";
	String Update = "UPDATE [ENTER_TABLE_NAME] SET [ENTER_COLUMN_NAME] WHERE [ENTER_CONDITION]";
	String Delete = "DELETE FROM [ENTER_TABLE_NAME] WHERE [ENTER_CONDITION]";
	String TicketAvailable;
	int Ticketresult, ConfirmMessage;
	String SQL_Syntax_Status;
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	public void Admin_DDL_Select()
	{
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADDLE.getContentPane().setBackground(c);
		
		
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
		tQuery.setText(Select);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DDL();
				ADDLE.setVisible(false);
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
					EEH.TicketNumberEmpty("Admin DDL Select");
				}
				else
				{
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{
					
					}
					
				}
				
				
				
			}
		});
		
		
		ADDLE.add(cp);
		ADDLE.add(cpn);
		ADDLE.add(lImg);
		ADDLE.add(conText);
		ADDLE.add(welcomSec);
		ADDLE.add(goBack);
		ADDLE.add(TicketNumber);
		ADDLE.add(tTicketNumber);
		ADDLE.add(tQuery);
		ADDLE.add(QueryName);
		ADDLE.add(validateSQL);
		ADDLE.setSize(1500, 1500);
		ADDLE.setLayout(null);
		ADDLE.setVisible(true);
	}
	
	public void Admin_DDL_Insert()
	{
		img = new ImageIcon("C:\\Users\\Wayne-PC\\Desktop\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADDLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Insert Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Insert);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DDL();
				ADDLE.setVisible(false);
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
					EEH.TicketNumberEmpty("Admin DDL Insert");
				}
				else
				{
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{
						try {
						ResultSetFetch.validateSQLQueryDDL(tQuery.getText(), "INSERT STATEMENT",tTicketNumber.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						
						e1.printStackTrace();
					}
					}
					
				}
				
				
				
				
			}
		});
		
		ADDLE.add(cp);
		ADDLE.add(cpn);
		ADDLE.add(lImg);
		ADDLE.add(conText);
		ADDLE.add(welcomSec);
		ADDLE.add(goBack);
		ADDLE.add(TicketNumber);
		ADDLE.add(tTicketNumber);
		ADDLE.add(tQuery);
		ADDLE.add(QueryName);
		ADDLE.add(validateSQL);
		ADDLE.setSize(1500, 1500);
		ADDLE.setLayout(null);
		ADDLE.setVisible(true);
	}
	
	public void Admin_DDL_Update()
	{
		img = new ImageIcon("C:\\Users\\Wayne-PC\\Desktop\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADDLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Update Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Update);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DDL();
				ADDLE.setVisible(false);
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
					EEH.TicketNumberEmpty("Admin DDL Update");
				}
				else
				{
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{
						try {
							ResultSetFetch.validateSQLQueryDDL(tQuery.getText(), "UPDATE STATEMENT",tTicketNumber.getText());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							
							e1.printStackTrace();
						}
					}
					
				}
				
				
				
				
			}
		});
		
		
		ADDLE.add(cp);
		ADDLE.add(cpn);
		ADDLE.add(lImg);
		ADDLE.add(conText);
		ADDLE.add(welcomSec);
		ADDLE.add(goBack);
		ADDLE.add(TicketNumber);
		ADDLE.add(tTicketNumber);
		ADDLE.add(tQuery);
		ADDLE.add(QueryName);
		ADDLE.add(validateSQL);
		ADDLE.setSize(1500, 1500);
		ADDLE.setLayout(null);
		ADDLE.setVisible(true);
	}
	
	public void Admin_DDL_Delete()
	{
		img = new ImageIcon("C:\\Users\\Wayne-PC\\Desktop\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADDLE.getContentPane().setBackground(c);
		
		
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
		
		
		QueryName = new JLabel("Delete Query");
		QueryName.setFont(new Font("Calibri", Font.BOLD, 15));
		QueryName.setBounds(550, 280, 120, 20);
		
		tQuery = new JTextArea();
		tQuery.setLineWrap(true);
		tQuery.setWrapStyleWord(true);
		tQuery.setFont(new Font("Calibri", Font.PLAIN, 15));
		tQuery.setBounds(550,300, 400, 100);
		tQuery.setText(Delete);
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(530, 450, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DDL();
				ADDLE.setVisible(false);
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
					EEH.TicketNumberEmpty("Admin DDL Delete");
				}
				else
				{
					Ticketresult = validateTicket();
					if(Ticketresult == 1)
					{
						try {
							ConfirmMessage = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete?");
							if(ConfirmMessage == JOptionPane.YES_OPTION);
							{
							ResultSetFetch.validateSQLQueryDDL(tQuery.getText(), "DELETE STATEMENT",tTicketNumber.getText());
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							
							e1.printStackTrace();
						}
					}
					
				}
				
				
				
			}
		});
		
		ADDLE.add(cp);
		ADDLE.add(cpn);
		ADDLE.add(lImg);
		ADDLE.add(conText);
		ADDLE.add(welcomSec);
		ADDLE.add(goBack);
		ADDLE.add(TicketNumber);
		ADDLE.add(tTicketNumber);
		ADDLE.add(tQuery);
		ADDLE.add(QueryName);
		ADDLE.add(validateSQL);
		ADDLE.setSize(1500, 1500);
		ADDLE.setLayout(null);
		ADDLE.setVisible(true);
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

