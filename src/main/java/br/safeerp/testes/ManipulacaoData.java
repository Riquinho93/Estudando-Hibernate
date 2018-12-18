package br.safeerp.testes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.safeerp.entitidades.Funcionario;

public class ManipulacaoData {

	public static void main(String[] args) {
		
		Session sessao = GeradorSessinFactory.obterConexao().openSession();
		
		Query consulta = sessao.createQuery("select f from Funcionario f where date(f.dataAdmissao) = current_date order by nome");
		
		List<Funcionario> funcionarios = consulta.list();
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println("ID: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Salario: " + funcionario.getSalario());
			System.out.println("Data de Admissão: " + formatarData(funcionario.getDataAdmissao()));
			System.out.println("--------------------------------------\n");
		}
		sessao.close();
	}
	
	public static String formatarData(Date data){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}

}
