package br.edu.unifei.ecot13.basquete;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Pivo extends Jogador {

	private static final long serialVersionUID = -7827365613294837171L;
	private int defesasAmplas;

}
