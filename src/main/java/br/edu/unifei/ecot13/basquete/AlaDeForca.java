package br.edu.unifei.ecot13.basquete;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class AlaDeForca extends Jogador {
	private static final long serialVersionUID = -3525522294305991262L;
	private int enterradas;

}
