package br.safeerp.testes;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.safeerp.entitidades.Funcionario;

public class CrudFuncionarioTeste {

	public static void main(String[] args) {

		Funcionario funcionario = new Funcionario();
	//	funcionario.setId(4);
		funcionario.setNome("Henrique");
		funcionario.setSalario(100000.00);
		funcionario.setDataAdmissao(new Date());
		
		Funcionario funcionario2 = new Funcionario();
		//	funcionario.setId(4);
			funcionario2.setNome("neymar Jr");
			funcionario2.setSalario(2000000.00);
			funcionario2.setDataAdmissao(new Date());

		// Salvar
		//salvar(funcionario);

		// Buscar
		Funcionario funcionarioBanco = buscarPorId(14);
		System.out.println("Nome: " + funcionarioBanco.getNome());

		// Atualizar
//		funcionarioBanco.setNome("Teresa");
//		funcionarioBanco.setSalario(500.00);
		//atualizar(funcionarioBanco);

		// Salvar ou Alterar
		//SalvarOuAlterar(funcionario2);

		// Excluir
		//excluir(13);
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
