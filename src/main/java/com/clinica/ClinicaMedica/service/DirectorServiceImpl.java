package com.clinica.ClinicaMedica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.ClinicaMedica.model.Director;
import com.clinica.ClinicaMedica.repository.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	DirectorRepository directorRepository;

	UserReportable userReportable;
	
	public DirectorRepository getDirectorRepository() {
		return directorRepository;
	}

	public UserReportable getUserReportable() {
		return userReportable;
	}

	public void setDirectorRepository(DirectorRepository directorRepository) {
		this.directorRepository = directorRepository;
	}

	public void setUserReportable(UserReportable userReportable) {
		this.userReportable = userReportable;
	}

	@Override
	public Optional<Director> buscarDirector(Long id) {
		// TODO Auto-generated method stub
		try {
			Optional<Director> optional = directorRepository.findById(id); 
			return Optional.of(optional.get()) ;
			
		}
		catch(Exception e) {
			
			return Optional.empty();
		}
	}

}
