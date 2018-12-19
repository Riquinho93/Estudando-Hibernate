package br.safeerp.service;

import java.io.Serializable;
import java.util.List;

public interface IGenericService <T, ID extends Serializable> {
	
	public T salvar(T t);

	public List<T> listarTodos();
	
	public Integer count();

	public T buscarById(ID id);

	public void excluir(ID id);
}
