package br.safeerp.entitidades;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsuarioTeste {

	public static void main(String[] args) {

		UsuarioModel teste = new UsuarioModel();
//		teste.setNome("Gaara");
//		teste.setDataNascimento(new Date());
//		teste.setIdade(28);
//		teste.setEstadoCivil(EstadoCivel.SOLTEIRO);
		
		Endereco endereco = new Endereco();
//		endereco.setNumero(0);
//		endereco.setLogradouro("Aldeia");
//		endereco.setCidade("Aldeia da Areia");
	//	teste.setEndereco(endereco);
		
//		Endereco enderecoComercial = new Endereco();
//		enderecoComercial.setNumero(13);
//		enderecoComercial.setLogradouro("Avenida brasil");
//		enderecoComercial.setCidade("DF");
//		teste.setEnderecoComercial(enderecoComercial);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		teste.getEnderecos().add(endereco);
		
		//session.save(teste);
		
		session.getTransaction().commit();
		
		UsuarioModel model = (UsuarioModel) session.get(UsuarioModel.class, 2);
		
		session.close();
		List<Endereco> end = model.getEnderecos();
		System.out.println("Nome= " + model.getNome());
		System.out.println("idade= " + model.getIdade());
		System.out.println("Endereco = " + end.get(0).getCidade());
		
	}

}
