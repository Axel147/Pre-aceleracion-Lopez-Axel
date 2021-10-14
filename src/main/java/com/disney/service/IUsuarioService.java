package com.disney.service;

import com.disney.dto.UsuarioDTO;
import com.disney.model.Usuario;

public interface IUsuarioService {

	Usuario findByUsername(String username);

	Usuario save(UsuarioDTO usuarioDTO);

}
