package br.safeerp.herancas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("quatro_rodas")
@Table(name = "quatro_rodas")
public class QuadroRodas extends VeiculoHerancao {

	private int qtdportas;

	public int getQtdportas() {
		return qtdportas;
	}

	public void setQtdportas(int qtdportas) {
		this.qtdportas = qtdportas;
	}

}
