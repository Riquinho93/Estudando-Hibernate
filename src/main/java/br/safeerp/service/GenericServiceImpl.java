package br.safeerp.service;

import java.io.Serializable;
import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.safeerp.dao.IGenericDao;

@Service
@Transactional
public class GenericServiceImpl<T, ID extends Serializable> implements IGenericService<T, ID> {

	private IGenericDao<T, ID> genericDao;

	public GenericServiceImpl(IGenericDao<T, ID> genericDao) {
		super();
		this.genericDao = genericDao;
	}

	@Transactional
	public T salvar(T t) {
		return genericDao.save(t);
	}

	@Transactional(readOnly = true)
	public List<T> listarTodos() {
		return (List<T>) genericDao.findAll();
	}

	@Transactional(readOnly = true)
	public T buscarById(ID id) {
		return genericDao.findOne(id);
	}

	@Transactional
	public void excluir(ID id) {
		genericDao.delete(id);

	}

	@Transactional(readOnly = true)
	public Integer count() {
		return (int) genericDao.count();
	}

}
