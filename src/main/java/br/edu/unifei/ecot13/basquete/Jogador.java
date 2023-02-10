package br.edu.unifei.ecot13.basquete;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public abstract class Jogador implements Serializable {

	private static final long serialVersionUID = -5594320409696056698L;
	@Id
	private String nome;
	private float altura;
	private int numero;
	private float peso;
	@ManyToOne
	protected Time time;
	@OneToOne
	private Tenis tenis;
}
