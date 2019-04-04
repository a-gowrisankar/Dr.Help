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

public class Admin_DML {

	JFrame ADML = new JFrame("Admin DML Screen");
	JLabel cp,cpn,conText, lImg, welcomSec;
	JButton CreateOption, AlterOption, UpdateOption, DropOperation, goBack;
	JTextArea populateStatement;
	ImageIcon img;
	Color c;
	
	Admin_DML_Execute ADMLE = new Admin_DML_Execute();
	
	public Admin_DML()
	{
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADML.getContentPane().setBackground(c);
		
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		
		welcomSec = new JLabel("Please Select Your Option To Proceed");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		CreateOption = new JButton("Create");
		CreateOption.setBounds(530,200,170,20);
		CreateOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		CreateOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADMLE.Admin_DDL_Create();
				ADML.setVisible(false);
			}
		});
		
		
			
		
		AlterOption = new JButton("Alter");
		AlterOption.setBounds(730,200,170,20);
		AlterOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		AlterOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADMLE.Admin_DDL_Alter();
				ADML.setVisible(false);
			}
		});
		
		
		DropOperation = new JButton("Drop");
		DropOperation.setFont(new Font("Calibri", Font.PLAIN, 15));
		DropOperation.setBounds(930, 200, 170, 20);
		DropOperation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADMLE.Admin_DDL_Drop();
				ADML.setVisible(false);
			}
		});
		
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(730, 250, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Screen();
				ADML.setVisible(false);
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
		
		ADML.add(cp);
		ADML.add(cpn);
		ADML.add(lImg);
		ADML.add(conText);
		ADML.add(welcomSec);
		ADML.add(CreateOption);
		ADML.add(AlterOption);
		ADML.add(DropOperation);
		ADML.add(goBack);
	
		ADML.setSize(1500, 1500);
		ADML.setLayout(null);
		ADML.setVisible(true);
	}
}
