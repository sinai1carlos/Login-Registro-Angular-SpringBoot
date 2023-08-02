package com.login.registro.servicios.implementaciones;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.registro.Repositorio.RolRepositorio;
import com.login.registro.Repositorio.UsuarioRepositorio;
import com.login.registro.modelo.Usuario;
import com.login.registro.modelo.UsuarioRol;
import com.login.registro.servicios.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private RolRepositorio rolRepositorio;
	
	public boolean autenticador(String username,String password) {
		System.out.println("Usuario recibido: " + username);
        System.out.println("Contraseña recibida: " + password);
        Usuario usuario = usuarioRepositorio.findByUsername(username);

        // Verificar si el usuario existe y si la contraseña coincide
        if (usuario != null && usuario.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
		Usuario usuarioLocal= usuarioRepositorio.findByUsername(usuario.getUsername());
		if(usuarioLocal !=null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya está presente");
		}
		else {
			for(UsuarioRol usuarioRol:usuarioRoles) {
				rolRepositorio.save(usuarioRol.getRol());
			}
			usuario.getUsuarioRoles().addAll(usuarioRoles);
			usuarioLocal = usuarioRepositorio.save(usuario);
		}
		return usuarioLocal;
	}

	@Override
	public Usuario obtenerUsuario(String username) {
		return usuarioRepositorio.findByUsername(username);
	}

	@Override
	public void eliminarUsuario(Integer usuarioId) {
		usuarioRepositorio.deleteById(usuarioId);
	}


}
