package br.edu.unifei.ecot13.basquete;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Passe implements Serializable {
	private static final long serialVersionUID = -8081378809109805801L;
	@Id
	@GeneratedValue
	private int codigo;
	private int distancia;
	@OneToOne
	private Jogador jogador;
	@OneToOne
	private Jogador j;

}
