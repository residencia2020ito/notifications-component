package com.notification.springboot.sending.app.service;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.notification.springboot.sending.app.model.SendEmail;
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsSenderService {

	private static final Logger log = LoggerFactory.getLogger(SmsSenderService.class);

	@Value(value = "${twilioSMS-ACCOUNT_SID.value}")
	private String ACCOUNT_SID;
	@Value(value = "${twilioSMS-AUTH_TOKEN.value}")
	private String AUTH_TOKEN;
	@Value(value = "${twilioSMS-TWILIO_NUMBER.value}")
	private String TWILIO_NUMBER;
	
	
/*
	public void sendSms(SendEmail sms) throws MessagingException, IOException {

		Map<String, Object> map = sms.getMap();

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message messageT = Message
				.creator(new PhoneNumber("+529512182680"), new PhoneNumber(TWILIO_NUMBER),
						"Bienvenid@ " + map.get("name") + " a Yo Consumo, tu telefono quedo registrado")
				.setMediaUrl(Promoter.listOfOne(
						URI.create("https://blogs.unsw.edu.au/nowideas/files/2019/02/musica-sin-copyright.jpg")))
				.create();
		log.info("Envio sms");
	}
	*/
}
