package br.safeerp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.safeerp.dao.FuncionarioDaoImpl;
import br.safeerp.dao.IGenericDao;
import br.safeerp.entitidades.Funcionario;

@Service("funcionarioService")
public class FuncionarioImpl extends GenericServiceImpl<Funcionario, Integer>{
	

	@Autowired
	FuncionarioDaoImpl funcionarioDao;
	
	
	public FuncionarioImpl(IGenericDao<Funcionario, Integer> genericDao) {
		super(genericDao);
	}

}
