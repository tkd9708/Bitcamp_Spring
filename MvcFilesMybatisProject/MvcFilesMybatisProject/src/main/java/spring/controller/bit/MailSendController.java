package spring.controller.bit;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailSendController {

	@Autowired
	JavaMailSender mailSender;
	
	@GetMapping("/mail")
	public String mailForm() {
		return "/sub/mail/mailform";
	}
	
	@PostMapping("/mailsend1")
	public ModelAndView mailRead(
			@RequestParam String emailaddr,
			@RequestParam String emailcontent
			) {
		MimeMessage message = mailSender.createMimeMessage();

		ModelAndView mview = new ModelAndView();
		
		try {
			// 메일제목
			message.setSubject("스프링으로 메일보내기");
			// 메일본문
			message.setText(emailcontent);
			// 받을 메일 주소
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(emailaddr));
			// 여러명한테 보낼 시, InternetAddress를 배열로 만들어서 전송하던가 위 코드 여러번 하면됌
			// 메일전송
			mailSender.send(message);
			// 포워드파일로 메세지 보내기
			mview.addObject("msg", emailaddr + " 이메일로 메일 전송 성공!");
			
		} catch (MessagingException e) {
			mview.addObject("msg", "오류 : " + e.getMessage());
		}	
		
		mview.setViewName("/sub/mail/mailresult");
		return mview;
	}
}
