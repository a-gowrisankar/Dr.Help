package Dr.Help;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.OverlayLayout;

import ErrorHandler.EmptyFields_Error_Handler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class IssueDescription {
	JFrame DC = new JFrame("Issue Description");
	JLabel welcomtex1, conText, cp, cpn;
	JRadioButton headButton, neckToKnee, kneeToToe, medHist,HospSearch, RaiseANewReq;
	JButton nextButton, resetButton,Logout;
	ButtonGroup group;
	public static String category;
	
	//Create Ref Object for Empty Field Handler
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	public IssueDescription() {

		Image img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		JLabel lImg = new JLabel("");
		lImg.setIcon(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		Color c = new Color(245, 252, 196);
		DC.getContentPane().setBackground(c);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		welcomtex1 = new JLabel("Hello, Please Choose From The Below Options to Begin");
		welcomtex1.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomtex1.setForeground(Color.gray);
		welcomtex1.setBounds(500, 70, 500, 100);

		group = new ButtonGroup(); // For selecting only one Radio Button
		headButton = new JRadioButton("Head");
		headButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(headButton);
		headButton.setBounds(600, 170, 150, 40);
		headButton.setBackground(c);

		neckToKnee = new JRadioButton("Neck to Knee");
		neckToKnee.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(neckToKnee);
		neckToKnee.setBounds(600, 200, 150, 40);
		neckToKnee.setBackground(c);

		kneeToToe = new JRadioButton("Knee to Toe");
		kneeToToe.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(kneeToToe);
		kneeToToe.setBounds(600, 230, 150, 40);
		kneeToToe.setBackground(c);

		medHist = new JRadioButton("Medical History");
		medHist.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(medHist);
		medHist.setBounds(600, 260, 150, 40);
		medHist.setBackground(c);
		
		HospSearch = new JRadioButton("Search Medical Shop");
		HospSearch.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(HospSearch);
		HospSearch.setBounds(600, 290, 200, 40);
		HospSearch.setBackground(c);
		
		RaiseANewReq = new JRadioButton("Raise A Request");
		RaiseANewReq.setFont(new Font("Calibri", Font.PLAIN, 15));
		group.add(RaiseANewReq);
		RaiseANewReq.setBounds(600, 320, 200, 40);
		RaiseANewReq.setBackground(c);
		
		

		nextButton = new JButton("Next");
		nextButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		nextButton.setBounds(570, 380, 85, 25);

		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveNextScreen();
			}
		});

		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Calibri", Font.PLAIN, 15));
		resetButton.setBounds(700, 380, 85, 25);
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				group.clearSelection();

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
				DC.setVisible(false);
			}
		});

		DC.add(cp);
		DC.add(cpn);
		DC.add(Logout);
		DC.add(lImg);
		DC.add(conText);

		DC.add(welcomtex1);
		DC.add(headButton);
		DC.add(neckToKnee);
		DC.add(kneeToToe);
		DC.add(medHist);
		DC.add(HospSearch);
		DC.add(RaiseANewReq);
		DC.add(nextButton);
		DC.add(resetButton);
		DC.setLayout(null);
		DC.setVisible(true);
		DC.setSize(1500, 1500);

	}

	private void moveNextScreen() {

		if (headButton.isSelected()) {
			category="Head";
			new UserAppConfirmation(category);
			DC.setVisible(false);
		} else if (neckToKnee.isSelected()) {
			category="NeckToKnee";
			new UserAppConfirmation(category);
			DC.setVisible(false);
		} else if (kneeToToe.isSelected()) {
			category="KneeToToe";
			new UserAppConfirmation(category);
			DC.setVisible(false);
		}
		else if (HospSearch.isSelected())
		{
			new NearByMedicalShop("USER");
			DC.setVisible(false);
		}
		else if(RaiseANewReq.isSelected())
		{
			new Admin_Help("User");
			DC.setVisible(false);
		}
		else {
			JOptionPane.showMessageDialog(nextButton, "Plese Select an Option To Proceed");
			EEH.userSelectionEmpty("User Screen IssueDescription");
			DC.setVisible(true);
		}
	}

}
