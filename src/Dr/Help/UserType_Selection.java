package Dr.Help;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class UserType_Selection { // Constructor

	JFrame UTS = new JFrame("Category Selection Screen"); // Display in the JFrame
	JLabel lImg, conText, cp, cpn;
	JButton back; // Go Back Button

	ImageIcon img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
	{
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		Color c = new Color(245, 252, 196);
		UTS.getContentPane().setBackground(c);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
	}

	public UserType_Selection(int i) {
		if (i == 1) {
			User_Screen();
		} else if (i == 2) {
			Doctor_Choice();
		} else if (i == 3) {
			Manager_Choice();
		} else if (i == 4) {
			Admin_Choice();
		}
	}

	public void User_Screen() {

		JLabel User;
		JButton NUser;

		User = new JLabel("Please Select Your User Type");
		User.setFont(new Font("Calibri", Font.BOLD, 20));
		User.setForeground(Color.gray);
		User.setBounds(550, 100, 300, 30);

		NUser = new JButton("New User");
		NUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		NUser.setBounds(600, 200, 135, 20);
		NUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new newUser(); // Calls the Welcome_Screen Constructor
			}
		});
		// If this button is clicked then it will go back to Welcome_Screen
		back = new JButton("Go Back ");
		back.setFont(new Font("Calibri", Font.PLAIN, 15));
		back.setBounds(600, 250, 135, 20);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new Welcome_Screen(); // Calls the Welcome_Screen Constructor
			}
		});
		UTS.add(lImg);
		UTS.add(conText);
		UTS.add(User);

		UTS.add(NUser);
		UTS.add(back);
		UTS.setSize(1500, 1500);
		UTS.setLayout(null);
		UTS.setVisible(true);
	}

	public void Doctor_Choice() {
		JLabel Doctor;
		JButton NDoc;
		Doctor = new JLabel("Please Select Your Doctor Type");
		Doctor.setFont(new Font("Calibri", Font.BOLD, 20));
		Doctor.setForeground(Color.gray);
		Doctor.setBounds(550, 150, 300, 30);

		NDoc = new JButton("New Doctor");
		NDoc.setFont(new Font("Calibri", Font.PLAIN, 15));
		NDoc.setBounds(600, 200, 135, 20);
		NDoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new newDoctor(); // Calls the Welcome_Screen Constructor
			}
		});

		back = new JButton("Go Back ");
		back.setFont(new Font("Calibri", Font.PLAIN, 15));
		back.setBounds(600, 250, 135, 20);

		// addActionListener is used to perform what action needs to be performed if the
		// button is clicked
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new Welcome_Screen(); // Go back to Welcome_Screen
			}
		});

		UTS.add(lImg);
		UTS.add(conText);
		UTS.add(Doctor); // Display Doctor Label in the JFrame

		UTS.add(NDoc); // Display New Doctor in the JFrame
		UTS.add(back); // Display back button in the JFrame
		UTS.setSize(1500, 1500);
		UTS.setLayout(null);
		UTS.setVisible(true);

	}

	public void Manager_Choice() {
		JLabel Manager;
		JButton  NManager;
		Manager = new JLabel("Please Select Your Manager Type");
		Manager.setFont(new Font("Calibri", Font.BOLD, 20));
		Manager.setForeground(Color.gray);
		Manager.setBounds(550, 150, 300, 30);

		NManager = new JButton("New Manager");
		NManager.setFont(new Font("Calibri", Font.PLAIN, 15));
		NManager.setBounds(600, 200, 135, 20);
		NManager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new newManager(); // Calls the Welcome_Screen Constructor
			}
		});
		back = new JButton("Go Back ");
		back.setFont(new Font("Calibri", Font.PLAIN, 15));
		back.setBounds(600, 250, 135, 20);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new Welcome_Screen();
			}
		});
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		UTS.add(cp);
		UTS.add(cpn);


		UTS.add(lImg);
		UTS.add(conText);
		UTS.add(Manager);

		UTS.add(NManager);
		UTS.add(back);
		UTS.setSize(1500, 1500);
		UTS.setLayout(null);
		UTS.setVisible(true);

	}

	public void Admin_Choice() {
		JLabel Admin;
		JButton  NAdmin;
		Admin = new JLabel("Please Select Your Admin Type");
		Admin.setFont(new Font("Calibri", Font.BOLD, 20));
		Admin.setForeground(Color.gray);
		Admin.setBounds(550, 150, 300, 30);

		NAdmin = new JButton("New Admin");
		NAdmin.setFont(new Font("Calibri", Font.PLAIN, 15));
		NAdmin.setBounds(600, 200, 135, 20);
		NAdmin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new newAdmin(); // Calls the Welcome_Screen Constructor
			}
		});
		back = new JButton("Go Back ");
		back.setFont(new Font("Calibri", Font.PLAIN, 15));
		back.setBounds(600, 250, 135, 20);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UTS.setVisible(false);
				new Welcome_Screen();
			}
		});

		UTS.add(lImg);
		UTS.add(conText);
		UTS.add(Admin);
		UTS.add(NAdmin);
		UTS.add(back);
		UTS.setSize(1500, 1500);
		UTS.setLayout(null);
		UTS.setVisible(true);

	}

}
