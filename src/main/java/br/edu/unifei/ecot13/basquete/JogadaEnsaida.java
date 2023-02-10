package br.edu.unifei.ecot13.basquete;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class JogadaEnsaida implements Serializable {

	private static final long serialVersionUID = -2043177599531744842L;
	@Id
	private String nome;

}
