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
import View.HospVenture_View;
import View.Report_View;

public class Hosp_Venture {

	JFrame HospV = new JFrame("Hospital Venture");
	JLabel lImg, welcomtex, dateText, startDate, endDate, cp,cpn,conText ;
	JButton resetSD, resetED, submit, goBack;
	JTextField sDate, eDate;
	Date date;
	int MM, DD, YYYY;
	Color c;
	ImageIcon img;
	String Date_Final_Start,Date_Final_End, YY;
	JDateChooser sdateChooser = new JDateChooser();
	JDateChooser edateChooser = new JDateChooser();
	
	//Create Ref Object
	HospVenture_View HV = new HospVenture_View();
	EmptyFields_Error_Handler EEH = new EmptyFields_Error_Handler();
	
	public Hosp_Venture()
	{
		
		
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
	
		
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		HospV.getContentPane().setBackground(c);
		
	
		
	
		welcomtex = new JLabel("Hello, Welcome to Hospital Venture Report Section.");
		welcomtex.setBounds(570, 10, 450, 100);
		welcomtex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomtex.setForeground(Color.gray);
		dateText = new JLabel("Please Select Your Dates for the Report Generation");
		dateText.setBounds(570,90,400,50);
		dateText.setFont(new Font("Calibri", Font.BOLD, 15));
		dateText.setForeground(Color.gray);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);
		
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
						
						HV.HospVenture(getStartDate(), getEndDate());
					}
					else
					{
						JOptionPane.showMessageDialog(submit, "Please Choose End Date");
						EEH.endDateEmptyReport("Mgmt Hosp Venture Report");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(submit, "Please Choose Start Date");
					EEH.startDateEmptyReport("Mgmt Hosp Venture Report");
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
				HospV.setVisible(false);
				
			}
		});
	
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		
		HospV.add(cp);
		HospV.add(cpn);
		HospV.add(lImg);
		HospV.add(welcomtex);
		HospV.add(conText);
		HospV.add(dateText);
		HospV.add(startDate);
		HospV.add(endDate);
		HospV.add(sdateChooser);
		HospV.add(edateChooser);
		HospV.add(resetSD);
		HospV.add(resetED);
		HospV.add(submit);
		HospV.add(goBack);
		
		HospV.setLayout(null);
		HospV.setSize(1500, 1500);
		HospV.setVisible(true);
		
	}
	
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


		public String getEndDate() 
		{
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
	



