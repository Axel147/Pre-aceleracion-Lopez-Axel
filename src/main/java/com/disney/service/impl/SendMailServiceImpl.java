package com.disney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.disney.model.Usuario;
import com.disney.service.ISendMailService;
@Service
public class SendMailServiceImpl implements ISendMailService{
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendEmail(Usuario usuario) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(usuario.getMail());
		mailMessage.setSubject("Bienvenido");
		mailMessage.setText("Su cuenta a sido creada con exito");
		mailSender.send(mailMessage);
		
	}
	
	
		
		
}
