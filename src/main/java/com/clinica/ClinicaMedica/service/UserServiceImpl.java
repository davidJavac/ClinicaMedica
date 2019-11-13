package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.BusinessException;
import com.clinica.ClinicaMedica.model.Especialidad;
import com.clinica.ClinicaMedica.model.Medico;
import com.clinica.ClinicaMedica.model.ResponseTransfer;
import com.clinica.ClinicaMedica.model.Usuario;
import com.clinica.ClinicaMedica.repository.EspecialidadRepository;
import com.clinica.ClinicaMedica.repository.UsuarioRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Override
	public Optional<ResponseTransfer<Usuario>> registrarUsuario(Usuario usuario) throws BusinessException{
		// TODO Auto-generated method stub
			
		if(!usuarioRepository.existsByNombreUsuario(usuario.getNombreUsuario())) {
			try {
				
				if(usuario instanceof Medico) {
					Medico medico = (Medico) usuario;
					Optional<Especialidad> optional_especialidad = especialidadRepository.findById(
							medico.getEspecialidad().getId_especialidad());
					
					if(!optional_especialidad.isPresent()) throw new BusinessException("No existe una especialidad"
							+ " con el Id solicitado", null);
					Medico medico_saved = usuarioRepository.save(medico);
					medico_saved.setEspecialidad(optional_especialidad.get());
					ResponseTransfer<Usuario> rt = new ResponseTransfer("El usuario se ha registrado con éxito", medico_saved);
					return Optional.of(rt);
					
				}
				
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
