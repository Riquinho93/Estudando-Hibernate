package br.safeerp.dao;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.safeerp.entitidades.Funcionario;
import br.safeerp.hibernateUtil.HibernateUtil;

public abstract class GenericDAOImpl<T> {
	private Class classe;
	private Session session;

	public GenericDAOImpl(Class<T> classe, Session session) {

		this.classe = classe;
		this.session = session;
	}

	public void salvar(T t) {
		session.beginTransaction();
		session.merge(t);
		session.getTransaction().commit();
		session.close();
	}

	public void excluir(T t) {
		session.beginTransaction();
		session.delete(t);
		session.getTransaction().commit();
		session.close();
	}

	public void atualizar(T t) {
		session.beginTransaction();
		session.update(t);
		session.close();
	}

	public List<T> listar() {
		// return (List<T>) session.createQuery("from classe").list();
		Query consulta = session.createQuery("from classe ");
		List<T> list = consulta.list();
		return list;
	}

	public void buscarPorId(Integer id) {

		// T t = session.createQuery("from");

		// return t;
	}

}
