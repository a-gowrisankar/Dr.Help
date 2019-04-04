package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;

import Dr.Help.IssueDescription;
import Dr.Help.Login_All;
import Dr.Help.UserAppConfirmation;
import Models.InsertInToDB;
import Models.ResultSetFetch;

public class Appointment_summary {

	JFrame as = new JFrame("Summary Screen");
	JLabel welcomTex,welcomTex2 ,email, pwd, catDesc,conText,cp,cpn,lImg,cancelapt;
	JLabel hospital_name,slot,date,doctor,category,appointment_id;
	JPanel backgroundPanel;
	JButton cancel,bnew,Logout,history;
	Color c;
	ImageIcon img;
	ResultSet rs=null;
	List<String> results = new ArrayList<String>();
	String appid,hname,cat,doc,day,hour,catt,city;
	int ConfirmMessage;
	public Appointment_summary(String dte,String time,String hosp,String uname) throws Exception
	
	{
		
		rs=ResultSetFetch.getsummary(dte,time,hosp,uname);
		city=UserAppConfirmation.locName.toUpperCase();
		while(rs.next())
		{
			appid=rs.getString(1);
			hname=rs.getString(2);
			cat=rs.getString(7);
			doc=rs.getString(6);
			day=rs.getString(3);
			hour=rs.getString(4);
			
		}
		rs.close();
		
		if(cat.equals("1"))
		{
			catt="Head";
		}
		else if(cat.equals("2"))
		{
			catt="Neck to Knee";
		}
		else if(cat.equals("3"))
		{
			catt="Knee to Toe";
		}
		img = new ImageIcon("E:\\IIT-C\\Sem-I\\OOAD\\Assignment\\HMS\\Doctor1.png");
		lImg = new JLabel(img);
		lImg.setBounds(20, 80, 20, 20);
		lImg.setSize(450, 450);
		c = new Color(245, 252, 196);
		as.getContentPane().setBackground(c);

		backgroundPanel = new JPanel();
		backgroundPanel.add(lImg);
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));
		backgroundPanel.setOpaque(true);
		
		conText = new JLabel("Dr.Help");
		conText.setBounds(190, 90, 250, 100);
		conText.setFont(new Font("Calibri", Font.BOLD, 35));
		conText.setForeground(Color.gray);

		welcomTex = new JLabel("Appointment Confirmation",SwingConstants.CENTER);
		welcomTex.setBounds(0, 10, 1500, 100);
		welcomTex.setFont(new Font("Calibri", Font.BOLD, 20));
		welcomTex.setForeground(Color.gray);
		
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
				as.setVisible(false);
			}
		});
		
		hospital_name = new JLabel("Hospital Name - "+hname+" in "+city,SwingConstants.CENTER);
		hospital_name.setFont(new Font("Calibri", Font.BOLD, 20));
		hospital_name.setBounds (0, 255, 1500, 50);

		appointment_id = new JLabel("Appointment number - "+appid,SwingConstants.CENTER);	 
		appointment_id.setFont(new Font("Calibri", Font.BOLD, 20));
		appointment_id.setBounds(0, 180, 1500, 100);

		category = new JLabel("Visiting category - "+catt,SwingConstants.CENTER);
		category.setFont(new Font("Calibri", Font.BOLD, 20));
		category.setBounds(0, 305, 1500, 50);

		doctor=new JLabel("Appointment scheduled to Dr."+doc,SwingConstants.CENTER);
		doctor.setFont(new Font("Calibri", Font.BOLD, 20));
		doctor.setBounds(0, 350, 1500, 50);


		date=new JLabel("Date of visit - "+day,SwingConstants.CENTER);
		date.setFont(new Font("Calibri", Font.BOLD, 20));
		date.setBounds(0, 400, 1500, 50);


		slot=new JLabel("Time scheduled for visit - "+hour,SwingConstants.CENTER);
		slot.setFont(new Font("Calibri", Font.BOLD, 20));
		slot.setBounds(0, 450, 1500, 50);
		
		cancelapt = new JLabel("Appointment cancelled",SwingConstants.CENTER);
		cancelapt.setFont(new Font("Calibri", Font.BOLD, 20));
		cancelapt.setBounds(0, 325, 1500, 50);
		cancelapt.setVisible(false);

		cancel = new JButton("Cancel ");
		cancel.setFont(new Font("Calibri", Font.PLAIN, 15));
		cancel.setBounds(625,550 , 100, 20);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e ) {
				try {
					ConfirmMessage = JOptionPane.showConfirmDialog(null, "Are you sure to cancel the appointment");
					if(ConfirmMessage == JOptionPane.YES_OPTION)
					{
					InsertInToDB.cancelappointment(dte,time,hosp,uname);
					appointment_id.setVisible(false);
					hospital_name.setVisible(false);
					category.setVisible(false);
					doctor.setVisible(false);
					date.setVisible(false);
					slot.setVisible(false);
					cancelapt.setVisible(true);
					cancel.setEnabled(false);
					}
				
					}catch(Exception v)
				{
						v.printStackTrace();
				}
				
			}
		});
		
		bnew = new JButton(" Book New");
		bnew.setFont(new Font("Calibri", Font.PLAIN, 15));
		bnew.setBounds(775, 550, 100, 20);
		bnew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e ) {
				new IssueDescription();
				as.setVisible(false);
		}});
		
		
		cp = new JLabel("© Pixelboy");
		cp.setFont(new Font("Calibri", Font.PLAIN, 10));
		cp.setBounds(1150, 600, 200, 100);
		cpn = new JLabel("Ananth, Ashok and Gowrisankar");
		cpn.setFont(new Font("Calibri", Font.PLAIN, 10));
		cpn.setBounds(1150, 615, 200, 100);
		as.add(lImg);
		as.add(appointment_id);
		as.add(hospital_name);
		as.add(category);
		as.add(doctor);
		as.add(date);
		as.add(slot);
		as.add(welcomTex);
		as.add(cancelapt);
		as.add(conText);
		as.add(Logout);
		as.add(cancel);
		as.add(bnew);
		as.add(cp);
		as.add(cpn);
		as.setLayout(null);
		as.setSize(1500, 1500);	
		as.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception
	{
		new Appointment_summary("test","test","test","test");
	}

}
