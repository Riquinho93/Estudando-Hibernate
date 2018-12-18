package br.safeerp.testes;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.safeerp.entitidades.Funcionario;

public class HQLUniqueResult {

	public static void main(String[] args) {

		

		Funcionario funcionario = buscarPorId(8);

		if (funcionario != null) {
			System.out.println("ID: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Salario: " + funcionario.getSalario());
			System.out.println("--------------------------------------\n");
		} else {
			System.out.println("Funcionario não encontado!!!");
		}

	}

	private static Funcionario buscarPorId(Integer id) {
		Session sessao = GeradorSessinFactory.obterConexao().openSession();

		Query consulta = sessao.createQuery("select f from Funcionario f where f.id = :id order by nome");

		consulta.setParameter("id", id);

		List<Funcionario> funcionarios = consulta.list();
		sessao.close();

		if (funcionarios.isEmpty()) {
			return null;
		} else {
			return funcionarios.get(0);
		}

	}

}
