package br.edu.unifei.ecot13.basquete;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class AlaArmador extends Jogador {
	private static final long serialVersionUID = 1900568155056524629L;
	private int arremessosde3;

}
