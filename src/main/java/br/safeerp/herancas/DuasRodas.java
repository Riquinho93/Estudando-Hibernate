package br.safeerp.herancas;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("duas_rodas")
@Table(name = "duas_rodas")
public class DuasRodas extends VeiculoHerancao{

	private int cilidradas;

	public int getCilidradas() {
		return cilidradas;
	}

	public void setCilidradas(int cilidradas) {
		this.cilidradas = cilidradas;
	}

}
