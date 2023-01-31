package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artista {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String nome;

	@Column(nullable=false)
	private String cognome;

	@Column(nullable=false)
	private String dataDiNascita;

	@Column(nullable=false)
	private String luogoDiNascita;

	private String dataDiMorte;

	private String luogoDiMorte;

	@Column(length=3000)
	private String descrizione;

	@Column(nullable=false)
	private String nazionalita;
	private String citazione;

	@OneToMany(mappedBy="artista")
	private List<Opera> opere;

	public Artista() {
		this.opere=new ArrayList<>();
	}

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome=cognome;
	}

	public String getLuogoDiNascita() {
		return this.luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita=luogoDiNascita;
	}

	public String getLuogoDiMorte() {
		return this.luogoDiMorte;
	}

	public void setLuogoDiMorte(String luogoDiMorte) {
		this.luogoDiMorte=luogoDiMorte;
	}

	public String getDataDiNascita() {
		return this.dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita=dataDiNascita;
	}

	public String getDataDiMorte() {
		return this.dataDiMorte;
	}

	public void setDataDiMorte(String dataDiMorte) {
		this.dataDiMorte=dataDiMorte;
	}

	public String getNazionalita() {
		return this.nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita=nazionalita;
	}

	public List<Opera> getOpere() {
		return this.opere;
	}

	public void setOpera(Opera opera) {
		this.opere.add(opera);
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione=descrizione;
	}
	public String getCitazione() {
		return this.citazione;
	}

	public void setCitazione(String citazione) {
		this.citazione=citazione;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}	
}
