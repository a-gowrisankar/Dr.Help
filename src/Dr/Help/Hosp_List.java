package Dr.Help;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.OverlayLayout;

import com.toedter.calendar.JDateChooser;

import Models.Connector;
import Models.InsertInToDB;
import Models.ResultSetFetch;
import View.Appointment_summary;

public class Hosp_List {

	
	
	JFrame HL = new JFrame("Hosptail List");
	JDateChooser dateChooser = new JDateChooser();
	String locName;
	JComboBox<?> hospitals;
	JLabel citylist,conText,cp,cpn,Hospitals,appointmentdate;
	JButton goBack, appointment,show,Logout;
	java.sql.PreparedStatement pa=null;
	ResultSet rs = null;
	int category;
	String usrcat=IssueDescription.category;
	String hosp,l;
	List<String> comboBoxNames = new ArrayList<String>();
	SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");
	Date Today=new Date();
	ArrayList<String> array = new ArrayList<String>(Arrays.asList("9.00 A.M", "9.30 A.M", "10.00 A.M", "10.30 A.M", "11.00 A.M", "11.30 A.M"));
	JRadioButton[] rb = new JRadioButton[6];
	ButtonGroup group = new ButtonGroup();
	public static String docname;
	List<String> results = new ArrayList<String>();
	public Hosp_List(int i, String LocName)
	{
		Image img = new ImageIcon(this.getClass().getResource("/Doctor1.png")).getImage();
		JLabel lImg = new JLabel("");
		lImg.setIcon(new ImageIcon(img));
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		Color c = new Color(245, 252, 196);
		HL.getContentPane().setBackground(c);
		dateChooser.setDate(Today);
		dateChooser.setDateFormatString("MM-dd-YYYY");
		dateChooser.setBounds(730, 230, 170, 25);
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);

		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		Hospitals = new JLabel("Available Hospitals");
		Hospitals.setFont(new Font("Calibri", Font.PLAIN, 15));
		Hospitals.setBounds(530, 180, 200, 25);
		
