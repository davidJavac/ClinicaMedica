package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Usuario;
import com.clinica.ClinicaMedica.repository.UsuarioRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Optional<ResponseTransfer<Usuario>> registrarUsuario(Usuario usuario) throws BusinessException{
		// TODO Auto-generated method stub
			
		if(!usuarioRepository.existsByNombreUsuario(usuario.getNombreUsuario())) {
			try {
				
				Usuario usuario_saved = usuarioRepository.save(usuario);
				ResponseTransfer<Usuario> rt = new ResponseTransfer("El usuario se ha registrado con éxito", usuario_saved);
				return Optional.of(rt);
			}
			catch(Exception e) {
				
				return Optional.empty();
				
			}
		}
		else 
			throw new BusinessException("El usuario solicitado ya está registrado en el sistema", null);

	}

	@Override
	public Optional<ResponseTransfer<Usuario>> buscarUsuarioPorId(Long id) throws BusinessException{
		// TODO Auto-generated method stub
		
		Optional<Usuario> usuario = usuarioRepository.findById(id); 
		
		if(usuario.isPresent()) {
			
			try {
				ResponseTransfer<Usuario> rt = new ResponseTransfer("Busqueda de usuario existosa", usuario.get());
				
				return Optional.of(rt); 
			}
			catch(Exception e) {
				
				return Optional.empty();
				
			}
			
		}
		else {
			
			throw new BusinessException("El usuario solicitado no está registrado", null);
			
		}
				
	}

	@Override
	public Optional<Usuario> buscarUsuarioPorNombreUsuarioYPassword(String nombreUsuario, String password) {
		// TODO Auto-generated method stub

		try {
			
			return Optional.of(usuarioRepository.findByNombreUsuarioAndPassword(nombreUsuario, password));
			
		}
		catch(Exception e) {
			
			return Optional.empty();
			
		}

	}

}
