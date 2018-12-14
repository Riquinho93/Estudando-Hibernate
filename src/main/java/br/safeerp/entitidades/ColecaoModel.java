package br.safeerp.entitidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.mail.imap.protocol.UID;

@Entity
@Table(name = "tb_colecao")
public class ColecaoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @Column(name = "nome")
	private String nome;

	// @Column(name = "dt_saida")
	private String dt_saida;
	
	private boolean answer;

	// //@OneToMany(mappedBy = "colecaoId")
	// private Collection<ProdutoModel> listOs;
	//
	public ColecaoModel() {
	}

	public Long getColecaoId() {
		return id;
	}

	public void setColecaoId(long i) {
		this.id = i;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDtEntrada() {
		return dt_saida;
	}

	public void setDtEntrada(String dtEntrada) {
		this.dt_saida = dtEntrada;
	}
	@Transient
	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
}
