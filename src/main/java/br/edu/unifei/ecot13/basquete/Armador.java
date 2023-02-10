package br.edu.unifei.ecot13.basquete;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Armador extends Jogador {
	private static final long serialVersionUID = 3753280562210991521L;
	private int passesprecisos;

}
