package br.safeerp.testes;

import org.hibernate.Session;

import br.safeerp.entitidades.Funcionario;
import br.safeerp.entitidades.Projeto;
import br.safeerp.hibernateUtil.HibernateUtil;

public class TesteHibernateUtil {

	public static void main(String[] args) {

		Session session = HibernateUtil.getFactory().openSession();

		session.beginTransaction();

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Pedro");
		funcionario.setSalario(75000.00);

		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Mariaana");
		funcionario2.setSalario(1200.00);

		Projeto projeto1 = new Projeto();
		Projeto projeto2 = new Projeto();

		projeto1.setNome("Projeto 1");
		projeto2.setNome("Projeto 2");

		funcionario.getProjetos().add(projeto2);

		funcionario2.getProjetos().add(projeto1);
		funcionario2.getProjetos().add(projeto2);

		session.save(funcionario);
		session.save(funcionario2);
		session.save(projeto2);
		session.save(projeto1);

		session.getTransaction().commit();
		session.close();
	}

}
