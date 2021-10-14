package com.disney.service;

import org.springframework.stereotype.Component;

import com.disney.model.Usuario;

public interface ISendMailService {
	
	public void sendEmail(Usuario usuario);

}
