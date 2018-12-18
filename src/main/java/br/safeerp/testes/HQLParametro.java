package br.safeerp.testes;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.safeerp.entitidades.Funcionario;

public class HQLParametro {

	public static void main(String[] args) {
		
		Session sessao = GeradorSessinFactory.obterConexao().openSession();
		
		Double salario = 15000.00;
		Double salario2 = 1000000.00;
		
		Query consulta = sessao.createQuery("from Funcionario where salario >= ? and"
				+ " salario < ? order by nome");
		consulta.setParameter(0, salario);
		consulta.setParameter(1, salario2);
		
		List<Funcionario> funcionarios = consulta.list();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("ID: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Salario: " + funcionario.getSalario());
			System.out.println("--------------------------------------\n");
		}
		
		sessao.close();
	}

}
