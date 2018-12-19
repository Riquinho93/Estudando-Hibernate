package br.safeerp.dao;

import java.util.List;

import br.safeerp.entitidades.Funcionario;

public interface IFuncionarioDao {

	public void salvar(Funcionario funcionario);

	public List<Funcionario> listar();

	public Funcionario buscarById(Integer idFuncionario);

	public void excluir(Integer idFuncionario);
}
