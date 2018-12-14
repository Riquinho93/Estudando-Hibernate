package br.safeerp.entitidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity()
@Table(name = "usuario")
public class UsuarioModel {

	private Integer id;
	private String nome;
//	private Endereco endereco;
//	private Endereco enderecoComercial;
	private Date dataNascimento;
	private Integer idade;
	private EstadoCivel estadoCivil;
	private List<Endereco> enderecos = new ArrayList<Endereco>();


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer i) {
		this.id = i;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name="logradouro", column=@Column(name="rua"))
//	})
//	public Endereco getEndereco() {
//		return endereco;
//	}
//
//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}


	@Temporal(TemporalType.DATE) // pega so a data sem horario e outros
	@Column(name = "data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil")
	public EstadoCivel getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivel estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_endereco", joinColumns = @JoinColumn(name = "id_usuario"))
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name="logradouro", column=@Column(name="rua_comercial")),
//		@AttributeOverride(name="numero", column=@Column(name="num_comercial")),
//		@AttributeOverride(name="cidade", column=@Column(name="cidade_comercial"))
//	})
//	@Column(name="endereco_comercial")
//	public Endereco getEnderecoComercial() {
//		return enderecoComercial;
//	}
//
//	public void setEnderecoComercial(Endereco enderecoComercial) {
//		this.enderecoComercial = enderecoComercial;
//	}
	
	
	
}
