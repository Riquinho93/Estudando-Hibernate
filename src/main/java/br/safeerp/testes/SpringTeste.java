package br.safeerp.testes;

import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import br.safeerp.service.FuncionarioImpl;

public class SpringTeste {

	@SpringBean("funcionarioService")
	FuncionarioImpl funcionario;
	
	public SpringTeste(){
		
	}
	
	public static void main(String[] args) {
		
	}

}


