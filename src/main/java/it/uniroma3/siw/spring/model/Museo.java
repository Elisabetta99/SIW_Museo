package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Museo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private String citta;

	@Getter
	@Setter
	private String indirizzo;

	@OneToMany(mappedBy="museo")
	private List<Collezione> collezioni;

	public Museo() {
		this.collezioni=new ArrayList<>();
	}

}
