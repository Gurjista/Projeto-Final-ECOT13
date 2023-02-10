package br.edu.unifei.ecot13.basquete;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Quadra implements Serializable {

	private static final long serialVersionUID = 7218277029866351336L;
	@Id
	private String nome;
	private int capacidade;

}
