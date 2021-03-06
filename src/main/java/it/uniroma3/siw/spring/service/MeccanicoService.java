package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Meccanico;
import it.uniroma3.siw.spring.repository.MeccanicoRepository;



@Service
public class MeccanicoService {
	
	
	@Autowired 
	private CredentialsService credentialsService;
	
	@Autowired
	private MeccanicoRepository MeccanicoRepository; 
	
	@Transactional
	public Meccanico inserisci(Meccanico meccanico) {
		return MeccanicoRepository.save(meccanico);
	}
	
	@Transactional
	public List<Meccanico> meccaniciPerNomeAndCognome(String nome, String cognome) {
		return MeccanicoRepository.findByNomeAndCognome(nome, cognome);
	}

	@Transactional
	public List<Meccanico> tutti() {
		return (List<Meccanico>) MeccanicoRepository.findAll();
	}

	@Transactional
	public Meccanico meccanicoPerId(Long id) {
		Optional<Meccanico> optional = MeccanicoRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Meccanico meccanico) {
		List<Meccanico> meccanici = this.MeccanicoRepository.findByNomeAndCognome(meccanico.getNome(), meccanico.getCognome());
		if (meccanici.size() > 0)
			return true;
		else 
			return false;
	}

	public CredentialsService getCredentialsService() {
		return credentialsService;
	}

	public void setCredentialsService(CredentialsService credentialsService) {
		this.credentialsService = credentialsService;
	}
}
