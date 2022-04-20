package otp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	    JPanel contentPane;
	    JTextField tx1;
        JTextField tx2;
        JLabel lblNewLabel_1,l3_timer;
        JTextField tx3_timer;
        JButton b3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Number");
		lblNewLabel.setBounds(59, 56, 76, 14);
		contentPane.add(lblNewLabel);
		
		OTP otp = new OTP();
		
		SendOTP s= new SendOTP();
		//SendOTP s1= new SendOTP();
		String apiKey="huc5jqxntR8L9PHlF4zsmKEY7DpfCrbB3SMWTgVZy2GaINJkiv0Qse2putdJ1XzNiEnSh3IcomkqFCRv";
		String otpmessage=otp.generateOTP(6);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
 
			int counter = 10;
			@Override
			public void run() {
				if(counter>-1) {
					
					tx3_timer.setText(Integer.toString(counter));
					//System.out.println(counter+ "seconds");
					counter--;
					
					
				}
				if(counter==-1) {
				tx3_timer.setVisible(false);
				b3.setVisible(true);
				}
			//	/*else {
				//	System.out.println("Happy New Year!");
				//	timer.cancel();
				//}
				
			
				
			}
		};
		
		//timer.schedule(task,1000);
		/*Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR,2023);
		date.set(Calendar.MONTH,Calendar.JANUARY);
		date.set(Calendar.DAY_OF_MONTH,1);
		date.set(Calendar.HOUR_OF_DAY,0);
		date.set(Calendar.MINUTE,7);
		date.set(Calendar.SECOND,20);
		date.set(Calendar.MILLISECOND,0);*/
		
		//System.out.println("Task is Completed : ");
		//timer.schedule(task, date.getTime());
		//timer.scheduleAtFixedRate(task,0,1000);
		//timer.scheduleAtFixedRate(task, date.getTime(), 1000);
		
		tx1 = new JTextField();
		
		tx1.setToolTipText("Enter mobile number");
		tx1.setBounds(217, 53, 86, 20);
		contentPane.add(tx1);
		tx1.setColumns(10);
		tx1.setText("");
		
		JButton b1 = new JButton("Send OTP");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String number=tx1.getText();
				
					if(number=="") {
						String st = "Enter mobile number";
						JOptionPane.showMessageDialog(null, st);
					}
					else {
						
						s.sendOTP("Hey this message is send by Shruti.Your OTP is"+otpmessage,number,apiKey);
						tx3_timer.setVisible(true);
						timer.scheduleAtFixedRate(task,0,1000);
						
					}
				
				/*(catch(Exception e1) {
					String st = "";
					 JOptionPane.showMessageDialog(null, st+e);
				}*/
				//s.sendOTP("Hey this message is send by Shruti.Your OTP is"+otpmessage,number,apiKey);
				
				
				
			}
		});
		b1.setBounds(104, 102, 89, 23);
		contentPane.add(b1);
		
		tx2 = new JTextField();
		tx2.setBounds(217, 155, 86, 20);
		contentPane.add(tx2);
		tx2.setColumns(10);
		
		JButton b2 = new JButton("OK");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String OtpC=tx2.getText();
				 if(OtpC.equals(otpmessage) && Integer.parseInt(tx3_timer.getText())>0){
					 
					 Index i= new Index();
					 i.show();
					 dispose();
				 }
				 else {
					 String st = "Enter Valid OTP or Timeout";
					 JOptionPane.showMessageDialog(null, st);
				 }
			}
		});
		b2.setBounds(134, 194, 89, 23);
		contentPane.add(b2);
		
		lblNewLabel_1 = new JLabel("Enter OTP");
		lblNewLabel_1.setBounds(59, 161, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		tx3_timer = new JTextField();
		tx3_timer.setBounds(8, 103, 86, 20);
		contentPane.add(tx3_timer);
		tx3_timer.setColumns(10);
		
	    
	    b3 = new JButton("Resend OTP");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=tx1.getText();
				
			/*	if(number=="") {
					String st = "Enter mobile number";
					JOptionPane.showMessageDialog(null, st);
				}*/
				
				     String otpmessage=otp.generateOTP(6);
					s.sendOTP("Hey this message is send by Shruti.Your OTP is"+otpmessage,number,apiKey);
					tx3_timer.setVisible(true);
					timer.scheduleAtFixedRate(task,0,1000);
					
				
			
			}
		});
		b3.setBounds(214, 102, 115, 23);
		contentPane.add(b3);
		tx3_timer.setVisible(false);
		b3.setVisible(false);
	}
}
