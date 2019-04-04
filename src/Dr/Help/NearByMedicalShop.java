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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

import ErrorHandler.EmptyFields_Error_Handler;
import View.MedView;

public class NearByMedicalShop {

	JFrame NBMS = new JFrame();
	JLabel welcomTex,conText,welcomTex2, locName, ZipCode, Choice,lImg;
	JTextField tlocName, tZipCode;
	Color c; 
	JButton fetch, reset, goBack;
	ImageIcon img;
	MedView MV = new MedView();
	
	
	//Create a Reference Object for Empty Fields Handler
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	public NearByMedicalShop(String Screen)
	{
		
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		
		NBMS.getContentPane().setBackground(c);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		welcomTex = new JLabel("Welcome to Dr.Help");
		welcomTex.setBounds(600, 10, 250, 100);
		welcomTex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomTex.setForeground(Color.gray);
		
		welcomTex2 = new JLabel("Please Enter Below To Find NearBy Pharmacies");
		welcomTex2.setFont(new Font("Calibri", Font.PLAIN, 15));
		welcomTex2.setBounds(600,100,350,100);
		
		
		
		locName = new JLabel("Location");
		locName.setFont(new Font("Calibri", Font.PLAIN, 15));
		locName.setBounds(550, 200, 100, 25);
		
		tlocName = new JTextField(4);
		tlocName.setFont(new Font("Calibri", Font.PLAIN, 15));
		tlocName.setBounds(630, 200, 150, 25);
		
		Choice = new JLabel("(OR)");
		Choice.setBounds(680, 225, 100, 25);
		
		
		ZipCode = new JLabel("ZipCode");
		ZipCode.setFont(new Font("Calibri", Font.PLAIN, 15));
		ZipCode.setBounds(550,250,100,25);
		
		tZipCode = new JTextField();
		tZipCode.setFont(new Font("Calibri", Font.PLAIN, 15));
		tZipCode.setBounds(630, 250, 150, 25);
		
		
		fetch = new JButton("Fetch");
		fetch.setFont(new Font("Calibri", Font.PLAIN, 15));
		fetch.setBounds(570, 325, 95, 25);
		
		fetch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			if(tlocName.getText().equals(""))
			{
				if(tZipCode.getText().equals(""))
				{
					JOptionPane.showMessageDialog(tlocName, "Please Enter Any One");
					EEH.locationORZipCodeEmpty("Hosp Search");
				}
				else
				{
					try {
						searchByZipCode(tZipCode.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else
			{
				try {
					System.out.println(tlocName.getText().toUpperCase());
					searchMedicalShopByLocation(tlocName.getText().toUpperCase());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			}
		});
		
		reset = new JButton("Clear");
		reset.setFont(new Font("Calibri", Font.PLAIN, 15));
		reset.setBounds(700,325,85,25);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					clearButton();
			}
		});
			
		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(630,385,85,25);
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Screen.equals("USER"))
				{
					new IssueDescription();
					NBMS.setVisible(false);
				}
				else if(Screen.equals("MANAGEMENT"))
				{
					new Management_Report();
					NBMS.setVisible(false);
				}
			}	
		});
		
		
		
		NBMS.add(lImg);
		NBMS.add(conText);
		NBMS.add(welcomTex);
		NBMS.add(welcomTex2);
		NBMS.add(locName);
		NBMS.add(tlocName);
		NBMS.add(ZipCode);
		NBMS.add(tZipCode);
		NBMS.add(Choice);
		NBMS.add(fetch);
		NBMS.add(reset);
		NBMS.add(goBack);
		NBMS.setLayout(null);
		NBMS.setSize(1500, 1500);
		NBMS.setVisible(true);
	}
	
	public void searchMedicalShopByLocation(String tLocName) throws Exception
	{
		MV.MedViewByLoc(tLocName);
	}
	
	
	public void searchByZipCode(String tZipCode) throws Exception
	{
		MV.MedView(tZipCode);
	}
	
	public void clearButton()
	{
		tlocName.setText("");
		tZipCode.setText("");
	}
	
}
