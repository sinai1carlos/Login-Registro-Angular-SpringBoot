package com.login.registro;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.login.registro.Controlador.UsuarioControlador;
import com.login.registro.modelo.Rol;
import com.login.registro.modelo.Usuario;
import com.login.registro.modelo.UsuarioRol;
import com.login.registro.servicios.UsuarioServicio;


@SpringBootApplication
public class LoginRegistroBackendApplication{

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private UsuarioControlador usuarioControlador;
	
	public static void main(String[] args) {
		
		SpringApplication.run(LoginRegistroBackendApplication.class, args);
	}
/*
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Pepe2");
		usuario.setUsername("pepe12");
		usuario.setEmail("pep2@gmail.com");
		usuario.setDireccion("Av. las palmeras 2352");
		usuario.setTelefono("998877664");
		usuario.setTipo("Masculino");
		usuario.setPassword("12345");
		
		Usuario usuarioGuardado = usuarioControlador.guardarUsuario(usuario);
		System.out.println(usuarioGuardado.getUsername());
		
		
		
		/*
		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");
		
		Set<UsuarioRol> usuarioRoles= new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);
		
		Usuario usuarioGuardado = usuarioServicio.guardarUsuario(usuario, usuarioRoles);
		System.out.println(usuarioGuardado.getUsername());
		
		
	}*/

}
