package br.safeerp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.safeerp.entitidades.Funcionario;

@Repository("funcionarioDao")
public interface FuncionarioDaoImpl extends IGenericDao<Funcionario, Integer> {

	

}
