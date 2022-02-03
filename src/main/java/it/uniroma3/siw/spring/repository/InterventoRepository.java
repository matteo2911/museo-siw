package it.uniroma3.siw.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Intervento;

public interface InterventoRepository extends CrudRepository<Intervento, Long> {

	public List<Intervento> findBydataPrenotazione(LocalDate dataPrenotazione);

	public List<Intervento> findBydataPrenotazioneAndOraPrenotazione(LocalDate dataPrenotazione, int oraPrenotazione);
}