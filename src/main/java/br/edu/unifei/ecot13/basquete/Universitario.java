package br.edu.unifei.ecot13.basquete;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Universitario extends Time {
	
	private static final long serialVersionUID = 7633102169774347469L;
	private String faculdade;

}
