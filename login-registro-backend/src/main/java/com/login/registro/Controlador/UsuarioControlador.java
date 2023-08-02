package com.login.registro.Controlador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.registro.modelo.LoginForm;
import com.login.registro.Repositorio.UsuarioRepositorio;
import com.login.registro.modelo.Rol;
import com.login.registro.modelo.Usuario;
import com.login.registro.modelo.UsuarioRol;
import com.login.registro.servicios.UsuarioServicio;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioControlador {
	@Autowired //envia una inyeccion de la variable a @repository
	public UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("/usuarios")
	public List<Usuario> listarEmpleados(){
		return usuarioRepositorio.findAll();
	}
	
	@PostMapping("/login")
	private ResponseEntity<String> login(@RequestBody LoginForm loginform){
		System.out.println(loginform.getUsername());
		System.out.println(loginform.getPassword());
		String username=loginform.getUsername();
		String password=loginform.getPassword();
		// Aquí implementamos la lógica de autenticación utilizando el servicio UserService
		if (usuarioServicio.autenticador(username, password)) {
	        // Si las credenciales son válidas, devolvemos un objeto JSON con un mensaje
			return ResponseEntity.ok("{\"message\": \"Autenticación exitosa\",\"ok\": true}");

	    } else {
	        // Si las credenciales son inválidas, devolvemos una respuesta de error con un mensaje
	    	return ResponseEntity.ok("{\"message\": \"Credenciales inválidas\",\"ok\": false}");
	    	//return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
	    }
	}
	//metodo para guardar y actualizar
	@PostMapping("/usuario")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
		
		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		
		Rol rol = new Rol();
		rol.setRolId(2L);
		rol.setNombre("NORMAL");
		
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		
		usuarioRoles.add(usuarioRol);
		
		return usuarioServicio.guardarUsuario(usuario, usuarioRoles);
	}
	
	@GetMapping("/{username}")
	public Usuario obtenerUsuario(@PathVariable("username") String username) {
		return usuarioServicio.obtenerUsuario(username);
	}
	
	@DeleteMapping("/{usuarioId}")
	public void eliminarUsuario(@PathVariable("usuarioId") Integer usuarioId) {
		usuarioServicio.eliminarUsuario(usuarioId);
	}
}
