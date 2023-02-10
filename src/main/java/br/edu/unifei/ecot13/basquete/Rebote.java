package br.edu.unifei.ecot13.basquete;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Rebote implements Serializable {
	private static final long serialVersionUID = 3350734029587737308L;
	@Id
	@GeneratedValue
	private int codigo;
	private float altura;
	@OneToOne
	private Jogador jogador;

}
