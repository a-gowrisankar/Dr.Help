package Dr.Help;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

import com.toedter.calendar.JDateChooser;

import ErrorHandler.EmptyFields_Error_Handler;

public class newAdmin {

	JFrame f = new JFrame("Admin Registration Screen");
	JLabel nUR, lImg, conText, nUser, lName, lPass, lPass1, lDob, lEmail, cp, cpn, lGender;
	JTextField tName, tDob, tEmail;
	JPasswordField tPass, tPass1;
	JPanel backgroundPanel;
	JButton uSubmit, uCancel, uReset;
	ImageIcon img;
	Color c;
	JDateChooser dateChooser = new JDateChooser();
	String searchEmail = "@";
	String[] sex = { "MALE", "FEMALE" };
	JComboBox<String> gender = new JComboBox<String>(sex);
	int choice;
	Date date;
	int MM, DD, YYYY;
	String Date_Final, YY;
	
	// Create Ref Objects for Empty Fields Handler
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	
	public newAdmin() {

		dateChooser.setDateFormatString("dd/MM/yyyy");

		nUR = new JLabel("New Admin");
		nUR.setBounds(615, 70, 250, 100);
		nUR.setFont(new Font("Calibri", Font.BOLD, 20));
		nUR.setForeground(Color.gray);

		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		f.getContentPane().setBackground(c);

		backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		nUser = new JLabel("Please Enter the details");
		nUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		nUser.setBounds(600, 150, 200, 30);

		// Creating Text Filed for Name
		lName = new JLabel("Name");
		lName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lName.setBounds(550, 200, 200, 30);

		tName = new JTextField();
		tName.setFont(new Font("Calibri", Font.PLAIN, 15));
		tName.setBounds(670, 200, 150, 20);

		// Creating Text Filed for Password
		lPass = new JLabel("Password");
		lPass.setFont(new Font("Calibri", Font.PLAIN, 15));
		lPass.setBounds(550, 230, 200, 30);

		lPass1 = new JLabel("Re-Enter Password");
		lPass1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lPass1.setBounds(550, 260, 200, 30);

		tPass = new JPasswordField();
		tPass.setFont(new Font("Calibri", Font.PLAIN, 15));
		tPass.setBounds(670, 230, 150, 20);

		tPass1 = new JPasswordField();
		tPass1.setFont(new Font("Calibri", Font.PLAIN, 15));
		tPass1.setBounds(670, 260, 150, 20);

		// Creating Text Filed for Date of Birth
		lDob = new JLabel("Date of Birth");
		lDob.setFont(new Font("Calibri", Font.PLAIN, 15));
		lDob.setBounds(550, 290, 200, 30);

		tDob = new JTextField();
		tDob.setFont(new Font("Calibri", Font.PLAIN, 15));
		// tDob.setBounds(650, 260, 170, 20);
		dateChooser.setBounds(670, 290, 170, 20);

		// Creating Text Filed for Email
		lEmail = new JLabel("EmailID");
		lEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		lEmail.setBounds(550, 320, 200, 30);

		tEmail = new JTextField();
		tEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		tEmail.setBounds(670, 320, 150, 20);

		lGender = new JLabel("Gender");
		lGender.setFont(new Font("Calibri", Font.PLAIN, 15));
		lGender.setBounds(550, 350, 100, 30);

		gender.setFont(new Font("Calibri", Font.PLAIN, 15));
		gender.setSelectedItem(null);
		gender.setBounds(670, 350, 150, 20);

		uReset = new JButton("Reset");
		uReset.setFont(new Font("Calibri", Font.PLAIN, 15));
		uReset.setBounds(670, 390, 125, 20);
		uReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetButton();
			}
		});

		uSubmit = new JButton("Submit");
		uSubmit.setFont(new Font("Calibri", Font.PLAIN, 15));
		uSubmit.setBounds(570, 430, 125, 20);
		uSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				submitButton();

			}
		});

		uCancel = new JButton("Cancel");
		uCancel.setFont(new Font("Calibri", Font.PLAIN, 15));
		uCancel.setBounds(720, 430, 125, 20);
		uCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new Welcome_Screen();

			}
		});

		cp = new JLabel("� Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);

		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);

		f.add(cp);
		f.add(cpn);
		f.add(lImg);
		f.add(conText);
		f.add(nUR);
		f.add(nUser);
		f.add(lName);
		f.add(tName);
		f.add(lPass);
		f.add(lPass1);
		f.add(tPass);
		f.add(tPass1);
		f.add(lDob);
		f.add(tDob);
		f.add(dateChooser);
		f.add(lEmail);
		f.add(tEmail);
		f.add(lGender);
		f.add(gender);
		f.add(uReset);
		f.add(uSubmit);
		f.add(uCancel);
		f.setSize(1500, 1500);
		f.setLayout(null);
		f.setVisible(true);

	}

	private void resetButton() {
		tName.setText("");
		tPass.setText("");
		tPass1.setText("");
		tDob.setText("");
		tEmail.setText("");
		dateChooser.setDate(null);
		gender.setSelectedItem(null);

	}

	@SuppressWarnings("deprecation") // Password Field
	private void submitButton() {
		choice = gender.getSelectedIndex();

		if (tName.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(tName, "Please Enter Your Name");
			EEH.NameEmpty("New Admin");
		} 
		
		else if (tPass.getText().equals("") || tPass1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tPass, "Please Enter The Password");
			EEH.PasswordEmpty("New Admin");
		} 
		
		else if (dateChooser.getDate() == null) 
		{
			JOptionPane.showMessageDialog(dateChooser, "Please Enter Your DOB");
			EEH.DOBEmpty("New Admin");
		} 
		
		else if (tEmail.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(tEmail, "Please Enter Your Email-ID");
			EEH.EmailId_Empty("New Admin");
		} 
		
		else if (!(tEmail.getText().contains(searchEmail))) 
		{
			JOptionPane.showMessageDialog(tEmail, "Please Enter a Valid Email-ID");
			tEmail.setText("");
			EEH.EmailId_Symbol("New Admin");
		} 
		
		else if (choice == -1) 
		{
			JOptionPane.showMessageDialog(gender, "Please Select Your Gender");
			EEH.GenderEmpty("New Admin");
			
		}
		
		else if (Arrays.equals(tPass1.getPassword(), tPass.getPassword())) {

			try {
				Models.InsertInToDB.insertNewAdmin(tName.getText(), tPass.getText(), getDOB(), tEmail.getText(),
						(String) gender.getSelectedItem());
				JOptionPane.showMessageDialog(tName, "Successfully Registered. Please Login");
				resetButton();
				f.setVisible(false);
				new Login_All();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error While Populating Admin Data For Insertion" + e);
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(tPass, "Password Mismatch, Please Try Again");
			tPass.setText("");
			tPass1.setText("");
			EEH.PasswordMisMatch("New Admin");
		}
	}

	@SuppressWarnings("deprecation") // For deprecation
	public String getDOB() {
		DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
		String Date_Final=date.format(dateChooser.getDate());
		return Date_Final;
	}

}