package com.hallbookingmanagement.controller;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String host = "smtp.gmail.com";
		    String username = "2k20it30@kiot.ac.in";
		    String password = "sanjai@4321";
		    String port = "587";

		    Properties props = new Properties();
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.port", port);

		    // create a mail session with the given properties
		    Session session = Session.getInstance(props, new Authenticator() {
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(username, password);
		        }
		    });
		    
		    Random random = new Random();
	        int otp  = 100000 + random.nextInt(900000);
	        
	        HttpSession otpSession = request.getSession();
	        otpSession.setAttribute("otp", otp);

		    String from = "2k20it30@kiot.ac.in";
		    String to = "sanjaisanjai561@gmail.com";
		    String subject = "Hi Bro from Royal Halls";
		    String body = "<div style=\"font-family: Helvetica,Arial,sans-serif;min-width:1000px;overflow:auto;line-height:2\">\r\n"
		    		+ "  <div style=\"margin:50px auto;width:70%;padding:20px 0\">\r\n"
		    		+ "    <div style=\"border-bottom:1px solid #eee\">\r\n"
		    		+ "      <a href=\"\" style=\"font-size:1.4em;color: #00466a;text-decoration:none;font-weight:600\">Your Brand</a>\r\n"
		    		+ "    </div>\r\n"
		    		+ "    <p style=\"font-size:1.1em\">Hi,</p>\r\n"
		    		+ "    <p>Thank you for choosing Your Brand. Use the following OTP to complete your Sign Up procedures. OTP is valid for 5 minutes</p>\r\n"
		    		+ "    <h2 style=\"background: #00466a;margin: 0 auto;width: max-content;padding: 0 10px;color: #fff;border-radius: 4px;\">"+otp+"</h2>\r\n"
		    		+ "    <p style=\"font-size:0.9em;\">Regards,<br />Your Brand</p>\r\n"
		    		+ "    <hr style=\"border:none;border-top:1px solid #eee\" />\r\n"
		    		+ "    <div style=\"float:right;padding:8px 0;color:#aaa;font-size:0.8em;line-height:1;font-weight:300\">\r\n"
		    		+ "      <p>Your Brand Inc</p>\r\n"
		    		+ "      <p>1600 Amphitheatre Parkway</p>\r\n"
		    		+ "      <p>California</p>\r\n"
		    		+ "    </div>\r\n"
		    		+ "  </div>\r\n"
		    		+ "</div>";

		    try {
		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress(from));
		        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		        message.setSubject(subject);
		        message.setContent(body,"text/html" );
		        // send the message
		        Transport.send(message);
		        request.getRequestDispatcher("/view/OtpVerifier.jsp").forward(request, response);
		    } catch(Exception e) {
		        System.out.print(e.getMessage());
		    }
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	public void messageSender(){
		
	}
}
