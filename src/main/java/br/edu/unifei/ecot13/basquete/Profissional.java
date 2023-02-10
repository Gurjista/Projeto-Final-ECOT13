package br.edu.unifei.ecot13.basquete;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Profissional extends Time {

	private static final long serialVersionUID = 3697709684756191690L;
	private String liga;

}
