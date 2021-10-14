package com.disney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.builder.UsuarioBuilder;
import com.disney.dto.UsuarioDTO;
import com.disney.model.Usuario;
import com.disney.repository.UsuarioRepository;
import com.disney.service.ISendMailService;
import com.disney.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ISendMailService sendMailService;
	
	@Override
	public Usuario findByUsername(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username);
		return usuario;
	}

	@Override
	public Usuario save(UsuarioDTO usuarioDTO) {
		Usuario usuario = new UsuarioBuilder().withUsuarioDto(usuarioDTO).build();
		usuario = usuarioRepository.save(usuario);
		sendMailService.sendEmail(usuario);
		return usuario;
	}
	
}
