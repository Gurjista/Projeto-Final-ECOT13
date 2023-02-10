package br.edu.unifei.ecot13.basquete;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Ala extends Jogador {
	private static final long serialVersionUID = -4188125209046171717L;
	private int drives;
}
