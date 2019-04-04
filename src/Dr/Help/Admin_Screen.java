package Dr.Help;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin_Screen {

	JFrame AS = new JFrame("Admin Screen");
	JLabel cp,cpn,conText, lImg, welcomSec;
	JButton ticketStatus, ddlOperation, dmlOperation, dclOperation;
	JTextField sDate, eDate;
	ImageIcon img;
	Color c;
	
	public Admin_Screen()
	{

		
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		AS.getContentPane().setBackground(c);
		
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		
		welcomSec = new JLabel("Please Select Your Option To Proceed");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		ticketStatus = new JButton("View Open Tickets");
		ticketStatus.setBounds(530,200,170,20);
		ticketStatus.setFont(new Font("Calibri", Font.PLAIN, 15));
		ticketStatus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminTickets_Status();
				AS.setVisible(false);
			}
		});
		
		
		
		ddlOperation = new JButton("DDL");
		ddlOperation.setBounds(730,200,170,20);
		ddlOperation.setFont(new Font("Calibri", Font.PLAIN, 15));
		ddlOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DDL();
				AS.setVisible(false);
			}
		});
		
		
		
		dmlOperation = new JButton("DML");
		dmlOperation.setFont(new Font("Calibri", Font.PLAIN, 15));
		dmlOperation.setBounds(930, 200, 170, 20);
		dmlOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DML();
				AS.setVisible(false);
			}
		});
		
		
		
		dclOperation = new JButton("DCL");
		dclOperation.setFont(new Font("Calibri", Font.PLAIN, 15));
		dclOperation.setBounds(530, 250, 170, 20);
		dclOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_DCL();
				AS.setVisible(false);
			}
		});
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		
		
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		AS.add(cp);
		AS.add(cpn);
		AS.add(lImg);
		AS.add(conText);
		AS.add(welcomSec);
		AS.add(ticketStatus);
		AS.add(ddlOperation);
		AS.add(dmlOperation);
		AS.add(dclOperation);
		
		AS.setSize(1500, 1500);
		AS.setLayout(null);
		AS.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Admin_Screen();
	}
}
