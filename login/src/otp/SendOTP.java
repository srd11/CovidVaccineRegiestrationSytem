package otp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.net.ssl.HttpsURLConnection;

public class SendOTP {

	
	public static void sendOTP(String message , String number , String apiKey) {
		try
		{
		String sendId = "TXTIND";
		//String language="english";
		String route="v3";
		
		message=URLEncoder.encode(message,"UTF-8");
		
		String myURL="https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&route="+route+"&numbers="+number;
		
		URL url = new  URL(myURL);
		HttpsURLConnection con =(HttpsURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User.Agent", "Chrome");
		con.setRequestProperty("cache control", "no-cache");
		//System.out.println("Wait.....");
		int responseCode = con.getResponseCode();
		//System.out.println("Response Code : "+responseCode);
		
		
		StringBuffer response = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true)
		{
			
			String line = br.readLine();
			if(line==null) {
				break;
			}
			response.append(line);
		}
		
		//System.out.println(response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
		
	/*public void set_Time() {
		timer.scheduleAtFixedRate(task,0,1000);
	}
		*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println("Progress started......");
		//OTP otp = new OTP();
	//	Login l = new Login();
		//String otpmessage=otp.generateOTP(6);
		//System.out.println("Generate Otp : "+otpmessage);
		
		//String apiKey="huc5jqxntR8L9PHlF4zsmKEY7DpfCrbB3SMWTgVZy2GaINJkiv0Qse2putdJ1XzNiEnSh3IcomkqFCRv";
		//String number="7900148501";
		//String number=l.tx1.getText();
		
		//sendOTP("Hey this message is send by Shruti.Your OTP is"+otpmessage,number,apiKey);
	
		 
		
	}}


