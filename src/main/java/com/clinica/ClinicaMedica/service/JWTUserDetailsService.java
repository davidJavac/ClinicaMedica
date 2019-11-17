package com.clinica.ClinicaMedica.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.DTO.UsuarioDTO;
import com.clinica.ClinicaMedica.model.Usuario;
import com.clinica.ClinicaMedica.repository.UsuarioRepository;

@Service
public class JWTUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
		
		if(usuario == null) {
			
			throw new UsernameNotFoundException("Usuario no encontrado con nombre " + nombreUsuario); 
		}
		
		return new org.springframework.security.core.userdetails.User(usuario.getNombreUsuario(), usuario.getPassword(),
				new ArrayList<>());
		
	}
	
	public Usuario save(UsuarioDTO user) {
		Usuario newUser = new Usuario();
		newUser.setNombreUsuario(user.getNombreUsuario());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return usuarioRepository.save(newUser);
	}
	
}