		appointmentdate = new JLabel("Choose the Appointment Date");
		appointmentdate.setFont(new Font("Calibri", Font.PLAIN, 15));
		appointmentdate.setBounds(530, 230, 200, 25);
		
	
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
				HL.setVisible(false);
			}
		});
		
			
		
		if(usrcat.equals("Head"))
		{
			category=1;
		}
		else if(usrcat.equals("NeckToKnee"))
		{
			category=2;
		}
		else if(usrcat.equals("KneeToToe"))
		{
			category=3;
		}
		
		
		
		//Option 0
		if(i==0)
		{
			city_0(0);
		}
		else if(i==-1)
		{
			city_0(-1);
		}
		
		//Option 1
		else if(i==1)
		{
			city_1(0);
		}
		else if(i==-2)
		{
			city_1(-2);
		}
		
		//Option 2
		else if(i==2)
		{
			city_2(0);
		}
		else if(i==-3)
		{
			city_2(-3);
		}
		
		//Option 3
		else if(i==3)
		{
			city_3(0);
		}
		else if(i==-4)
		{
			city_3(-4);
		}
		
		goBack = new JButton("Go Back");
		goBack.setBounds(570, 350, 100, 20);
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e ) {
				new UserAppConfirmation(usrcat);
				HL.setVisible(false);
				
			}
		});
			

	
		int y = 280,x=530;
		
			for (int j = 0; j <6; j++) {
				
				
				rb[j] = new JRadioButton(array.get(j));
				group.add(rb[j]);
				rb[j].setBounds(x, y, 100, 25);
				rb[j].setBackground(c);
				rb[j].setEnabled(false);
				HL.add(rb[j]);
				
				x += 100;
		}

			
			
			show = new JButton("Check Slot ");
			show.setBounds(700, 350, 120, 20);
			show.setFont(new Font("Calibri", Font.PLAIN, 15));
			show.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					hosp=(String) hospitals.getSelectedItem();
					try {
						dateChooser.setDate(dateChooser.getDate());
						check(hosp);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}});
			
		appointment = new JButton("Book");
		appointment.setBounds(850, 350, 100, 20);
		appointment.setFont(new Font("Calibri", Font.PLAIN, 15));
		appointment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				hosp=(String) hospitals.getSelectedItem();
				if(rb[0].isSelected())
				{
					l="9.00 A.M";
					book(hosp,l);
				}
				else if(rb[1].isSelected())
				{
					l="9.30 A.M";
					book(hosp,l);
				}
				else if(rb[2].isSelected())
				{
					l="10.00 A.M";
					book(hosp,l);
				}
				else if(rb[3].isSelected())
				{
					l="10.30 A.M";
					book(hosp,l);
				}
				else if(rb[4].isSelected())
				{
					l="11.00 A.M";
					book(hosp,l);
				}
				else if(rb[5].isSelected())
				{
					l="11.30 A.M";
					book(hosp,l);
				}
				else{
					JOptionPane.showMessageDialog(null, "No time slot choosen please retry");// TODO Auto-generated method stub
				}
		
			}});
		HL.add(cp);
		HL.add(cpn);
		HL.add(Logout);
		HL.add(lImg);
		HL.add(conText);
		HL.add(appointmentdate);
		HL.add(dateChooser);
		locName = LocName;
		HL.setSize(1500, 1500);
		HL.setLayout(null);
		HL.setVisible(true);
		HL.add(appointment);		
		HL.add(goBack);
		HL.add(show);
		HL.add(Hospitals);
		

	}
	
	

	public void city_0(int i)
	{
		
		if(i==-1)
		{
		citylist = new JLabel("Hello Please find the Hosptails Without Insurance Coverage at " + locName);
		citylist.setFont(new Font("Calibri", Font.BOLD, 20));
		citylist.setForeground(Color.gray);
		citylist.setBounds(450, 70, 650,20);
		HL.add(citylist);
		try {
			 rs= ResultSetFetch.hosplist(locName,0,category);
			while (rs.next()) {
				 String name = rs.getString("HOSPITAL_NAME");
				 comboBoxNames.add(name);
				 }
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hospitals = new JComboBox<Object>(comboBoxNames.toArray());
		hospitals.setBounds(730,180,300,25);
		HL.add(hospitals);
		}
		else
		{
			citylist = new JLabel("Hello Please find the Hosptails With Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);
			try {
				 rs= ResultSetFetch.hosplist(locName,1,category);
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME");
					 comboBoxNames.add(name);
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray());
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);
		}
	}
	@SuppressWarnings("unused")
	private void elseif(boolean equals) {
		// TODO Auto-generated method stub
		
	}



	public void city_1(int i)
	{
		if(i==-2)
		{
		citylist = new JLabel("Hello Please find the Hosptails Without Insurance Coverage at " + locName);
		citylist.setFont(new Font("Calibri", Font.BOLD, 20));
		citylist.setForeground(Color.gray);
		citylist.setBounds(450, 70, 650,20);
		try {
			 rs= ResultSetFetch.hosplist(locName,0,category);
			while (rs.next()) {
				 String name = rs.getString("HOSPITAL_NAME");
				 comboBoxNames.add(name);
				 }
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hospitals = new JComboBox<Object>(comboBoxNames.toArray());
		hospitals.setBounds(730,180,300,25);
		HL.add(hospitals);
		HL.add(citylist);
		}
		else
		{
			citylist = new JLabel("Hello Please find the Hosptails With Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);
			try {
				 rs= ResultSetFetch.hosplist(locName,1,category);
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME");
					 comboBoxNames.add(name);
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray());
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);
		}
	}
	
	public void city_2(int i)
	{
		
		if(i==-3)
		{
			citylist = new JLabel("Hello Please find the Hosptails Without Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);
			try {
				 rs= ResultSetFetch.hosplist(locName,0,category);
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME");
					 comboBoxNames.add(name);
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray());
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);
		}
		else
		{
			citylist = new JLabel("Hello Please find the Hosptails With Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);try {
				 rs= ResultSetFetch.hosplist(locName,1,category);
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME");
					 comboBoxNames.add(name);
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray());
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);	
		}
	}
	
	public void city_3(int i)
	{
		if(i==-4)
		{
			citylist = new JLabel("Hello Please find the Hosptails Without Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);
			try {
				 rs= ResultSetFetch.hosplist(locName,0,category);
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME");
					 comboBoxNames.add(name);
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray());
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);
		}
		else
		{
			citylist = new JLabel("Hello Please find the Hosptails With Insurance Coverage at " + locName);
			citylist.setFont(new Font("Calibri", Font.BOLD, 20));
			citylist.setForeground(Color.gray);
			citylist.setBounds(450, 70, 650,20);
			try {
				 rs= ResultSetFetch.hosplist(locName,1,category);
				while (rs.next()) {
					 String name = rs.getString("HOSPITAL_NAME");
					 comboBoxNames.add(name);
					 }
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hospitals = new JComboBox<Object>(comboBoxNames.toArray());
			hospitals.setBounds(730,180,300,25);
			HL.add(hospitals);
			HL.add(citylist);	
		}
		
	}
	
	public void book(String hosp,String l)
	{
		try {
			check(hosp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			HL.setVisible(false);
			String ate=date.format(dateChooser.getDate());
			InsertInToDB.bookappointment(hosp, ate,l,category,Login_All.UserName);
			try {
				new Appointment_summary(ate,l,hosp,Login_All.UserName);
				HL.setVisible(false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void check(String hosp) throws Exception
	{
		if(dateChooser.getDate() == null)
		{
			JOptionPane.showMessageDialog(dateChooser, "Please choose a day");
		}
		else {
			
			String ate=date.format(dateChooser.getDate());
			String today=date.format(Today);
			Date day0= date.parse(today);
			Date day1=date.parse(ate);
				long diff= day1.getTime()-day0.getTime();
				int days=(int) (diff/(60*60*1000*24));
				if(days>1.0 && days<=30.0)
				{
						int result=0;
							
							rs=ResultSetFetch.checkdate(hosp, ate);
							while (rs.next())
								{
								results.add(rs.getString("TIME_SLOT"));
								
								result++;
								
								}
							for (int j = 0; j < 6; j++)
							  {
							  rb[j].setEnabled(true);
							  }
							if(result==0)
								{
								  for (int j = 0; j < 6; j++)
								  {
								  rb[j].setEnabled(true);
								  }
															  
								}
							  if(result==6)
							  {
								  for (int j = 0; j < 6; j++)
								  {
								  rb[j].setEnabled(false);
								  }
								  JOptionPane.showMessageDialog(null, "All slots are booked");
								  
							  }
								else {
						 for (int j = 0; j < result; j++)
							{	
							if (results.get(j).equals("9.00 A.M"))
								{
								rb[0].setEnabled(false);								
								}
							else if (results.get(j).equals("9.30 A.M"))
								{
								rb[1].setEnabled(false);
								}
							else if (results.get(j).equals("10.00 A.M"))
								{
								rb[2].setEnabled(false);
								}
							else if (results.get(j).equals("10.30 A.M"))
								{
								rb[3].setEnabled(false);
								}
							else if (results.get(j).equals("11.00 A.M"))
								{
								rb[4].setEnabled(false);
								}
							else if (results.get(j).equals("11.30 A.M"))
								{
								rb[5].setEnabled(false);
								}
							
							}
								}
						 
				 }
				else {
					JOptionPane.showMessageDialog(null, "Appointment can be booked one day prior to 30 days from now");
				}
				}
		}
	}		
							
			
		
		
				
		
	
		

