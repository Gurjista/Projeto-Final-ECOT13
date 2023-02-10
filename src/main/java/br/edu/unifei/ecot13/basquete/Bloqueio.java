package br.edu.unifei.ecot13.basquete;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Bloqueio implements Serializable {

	private static final long serialVersionUID = 8913506206737616278L;
	@Id
	@GeneratedValue
	private int codigo;
	private int forca;
	@OneToOne
	private Jogador jogador;

}
