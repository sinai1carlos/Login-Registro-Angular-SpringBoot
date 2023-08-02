package com.login.registro.servicios;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.registro.Repositorio.UsuarioRepositorio;
import com.login.registro.modelo.Usuario;
import com.login.registro.modelo.UsuarioRol;

@Service
public interface UsuarioServicio {
	
	public boolean autenticador(String username,String password);
	
	public Usuario guardarUsuario(Usuario usuario,Set<UsuarioRol> usuarioRoles) throws Exception;
	
	public Usuario obtenerUsuario(String username);
	
	public void eliminarUsuario(Integer usuarioId);
}
