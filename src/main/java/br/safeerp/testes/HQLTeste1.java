package br.safeerp.testes;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.safeerp.entitidades.Funcionario;

public class HQLTeste1 {

	public static void main(String[] args) {
		
		Session sessao = GeradorSessinFactory.obterConexao().openSession();
		
		Query consulta = sessao.createQuery("from Funcionario order by nome");
		
		List<Funcionario> funcionarios = consulta.list();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Salario: " + funcionario.getSalario());
			System.out.println("--------------------------------------\n");
		}
		sessao.close();
	}

}
