package user.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;
import util.Gmail;
import util.SHA256;

@WebServlet("/findpwd.ed")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindPasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("uemail");
		User user = new UserService().getUserOneByMail(SHA256.getSHA256(uemail));
		if(user != null) {
			String host = "http://localhost:8888/testt/";
			String from = "kwanigi2005@gmail.com";
			String to = uemail;
			String subject = "[TALMOVE]비밀번호 변경을 위한 인증 메일입니다.";
			String content = "아래 링크에 접속하여 이메일 인증을 완료하고 비밀번호 변경을 진행하세요" 
							+ "<br><a href='" + host + "newpwd?code=" + SHA256.getSHA256(to) + "'>비밀번호 변경하러 가기</a>";
			
			//SMTP에 접속하기 위한 정보 기입
			Properties p = new Properties();
			p.put("mail.smtp.user", from);
			p.put("mail.smtp.host", "smtp.googlemail.com");
			p.put("mail.smtp.port", "465");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.debug", "true");
			p.put("mail.smtp.socketFactory.port", "465");
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.socketFactory.fallback", "false");
			
			//메일 전송하고 메일 전송확인 페이지로 이동
			try {
				Authenticator auth = new Gmail();
				Session ses = Session.getInstance(p, auth);
				ses.setDebug(true);
				MimeMessage msg = new MimeMessage(ses);
				msg.setSubject(subject);
				Address fromAddr = new InternetAddress(from);
				msg.setFrom(fromAddr);
				Address toAddr = new InternetAddress(to);
				msg.addRecipient(Message.RecipientType.TO, toAddr);
				msg.setContent(content, "text/html;charset=UTF-8");
				Transport.send(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("메일전송완료");
		}else {
			
		}
		RequestDispatcher view = request.getRequestDispatcher("emailSended.jsp");
		request.setAttribute("uemail", uemail);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
