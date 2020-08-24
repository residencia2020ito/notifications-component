package com.notification.springboot.sending.app.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.exceptions.TemplateInputException;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.notification.springboot.sending.app.model.SendEmail;

@Service
public class EmailSenderService {
	
	private static final Logger log = LoggerFactory.getLogger(EmailSenderService.class);

	@Autowired
	private JavaMailSender emailSender;
	@Autowired
	private SpringTemplateEngine templateEngine;

	@Value(value = "${spring.mail.username}")
	private String email;
	

	public void sendEmail(SendEmail mail) throws MessagingException, IOException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
		Context context = new Context();
		context.setVariables(mail.getMap());

	
		try {
			String html = templateEngine.process(mail.getIdPlantilla(), context);

			helper.setTo(mail.getPara());
			helper.setText(html, true);
			helper.setSubject(mail.getAsunto());
			helper.setFrom(email);
			emailSender.send(message);
		}catch (TemplateInputException e) {
			log.error("Plantilla no encontrada:{} ",mail.getIdPlantilla(),e);
		}
		

	}

}
