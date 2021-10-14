package com.disney.builder;

import com.disney.dto.UsuarioDTO;
import com.disney.model.Usuario;

public class UsuarioBuilder {
	private String name;
	private String lastName;
	private String mail;
	private String username;
	private String password;
	
	public UsuarioBuilder withUsuarioDto(UsuarioDTO usuarioDTO) {
		this.name = usuarioDTO.getName();
		this.lastName = usuarioDTO.getLastName();
		this.mail = usuarioDTO.getMail();
		this.username = usuarioDTO.getUsername();
		this.password = usuarioDTO.getPassword();
		return this;
	}
	
	public Usuario build() {
		return new Usuario(name, lastName, mail, username, password);
	}
}
