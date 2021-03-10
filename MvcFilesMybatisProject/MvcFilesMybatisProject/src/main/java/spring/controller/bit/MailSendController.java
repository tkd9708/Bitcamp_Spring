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
			// ��������
			message.setSubject("���������� ���Ϻ�����");
			// ���Ϻ���
			message.setText(emailcontent);
			// ���� ���� �ּ�
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(emailaddr));
			// ���������� ���� ��, InternetAddress�� �迭�� ���� �����ϴ��� �� �ڵ� ������ �ϸ��
			// ��������
			mailSender.send(message);
			// ���������Ϸ� �޼��� ������
			mview.addObject("msg", emailaddr + " �̸��Ϸ� ���� ���� ����!");
			
		} catch (MessagingException e) {
			mview.addObject("msg", "���� : " + e.getMessage());
		}	
		
		mview.setViewName("/sub/mail/mailresult");
		return mview;
	}
}
