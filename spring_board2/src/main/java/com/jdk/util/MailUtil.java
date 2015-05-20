package com.jdk.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.StringUtils;

import com.jdk.mem.action.memberMainMoveAction;
import com.jdk.vo.*;



public class MailUtil extends HttpServlet{
	@Autowired
	private JavaMailSender mailSender;
	
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}


	public void sendMail(MemberVO membervo,org.apache.log4j.Logger logger) {
		logger.info("[{}] 메일 발송 시작");
		
		MimeMessage message = mailSender.createMimeMessage();
        try {
        	MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            messageHelper.setSubject("[공지] 회원 가입 안내(첨부파일포함)");
            String htmlContent = "<strong>안녕하세요</strong>, 반갑습니다.";
            messageHelper.setText(htmlContent, true);
            messageHelper.setFrom("iirw8888@naver.com", "동궈");
            
            messageHelper.setTo(new InternetAddress(membervo.getUser_Email(), "받는사람은 지동근", "UTF-8"));
            DataSource dataSource = new FileDataSource("c:\\제목 없음.png");
            messageHelper.addAttachment(MimeUtility.encodeText("낚서.png", "UTF-8", "B"), dataSource);
            mailSender.send(message);
            
        } catch (MessagingException e) {
            e.printStackTrace();
            return;
        } catch (MailException e) {
            e.printStackTrace();
            return;
        } // try - catch
 catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
