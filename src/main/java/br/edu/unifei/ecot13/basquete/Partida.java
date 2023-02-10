package br.edu.unifei.ecot13.basquete;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Partida implements Serializable {
	private static final long serialVersionUID = -755390338453778400L;
	@Id
	@GeneratedValue
	private int codigo;
	@Temporal(TemporalType.DATE)
	private Date data;
	@OneToOne
	private Time time1;
	@OneToOne
	private Time time2;
	@OneToOne
	private Quadra quadra;

}
