package br.safeerp.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.safeerp.herancas.DuasRodas;
import br.safeerp.herancas.QuadroRodas;

public class VeiculoHerancaoteste {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		QuadroRodas quadroRodas = new QuadroRodas();
		DuasRodas duasRodas = new DuasRodas();

		quadroRodas.setModelo("Fusion");
		quadroRodas.setMarca("Ford");
		quadroRodas.setAno(2018);
		quadroRodas.setQtdportas(4);

		duasRodas.setModelo("Titan");
		duasRodas.setMarca("Honda");
		duasRodas.setAno(2011);
		duasRodas.setCilidradas(150);

		session.save(quadroRodas);
		session.save(duasRodas);

		session.getTransaction().commit();
		session.close();
	}

}
