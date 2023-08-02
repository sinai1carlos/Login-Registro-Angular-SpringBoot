package com.login.registro.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.registro.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	Usuario findByUsername(String username);
}
