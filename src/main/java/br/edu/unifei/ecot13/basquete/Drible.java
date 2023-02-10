package br.edu.unifei.ecot13.basquete;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Drible implements Serializable {

	private static final long serialVersionUID = 8055622240350610318L;
	@Id
	@GeneratedValue
	private int codigo;
	private int velocidade;
	@OneToOne
	private Jogador jogador;

}
