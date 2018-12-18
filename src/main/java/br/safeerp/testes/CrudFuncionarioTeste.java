package br.safeerp.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.safeerp.entitidades.Funcionario;

public class CrudFuncionarioTeste {

	public static void main(String[] args) {

		Funcionario funcionario = new Funcionario();
	//	funcionario.setId(4);
		funcionario.setNome("João de Deus");
		funcionario.setSalario(70.00);

		// Salvar
		//salvar(funcionario);

		// Buscar
//		Funcionario funcionarioBanco = buscarPorId(4);
//		System.out.println("Nome: " + funcionarioBanco.getNome());

		// Atualizar
//		funcionarioBanco.setNome("Teresa");
//		funcionarioBanco.setSalario(500.00);
		//atualizar(funcionarioBanco);

		// Salvar ou Alterar
		SalvarOuAlterar(funcionario);

		// Excluir
		//excluir(3);
	}

	public static void salvar(Funcionario funcionario) {

		Session session = obterConexao().openSession();
		session.beginTransaction();

		session.save(funcionario);

		session.getTransaction().commit();

		session.close();

	}

	public static Funcionario buscarPorId(Integer id) {

		Session session = obterConexao().openSession();

		Funcionario funcionario = (Funcionario) session.get(Funcionario.class, id);

		session.close();

		return funcionario;
	}

	public static void atualizar(Funcionario funcionario) {

		Session session = obterConexao().openSession();
		session.beginTransaction();

		session.update(funcionario);

		session.getTransaction().commit();

		session.close();
	}

	public static void SalvarOuAlterar(Funcionario funcionario) {
		Session session = obterConexao().openSession();
		session.beginTransaction();

		session.saveOrUpdate(funcionario);

		session.getTransaction().commit();
		session.close();
	}

	public static void excluir(Integer idFuncionario) {
		Session session = obterConexao().openSession();
		session.beginTransaction();

		Funcionario funcionarioRemover = buscarPorId(idFuncionario);
		session.delete(funcionarioRemover);

		session.getTransaction().commit();
		session.close();
	}

	private static SessionFactory obterConexao() {
		Configuration configuration = new Configuration().configure();

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;
	}

}
