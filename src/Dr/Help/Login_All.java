/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

package Dr.Help;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

import ErrorHandler.EmptyFields_Error_Handler;
import ErrorHandler.Login_Error;

public class Login_All {
	
	JFrame LA = new JFrame("Login Screen");
	JLabel welcomTex,welcomTex2 ,captionTex,email, pwd, catDesc,conText,cp,cpn,lImg;
	JPasswordField pd;
	JTextField emailID;
	JButton login, newUser, clear, RaiseAReq;	
	JPanel backgroundPanel;
	String category[] = { "USER", "DOCTOR", "MANAGEMENT", "ADMIN" };
	String domain[] = {"@gmail.com", "@yahoo.com", "@hawk.iit.edu"};
	JComboBox<String> catSel = new JComboBox<String>(category);
	JComboBox<String> domainSel = new JComboBox<String>(domain);
	Color c;
	ImageIcon img;
	String emailString = "@";
	public static String UserName;
	
	//Create Ref Object for Error Handler
	Login_Error LE = new Login_Error();
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	

	public Login_All()
	{
		img = new ImageIcon("Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		LA.getContentPane().setBackground(c);

		backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		welcomTex = new JLabel("Welcome to Dr.Help");
		welcomTex.setBounds(600, 10, 250, 100);
		welcomTex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomTex.setForeground(Color.gray);
		
		
		captionTex = new JLabel("- For the People, Of the People, By the People");
		captionTex.setBounds(700,30,290,100);
		captionTex.setFont(new Font("Calibri", Font.PLAIN, 14));
		captionTex.setForeground(Color.gray);
		
		welcomTex2 = new JLabel("Please Login to Proceed");
		welcomTex2.setFont(new Font("Calibri", Font.PLAIN, 15));
		welcomTex2.setBounds(600,100,150,100);
		
		
		email = new JLabel("Email_Id");
		email.setFont(new Font("Calibri", Font.PLAIN, 15));
		email.setBounds(550, 200, 100, 25);
	
		emailID = new JTextField(4);
		emailID.setFont(new Font("Calibri", Font.PLAIN, 15));
		emailID.setBounds(630, 200, 150, 25);
		
		domainSel.setSelectedItem(null);
		domainSel.setFont(new Font("Calibri", Font.PLAIN, 15));
		domainSel.setBounds(800,200,120,20);
		
		
		pwd = new JLabel("Password");
		pwd.setFont(new Font("Calibri", Font.PLAIN, 15));
		pwd.setBounds(550,250,100,25);
		
		pd = new JPasswordField();
		pd.setFont(new Font("Calibri", Font.PLAIN, 15));
		pd.setBounds(630, 250, 150, 25);
		
		catDesc = new JLabel("Category");
		catDesc.setFont(new Font("Calibri", Font.PLAIN, 15));
		catDesc.setBounds(550, 300, 100, 25);
		
		catSel.setSelectedItem(null);
		catSel.setFont(new Font("Calibri", Font.PLAIN, 15));
		catSel.setBounds(630,300,150,20);
		
		login = new JButton("Login");
		login.setFont(new Font("Calibri", Font.PLAIN, 15));
		login.setBounds(550, 390, 95, 25);
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginButton();
			}
		});
		
		
		newUser = new JButton("SignUp");
		newUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		newUser.setBounds(700,390,95,25);
		
		newUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LA.setVisible(false);
				new Welcome_Screen();
				
			}
		});
		
		clear = new JButton("Clear");
		clear.setFont(new Font("Calibri", Font.PLAIN, 15));
		clear.setBounds(635,345,85,25);
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				clearButton();		
			}
		});
		
		RaiseAReq = new JButton("Raise A Request");
		RaiseAReq.setFont(new Font("Calibri", Font.PLAIN, 15));
		RaiseAReq.setBounds(590,440,150,25);
		RaiseAReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Help("Login");
			}
		});
		
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		
		LA.add(cp);
		LA.add(cpn);

		LA.add(lImg);
		LA.add(conText);
		LA.add(welcomTex);
		LA.add(welcomTex2);
		LA.add(captionTex);
		LA.add(email);
		LA.add(emailID);
		LA.add(domainSel);
		LA.add(pwd);
		LA.add(pd);
		LA.add(catDesc);
		LA.add(catSel);
		LA.add(login);
		LA.add(newUser);
		LA.add(clear);
		LA.add(RaiseAReq);
		LA.setSize(1500, 1500);	
		LA.setLayout(null);
		LA.setVisible(true);
	}

	//Methods
	private void LoginButton()
	{
		loginValidation();
		
	}
	
	private void clearButton()
	{
		emailID.setText("");
		pd.setText("");
		domainSel.setSelectedItem(null);
		catSel.setSelectedIndex(-1);
	}
	
	@SuppressWarnings("deprecation")
	private void loginValidation()
	{
		
		if(emailID.getText().equals(""))
		  {
			JOptionPane.showMessageDialog(emailID, "Please Enter your Email-ID");
			EEH.EmailId_Empty("Login");
		  }
		else if(emailID.getText().contains(emailString))
		{
			JOptionPane.showMessageDialog(emailID, "Select Domain From the  Domain Filed");
			emailID.setText("");
			EEH.EmailId_Symbol("Login");
			
		}
		else if(domainSel.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(domainSel, "Please Select Your Domain");
			EEH.domainEmpty("Login");
		}
		else if(pd.getText().equals(""))
		{
			JOptionPane.showMessageDialog(pd, "Please Enter Your Password");
			EEH.PasswordEmpty("Login");
		}
		else if(catSel.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(catSel, "Select Your Login Type");
			EEH.CategoryEmpty("Login");
		}
		else
		{
			UserName = emailID.getText() + domainSel.getSelectedItem();
			System.out.println(UserName + catSel.getSelectedItem());
			try {
				Models.ResultSetFetch.getLoginDetails(UserName, pd.getText() ,(String)catSel.getSelectedItem());
				LA.setVisible(false);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 
		}
	
	}
	
	public static void main(String[] args)
	{
		new Login_All();
	}
}

