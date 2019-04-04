package Dr.Help;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ErrorHandler.EmptyFields_Error_Handler;
import View.Report_View;

public class Management_Report {

	JFrame MR = new JFrame("Management Report Section");
	JLabel cp,cpn,conText, lImg, welcomSec;
	JButton docReport, userReport, RaiseANewReq, HospSearch, HospVenture, HospCategory;
	JTextField sDate, eDate;
	ImageIcon img;
	Color c;
	Date date;
	int MM, DD, YYYY;
	String Date_Final_Start,Date_Final_End, YY;
	JDateChooser sdateChooser = new JDateChooser();
	JDateChooser edateChooser = new JDateChooser();
	View.Report_View RV = new Report_View();

	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	
	
	public Management_Report()
	{
		
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		MR.getContentPane().setBackground(c);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
		
		
		welcomSec = new JLabel("Please Select Your Option for Reports");
		welcomSec.setBounds(640,50,400,100);
		welcomSec.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomSec.setForeground(Color.gray);
		
		
		docReport = new JButton("Doctor Report");
		docReport.setBounds(530,150,170,20);
		docReport.setFont(new Font("Calibri", Font.PLAIN, 15));
		docReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doctorReport();
				MR.setVisible(false);
				
			}
		});
		
		
		userReport = new JButton("User Report");
		userReport.setBounds(730,150,170,20);
		userReport.setFont(new Font("Calibri", Font.PLAIN, 15));
		userReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userReport();
				MR.setVisible(false);
			}
		});
		
		
		RaiseANewReq = new JButton("Raise A Request");
		RaiseANewReq.setFont(new Font("Calibri", Font.PLAIN, 15));
		RaiseANewReq.setBounds(930, 150, 170, 20);
		RaiseANewReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admin_Help("Management");
				MR.setVisible(false);
			}
		});
		
		
		HospSearch = new JButton("Hospital Search");
		HospSearch.setFont(new Font("Calibri", Font.PLAIN, 15));
		HospSearch.setBounds(530, 200, 170, 20);
		HospSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new NearByMedicalShop("MANAGEMENT");
				MR.setVisible(false);
			}
		});
		
		HospVenture = new JButton("Hospital Venture");
		HospVenture.setFont(new Font("Calibri", Font.PLAIN, 15));
		HospVenture.setBounds(730, 200, 170, 20);
		HospVenture.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Hosp_Venture();
				MR.setVisible(false);
			}
		});
		
		HospCategory = new JButton("Hospital Category List");
		HospCategory.setFont(new Font("Calibri", Font.PLAIN, 15));
		HospCategory.setBounds(930, 200, 170, 20);
		HospCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Hosp_Category();
				MR.setVisible(false);
			}
		});
		
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		MR.add(cp);
		MR.add(cpn);
		MR.add(lImg);
		MR.add(conText);
		MR.add(welcomSec);
		MR.add(docReport);
		MR.add(userReport);
		MR.add(RaiseANewReq);
		MR.add(HospSearch);
		MR.add(HospCategory);
		MR.add(HospVenture);
		MR.setSize(1500, 1500);
		MR.setLayout(null);
		MR.setVisible(true);
	}
	
	public void doctorReport()
	{
		JFrame DR = new JFrame("Doctor Report");
		JLabel lImg, welcomtex, dateText, startDate, endDate ;
		JButton resetSD, resetED, submit, goBack;
		Color c;
		ImageIcon img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
	
		
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		DR.getContentPane().setBackground(c);
		
	
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
	
		welcomtex = new JLabel("Hello, Welcome to Doctor's Report Section.");
		welcomtex.setBounds(570, 10, 400, 100);
		welcomtex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomtex.setForeground(Color.gray);
		dateText = new JLabel("Please Select Your Dates for the Report Generation");
		dateText.setBounds(570,90,400,50);
		dateText.setFont(new Font("Calibri", Font.BOLD, 15));
		dateText.setForeground(Color.gray);
		
		
		startDate = new JLabel("Enter Your Start Date");
		startDate.setBounds(570,150,150,50);
		startDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		sdateChooser.setBounds(750, 165, 150, 20);
		sDate = new JTextField();
		
				
		endDate = new JLabel("Enter Your End Date");
		endDate.setBounds(570,210,150,50);
		endDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		edateChooser.setBounds(750,225,150,20);
		eDate = new JTextField();
		
		resetSD = new JButton("Reset Start Date");
		resetSD.setBounds(570,280,135,20);
		resetSD.setFont(new Font("Calibri", Font.PLAIN, 15));
		resetSD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sdateChooser.setDate(null);
			}
		});
		
		resetED = new JButton("Reset End Date");
		resetED.setBounds(750,280,135,20);
		resetED.setFont(new Font("Calibri", Font.PLAIN, 15));
		resetED.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				edateChooser.setDate(null);
			}
		});
		
		submit = new JButton("Fetch Reports");
		submit.setBounds(570,350,135,20);
		submit.setFont(new Font("Calibri", Font.PLAIN, 15));
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(sdateChooser.getDate() != null)
				{
					if(edateChooser.getDate() != null)
					{
						
						RV.DocViewList(getStartDate(), getEndDate());
					}
					else
					{
						JOptionPane.showMessageDialog(submit, "Please Choose End Date");
						EEH.endDateEmptyReport("Mgmt Doc Report");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(submit, "Please Choose Start Date");
					EEH.startDateEmptyReport("Mgmt Doc Report");
				}
				
			}
		});
				
		goBack = new JButton("Go Back");
		goBack.setBounds(750, 350, 135, 20);
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Management_Report();
				DR.setVisible(false);
				
			}
		});
	
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		DR.add(cp);
		DR.add(cpn);
		DR.add(lImg);
		DR.add(conText);
		DR.add(welcomtex);
		DR.add(dateText);
		DR.add(startDate);
		DR.add(endDate);
		DR.add(sdateChooser);
		DR.add(edateChooser);
		DR.add(resetSD);
		DR.add(resetED);
		DR.add(submit);
		DR.add(goBack);
		
		DR.setLayout(null);
		DR.setSize(1500, 1500);
		DR.setVisible(true);
		
		
	
	}
	
	public void userReport()
	{
		JFrame DR = new JFrame("Doctor Report");
		JDateChooser sdateChooser = new JDateChooser();
		JDateChooser edateChooser = new JDateChooser();
		sdateChooser.setDateFormatString("yyyy-MM-dd");
		edateChooser.setDateFormatString("yyyy-MM-dd");
		ImageIcon img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		JLabel lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		Color c = new Color(245, 252, 196);
		DR.getContentPane().setBackground(c);
		
		JLabel welcomtex, dateText, startDate, endDate ;
		JButton resetSD, resetED, submit, goBack;
	
		welcomtex = new JLabel("Hello, Welcome to User's Report Section.");
		welcomtex.setBounds(570, 10, 400, 100);
		welcomtex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomtex.setForeground(Color.gray);
		dateText = new JLabel("Please Select Your Dates for the Report Generation");
		dateText.setBounds(570,90,400,50);
		dateText.setFont(new Font("Calibri", Font.BOLD, 15));
		dateText.setForeground(Color.gray);
		
		
		startDate = new JLabel("Enter Your Start Date");
		startDate.setBounds(570,150,150,50);
		startDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		sdateChooser.setBounds(750, 165, 150, 20);
		sDate = new JTextField();
				
		endDate = new JLabel("Enter Your End Date");
		endDate.setBounds(570,210,150,50);
		endDate.setFont(new Font("Calibri", Font.PLAIN, 15));
		edateChooser.setBounds(750,225,150,20);
		eDate = new JTextField();
		
		resetSD = new JButton("Reset Start Date");
		resetSD.setBounds(570,280,135,20);
		resetSD.setFont(new Font("Calibri", Font.PLAIN, 15));
		resetSD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sdateChooser.setDate(null);
			}
		});
		
		resetED = new JButton("Reset End Date");
		resetED.setBounds(750,280,135,20);
		resetED.setFont(new Font("Calibri", Font.PLAIN, 15));
		resetED.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				edateChooser.setDate(null);
			}
		});
		
		
		submit = new JButton("Fetch Reports");
		submit.setBounds(570,350,135,20);
		submit.setFont(new Font("Calibri", Font.PLAIN, 15));
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(sdateChooser.getDate() != null)
				{
					if(edateChooser.getDate() != null)
					{
					 System.out.println("Not Yet");
					}
					else
					{
						JOptionPane.showMessageDialog(submit, "Please Choose End Date");
						EEH.endDateEmptyReport("Mgmt User Report");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(submit, "Please Choose Start Date");
					EEH.startDateEmptyReport("Mgmt User Report");
				}
			}
		});
				
		goBack = new JButton("Go Back");
		goBack.setBounds(750, 350, 135, 20);
		goBack.setFont(new Font("Calibri", Font.PLAIN, 15));
		goBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Management_Report();
				DR.setVisible(false);
				
			}
		});
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		DR.add(cp);
		DR.add(cpn);
		DR.add(lImg);
		DR.add(conText);
		DR.add(welcomtex);
		DR.add(dateText);
		DR.add(startDate);
		DR.add(endDate);
		DR.add(sdateChooser);
		DR.add(edateChooser);
		DR.add(resetSD);
		DR.add(resetED);
		DR.add(submit);
		DR.add(goBack);
		DR.setLayout(null);
		DR.setSize(1500, 1500);
		DR.setVisible(true);
		
	
	}
	
	@SuppressWarnings("deprecation")
	public String getStartDate() 
	{
		date = sdateChooser.getDate();
		MM = date.getMonth();
		DD = date.getDate();
		YYYY = date.getYear();
		if (YYYY >= 100) {
			YY = String.valueOf(YYYY).substring(1);
			Date_Final_Start = ((MM + 1) + "-" + DD + "-" + YY);
		} else {
			Date_Final_Start = ((MM + 1) + "-" + DD + "-" + YYYY);
			System.out.println(Date_Final_Start);
		}

		System.out.println(Date_Final_Start);
		return Date_Final_Start;
	}


@SuppressWarnings("deprecation")
public String getEndDate() {
		date = edateChooser.getDate();
		MM = date.getMonth();
		DD = date.getDate();
		YYYY = date.getYear();
		if (YYYY >= 100) {
			YY = String.valueOf(YYYY).substring(1);
			Date_Final_End = ((MM + 1) + "-" + DD + "-" + YY);
		} else {
			Date_Final_End = ((MM + 1) + "-" + DD + "-" + YYYY);
			System.out.println(Date_Final_End);
		}

		System.out.println(Date_Final_End);
		return Date_Final_End;
	}
	

}
