package br.safeerp.entitidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = -6265765426190430107L;
	
	private Integer id;
	private String modelo;
	private int ano;
	private UsuarioModel usuarioModel;
	
	public Veiculo(){}
	
	
	public Veiculo(String modelo, int ano) {
		super();
		this.modelo = modelo;
		this.ano = ano;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
//	@OneToOne(cascade = CascadeType.ALL, mappedBy="veiculo")
//	@ManyToOne
	@Transient
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}


	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}


	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
