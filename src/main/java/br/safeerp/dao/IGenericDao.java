package br.safeerp.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenericDao<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

	public void salvar(T t);

	public List<T> listar();

	public T buscarById(ID id);

	public void excluir(ID id);
}
