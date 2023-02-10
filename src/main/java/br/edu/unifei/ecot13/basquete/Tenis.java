package br.edu.unifei.ecot13.basquete;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Tenis implements Serializable {

	private static final long serialVersionUID = -635328502864458803L;
	@Id
	@GeneratedValue
	private int codigo;
	private String marca;
	private float tamanho;
	private String modelo;

}
