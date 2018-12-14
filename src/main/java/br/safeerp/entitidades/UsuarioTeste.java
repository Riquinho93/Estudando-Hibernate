package br.safeerp.entitidades;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsuarioTeste {

	public static void main(String[] args) {

		TesteModel teste = new TesteModel();
		teste.setNome("Teste passou 23");
		teste.setDataNascimento(new Date());
		teste.setIdade(22);
		teste.setEstadoCivil(EstadoCivel.SOLTEIRO);
		
//		Endereco endereco = new Endereco();
//		endereco.setNumero(0);
//		endereco.setLogradouro("Bairro do ze mane23");
//		endereco.setCidade("Cidade do mane23");
//		teste.setEndereco(endereco);
		
//		Endereco enderecoComercial = new Endereco();
//		enderecoComercial.setNumero(13);
//		enderecoComercial.setLogradouro("Avenida brasil");
//		enderecoComercial.setCidade("DF");
//		teste.setEnderecoComercial(enderecoComercial);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(teste);
		session.getTransaction().commit();
		
		TesteModel model = (TesteModel) session.get(TesteModel.class, 1);
		System.out.println("Nome= " + model.getNome());
		System.out.println("idade= " + model.getIdade());
		session.close();
	}

}
