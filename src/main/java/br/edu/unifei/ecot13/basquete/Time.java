package br.edu.unifei.ecot13.basquete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public abstract class Time implements Serializable {
	private static final long serialVersionUID = 5103263846247308632L;
	@Id
	private String nome;
	private String cidade;
	@OneToOne
	private Quadra quadra;
	private int placar;
	@OneToMany
	private List<Jogador> jogadores = new ArrayList<Jogador>();

}
