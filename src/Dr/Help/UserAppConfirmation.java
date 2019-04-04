package Dr.Help;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

import ErrorHandler.EmptyFields_Error_Handler;


public class UserAppConfirmation {

	JFrame UAC = new JFrame("Appointment Schedule");
	JLabel DropDownLabel, ZipCodeLabel, Header, appointCat, conText,cp,cpn;
	JTextField ipLoc, appointDesc;
	String location[] = { "Chicago", "Dallas", "New York", "Phoenix" };
	JComboBox<String> cb = new JComboBox<String>(location);
	JCheckBox insurOpt;
	JButton Search, Reset, goBack,Logout;
	int choice;
	int category;
	public static String locName;
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	public UserAppConfirmation(String getMedCat) {

		Image img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		JLabel lImg = new JLabel("");
		lImg.setIcon(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		Color c = new Color(245, 252, 196);
		UAC.getContentPane().setBackground(c);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		Header = new JLabel("Welcome to Appointment Schedule Screen");
		Header.setFont(new Font("Calibri", Font.BOLD, 20));
		Header.setForeground(Color.gray);
		Header.setBounds(525, 100, 400, 50);

		DropDownLabel = new JLabel("Select Your Location of Visit");
		DropDownLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		DropDownLabel.setBounds(530, 180, 200, 100);

		ZipCodeLabel = new JLabel("Enter the ZipCode");
		ZipCodeLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		ZipCodeLabel.setBounds(530, 255, 150, 50);

		ipLoc = new JTextField();
		ipLoc.setFont(new Font("Calibri", Font.PLAIN, 15));
		ipLoc.setBounds(720, 270, 100, 20);

		appointCat = new JLabel("Category");
		appointCat.setFont(new Font("Calibri", Font.PLAIN, 15));
		appointCat.setBounds(530, 305, 100, 50);

		appointDesc = new JTextField();
		appointDesc.setFont(new Font("Calibri", Font.PLAIN, 15));
		appointDesc.setBounds(720, 320, 100, 20);

		cb.setSelectedItem(null);
		cb.setFont(new Font("Calibri", Font.PLAIN, 15));
		cb.setBounds(720, 220, 90, 20);

		insurOpt = new JCheckBox("Do you Have Medical Insurance?");
		insurOpt.setFont(new Font("Calibri", Font.PLAIN, 15));
		insurOpt.setBackground(c);
		insurOpt.setBounds(530, 345, 250, 50);

		Search = new JButton("Search");
		Search.setFont(new Font("Calibri", Font.PLAIN, 15));
		Search.setBounds(540, 405, 85, 20);

		Reset = new JButton("Reset");
		Reset.setFont(new Font("Calibri", Font.PLAIN, 15));
		Reset.setBounds(720, 405, 85, 20);

		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(630, 445, 85, 20);

		appointDesc.setText(getMedCat.toString());
		appointDesc.setEditable(false);
		// Rest all the fields
		Reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ipLoc.setText(" ");
				cb.setSelectedItem(null);

			}
		});

		Search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				choice = cb.getSelectedIndex();
				locName=(String) cb.getSelectedItem();
				if (choice == -1)
				{

					JOptionPane.showMessageDialog(cb, "Please Select a Location");
					EEH.userHospSearch("User Hosp Location Search");
					cb.setFont(new Font("Calibri", Font.PLAIN, 30));
				} 
				else 
				{
					if (choice == 0) 
					{
						if (insurOpt.isSelected()) 
							{
							new Hosp_List(choice, locName);
							UAC.setVisible(false);
							}
						else 
							{
							new Hosp_List(-1, locName);
							UAC.setVisible(false);
							}
					}
					
					else if (choice == 1) 
					{
						if (insurOpt.isSelected()) 
							{
							new Hosp_List(choice, locName);
							UAC.setVisible(false);
							} 
						else 
							{
							new Hosp_List(-2, locName);
							UAC.setVisible(false);
							}

					} 
					
					else if (choice == 2) 
					{
						if (insurOpt.isSelected()) 
							{
								new Hosp_List(choice, locName);
								UAC.setVisible(false);
							}
						else 
							{
							new Hosp_List(-3, locName);
							UAC.setVisible(false);
							}
					} 
					
					else if (choice == 3) 
					{
						if (insurOpt.isSelected()) 
							{
							new Hosp_List(choice, locName);
							UAC.setVisible(false);
							} 
						else 
							{
								new Hosp_List(-4, locName);
								UAC.setVisible(false);
							}
					}

					else 
					{
						JOptionPane.showMessageDialog(Search, "Please Select an Option");
						Search.setFont(new Font("Calibri", Font.PLAIN, 15));
						UAC.setVisible(true);
					}
				}

			}
		});

		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UAC.setVisible(false);
				new IssueDescription();

			}
		});
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		Logout = new JButton("LOGOUT");
		Logout.setFont(new Font("Calibri", Font.BOLD, 15));
		Logout.setForeground(Color.GRAY);
		Logout.setBounds(1100, 120, 150, 30);
		ImageIcon img1 = new ImageIcon("C:\\Users\\Wayne-PC\\Desktop\\l.png");
		Logout.setBackground(c);
		Logout.setIcon(img1);
		Logout.setBorderPainted(false);
		// Logout.setFont(new Font("Calibri", Font.PLAIN, 15));
		Logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Login_All();
				UAC.setVisible(false);
			}
		});
		UAC.add(cp);
		UAC.add(cpn);
		UAC.add(Logout);
		UAC.add(lImg);
		UAC.add(conText);
		UAC.add(insurOpt);
		UAC.add(DropDownLabel);
		UAC.add(Header);
		UAC.add(ZipCodeLabel);
		UAC.add(ipLoc);
		UAC.add(Search);
		UAC.add(Reset);
		UAC.add(goBack);
		UAC.add(appointCat);
		UAC.add(appointDesc);
		UAC.add(cb);
		UAC.setLayout(null);
		UAC.setSize(1500, 1500);
		UAC.setVisible(true);

	}
	
	public static void main(String[] args)
	{
		new UserAppConfirmation("Test");
	}
}