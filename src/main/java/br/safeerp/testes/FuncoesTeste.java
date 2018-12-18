package br.safeerp.testes;

import java.math.BigInteger;

import org.hibernate.Query;
import org.hibernate.Session;

import br.safeerp.entitidades.Funcionario;

public class FuncoesTeste {

	public static void main(String[] args) {

		Session sessao = GeradorSessinFactory.obterConexao().openSession();

		// Contando o total de funcionario entrou na empresa no mes 12(Dezembro)
		/*
		 * Query consulta = sessao.createSQLQuery(
		 * "select count(id) from Funcionario where month(dataAdmissao) = :mes"
		 * ); consulta.setParameter("mes", 12);
		 */

		// Somando os salarios dos funcionais
		// Query consulta = sessao.createSQLQuery("select sum(salario) from"
		//		+ " Funcionario");

		// media salario dos funcionarios
		// Query consulta = sessao.createSQLQuery("select avg(salario) from"
		//  	+ " Funcionario");

		// Maior salario
		// Query consulta = sessao.createSQLQuery("select max(salario) from"
		// 		+ " Funcionario");

		// Menor salario
		// Query consulta = sessao.createSQLQuery("select min(salario) from"
		// 		+ " Funcionario");

		// Buscando o nome do funcionario que tem o maior salario
		// Query consulta = sessao.createQuery("from Funcionario where salario ="
		//  	+ " (select max(salario) from Funcionario)");

		// Quantos tipos de salarios a empresa tem
		Query consulta = sessao.createSQLQuery("select count(distinct salario) from Funcionario");

		// Funcionario func = (Funcionario) consulta.uniqueResult();
		BigInteger quantidade = (BigInteger) consulta.uniqueResult();

		System.out.println("Quantidade : " + quantidade);
		sessao.close();
	}

}
