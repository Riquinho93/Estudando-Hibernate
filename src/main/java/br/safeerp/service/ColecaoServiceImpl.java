package br.safeerp.service;

import java.util.List;

import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.safeerp.dao.ColecaoImplDao;
import br.safeerp.dao.IColecaoDao;
import br.safeerp.entitidades.ColecaoModel;


public class ColecaoServiceImpl implements IColecaoService {
	
//	@SpringBean("colecaoService")
	private IColecaoDao daoColecao;
	
	@Autowired
	public void setDaoColecao(ColecaoImplDao daoColecao) {
		this.daoColecao = daoColecao;
	}

	
//	 public ColecaoServiceImpl() {}

	@Override
	public void save(ColecaoModel colecao) {
		daoColecao.save(colecao);
	}

	@Override
	public List<ColecaoModel> listar() {
		return daoColecao.listar();
	}

	@Override
	public ColecaoModel buscarById(Long idColecao) {
		return daoColecao.buscarById(idColecao);
	}

	@Override
	public void delete(Long idColecao) {
		daoColecao.delete(idColecao);
	}


	public ColecaoServiceImpl() {
		super();
	}

//	@Override
//	public ColecaoModel updateColecaoModel(ColecaoModel colecao) {
//		return daoColecao.updateColecaoModel(colecao);
//	}
	
	


}
