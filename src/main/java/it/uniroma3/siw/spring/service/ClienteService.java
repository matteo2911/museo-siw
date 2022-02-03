package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.repository.ClienteRepository;

@Service
public class ClienteService{

	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Transactional
	public List<Cliente> tutti() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Transactional
	public Cliente curatorePerId(Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

}
