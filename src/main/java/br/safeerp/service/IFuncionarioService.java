package br.safeerp.service;

import java.util.List;

import br.safeerp.entitidades.Funcionario;

public interface IFuncionarioService {
	
	public void salvar(Funcionario funcionario);

	public List<Funcionario> listar();

	public Funcionario buscarById(Integer idFuncionario);

	public void excluir(Integer idFuncionario);
}
