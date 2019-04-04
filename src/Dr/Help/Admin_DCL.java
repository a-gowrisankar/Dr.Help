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

public class Admin_DCL {


	JFrame ADCL = new JFrame("Admin DDL Screen");
	JLabel cp,cpn,conText, lImg, welcomSec;
	JButton GrantOption, RevokeOption, goBack;
	JTextArea populateStatement;
	ImageIcon img;
	Color c;
	
	Admin_DCL_Execute ADCLE = new Admin_DCL_Execute();
	
	public Admin_DCL()
	{
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ADCL.getContentPane().setBackground(c);
		
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		
		welcomSec = new JLabel("Please Select Your Option To Proceed");
		welcomSec.setBounds(640,100,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		GrantOption = new JButton("Grant");
		GrantOption.setBounds(530,200,170,20);
		GrantOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		GrantOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADCLE.Admin_DDL_Grant();
				ADCL.setVisible(false);
			}
		});
		
		
			
		
		RevokeOption = new JButton("Revoke");
		RevokeOption.setBounds(730,200,170,20);
		RevokeOption.setFont(new Font("Calibri", Font.PLAIN, 15));
		RevokeOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ADCLE.Admin_DDL_Revoke();
				ADCL.setVisible(false);
			}
		});
		
		
		
		
		
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(930, 200, 170, 20);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Screen();
				ADCL.setVisible(false);
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
		
		ADCL.add(cp);
		ADCL.add(cpn);
		ADCL.add(lImg);
		ADCL.add(conText);
		ADCL.add(welcomSec);
		ADCL.add(GrantOption);
		ADCL.add(RevokeOption);
		
		ADCL.add(goBack);
	
		ADCL.setSize(1500, 1500);
		ADCL.setLayout(null);
		ADCL.setVisible(true);
	}
}
