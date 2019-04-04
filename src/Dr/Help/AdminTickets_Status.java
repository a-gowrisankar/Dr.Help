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
import javax.swing.JTextField;

import ErrorHandler.EmptyFields_Error_Handler;
import View.Admin_Tickets_View;

public class AdminTickets_Status 
{

	JFrame ATS = new JFrame("Admin Ticket Status");
	String Status[] = { "Open", "Closed", "InProgress"};
	String Priority[] = {"1", "2", "3", "4"};
	JComboBox<String> StatusList = new JComboBox<String>(Status);
	JComboBox<String> priorityList = new JComboBox<String>(Priority);
	JLabel Status_label, PriorityLabel, Header, appointCat, conText,cp,cpn, lImg;
	Color c;
	JButton Search, Reset, goBack;
	ImageIcon img;
	Admin_Tickets_View ATV = new Admin_Tickets_View();
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	public AdminTickets_Status()
	{
		
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		ATS.getContentPane().setBackground(c);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		Header = new JLabel("Welcome to Admin Ticket Section");
		Header.setFont(new Font("Calibri", Font.BOLD, 20));
		Header.setForeground(Color.gray);
		Header.setBounds(525, 100, 400, 50);

		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		
		
		Status_label = new JLabel("Select Ticket Status ");
		Status_label.setFont(new Font("Calibri", Font.PLAIN, 15));
		Status_label.setBounds(530, 180, 200, 100);

		StatusList.setSelectedItem(null);
		StatusList.setFont(new Font("Calibri", Font.PLAIN, 15));
		StatusList.setBounds(720, 220, 100, 20);
		
		
		PriorityLabel = new JLabel("Select Ticket Priority");
		PriorityLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		PriorityLabel.setBounds(530, 255, 150, 50);
		
		priorityList.setSelectedItem(null); 
		priorityList.setFont(new Font("Calibri", Font.PLAIN, 15));
		priorityList.setBounds(720, 270, 100, 20);
		
		Search = new JButton("Search");
		Search.setFont(new Font("Calibri", Font.PLAIN, 15));
		Search.setBounds(540, 365, 85, 20);
		Search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(StatusList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(StatusList, "Please Select The Status of The Ticket");
					EEH.ticketStatusEmpty("Admin Ticket Status Selection");
				}
				else if(priorityList.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(priorityList, "Please Select The Priority of The Ticket");
					EEH.ticketPriorityEmpty("Admin Ticket Priority Selection");
				}
				else 
				{
					ATV.AdminTicketList((String) StatusList.getSelectedItem(), (String) priorityList.getSelectedItem());
				}
			}
		});

		Reset = new JButton("Reset");
		Reset.setFont(new Font("Calibri", Font.PLAIN, 15));
		Reset.setBounds(720, 365, 85, 20);
		Reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StatusList.setSelectedItem(null);
				priorityList.setSelectedItem(null); 
				
			}
		});

		goBack = new JButton("GoBack");
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.setBounds(630, 405, 85, 20);
		goBack.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Screen();
				ATS.setVisible(false);
			}
		});
		
		ATS.add(cp);
		ATS.add(cpn);

		ATS.add(lImg);
		ATS.add(conText);
		ATS.add(Header);
		ATS.add(StatusList);
		ATS.add(Header);
		ATS.add(priorityList);
		ATS.add(PriorityLabel);
		ATS.add(Search);
		ATS.add(Reset);
		ATS.add(goBack);
		ATS.add(Status_label);
		ATS.add(cp);
		ATS.add(cpn);
		ATS.setLayout(null);
		ATS.setSize(1500, 1500);
		ATS.setVisible(true);
	}
}
