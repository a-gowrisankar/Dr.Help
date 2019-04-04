package Dr.Help;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Admin_DDL {

	
	JFrame ADDL = new JFrame("Admin DDL Screen");
	JLabel cp,cpn,conText, lImg, welcomSec;
	JButton SelectOption, InsertOption, UpdateOption, DeleteOperation, goBack;
	JTextArea populateStatement;
	ImageIcon img;
	Color c;
	
	Admin_DDL_Execute ADDLE = new Admin_DDL_Execute();
	
	public Admin_DDL()
	{
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADDL.getContentPane().setBackground(c);
		
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		
		welcomSec = new JLabel("Please Select Your Option To Proceed");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		SelectOption = new JButton("Select");
		SelectOption.setBounds(530,200,170,20);
		SelectOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		SelectOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADDLE.Admin_DDL_Select();
				ADDL.setVisible(false);
			}
		});
		
		
			
		
		InsertOption = new JButton("Insert");
		InsertOption.setBounds(730,200,170,20);
		InsertOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		InsertOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADDLE.Admin_DDL_Insert();
				ADDL.setVisible(false);
			}
		});
		
		
		UpdateOption = new JButton("Update");
		UpdateOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		UpdateOption.setBounds(930, 200, 170, 20);
		UpdateOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADDLE.Admin_DDL_Update();
				ADDL.setVisible(false);
			}
		});
		
		
		DeleteOperation = new JButton("Delete");
		DeleteOperation.setFont(new Font("Calibri", Font.PLAIN, 15));
		DeleteOperation.setBounds(530, 250, 170, 20);
		DeleteOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADDLE.Admin_DDL_Delete();
				ADDL.setVisible(false);
			}
		});
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(930, 250, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Screen();
				ADDL.setVisible(false);
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
		
		ADDL.add(cp);
		ADDL.add(cpn);
		ADDL.add(conText);
		ADDL.add(lImg);
		ADDL.add(welcomSec);
		ADDL.add(SelectOption);
		ADDL.add(InsertOption);
		ADDL.add(UpdateOption);
		ADDL.add(DeleteOperation);
		ADDL.add(goBack);
	
		ADDL.setSize(1500, 1500);
		ADDL.setLayout(null);
		ADDL.setVisible(true);
	}


}
