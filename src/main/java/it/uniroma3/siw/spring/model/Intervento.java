package it.uniroma3.siw.spring.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "findAllIntervento", query = "SELECT a FROM Intervento a")
public class Intervento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private LocalDate dataPrenotazione;
	
	@Column(nullable = false)
	private int oraPrenotazione;
	
	@Column(nullable = false)
	private LocalDate dataIntervento;
	
	@OneToMany(mappedBy = "intervento")
	private Meccanico meccanico;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private TipologiaIntervento tipologiaIntervento;
	
	public Intervento(){
		
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(LocalDate dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public int getOraPrenotazione() {
		return oraPrenotazione;
	}

	public void setOraPrenotazione(int oraPrenotazione) {
		this.oraPrenotazione = oraPrenotazione;
	}

	public LocalDate getDataIntervento() {
		return dataIntervento;
	}

	public void setDataIntervento(LocalDate dataIntervento) {
		this.dataIntervento = dataIntervento;
	}
	
	public Meccanico getMeccanico() {
		return meccanico;
	}

	public void setMeccanico(Meccanico meccanico) {
		this.meccanico = meccanico;
	}

	public TipologiaIntervento getTipologiaIntervento() {
		return tipologiaIntervento;
	}

	public void setTipologiaIntervento(TipologiaIntervento tipologiaIntervento) {
		this.tipologiaIntervento = tipologiaIntervento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intervento other = (Intervento) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return false;
	}

}