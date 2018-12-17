package br.safeerp.testes;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.safeerp.entitidades.Endereco;
import br.safeerp.entitidades.EstadoCivel;
import br.safeerp.entitidades.UsuarioModel;
import br.safeerp.entitidades.Veiculo;

public class UsuarioTeste {

	public static void main(String[] args) {

		UsuarioModel usuario = new UsuarioModel();
		
		usuario.setNome("Neji");
		usuario.setDataNascimento(new Date());
		usuario.setIdade(28); 
		usuario.setEstadoCivil(EstadoCivel.SOLTEIRO);
		 

		Endereco endereco = new Endereco();
		/*
		 * endereco.setNumero(0); endereco.setLogradouro("Aldeia");
		 * endereco.setCidade("Aldeia da Areia"); teste.setEndereco(endereco);
		 */

		Veiculo opala = new Veiculo("Opala", 1960);
		Veiculo chevete = new Veiculo("Chevete", 1900);
//		usuario.setVeiculo(opala);
//		opala.setUsuarioModel(usuario);
//		chevete.setUsuarioModel(usuario);
		usuario.getVeiculo().add(opala);
		usuario.getVeiculo().add(chevete);

		/*
		 * Endereco enderecoComercial = new Endereco();
		 * enderecoComercial.setNumero(13); enderecoComercial.setLogradouro(
		 * "Avenida brasil"); enderecoComercial.setCidade("DF");
		 * teste.setEnderecoComercial(enderecoComercial);
		 */

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		// teste.getEnderecos().add(endereco);
		session.save(usuario);
//		session.save(opala);
//		session.save(chevete);
		

		session.getTransaction().commit();

		UsuarioModel model = (UsuarioModel) session.get(UsuarioModel.class, 2);

		session.close();
		// List<Endereco> end = model.getEnderecos();
//		System.out.println("Nome= " + model.getNome());
//		System.out.println("idade= " + model.getIdade());
		// System.out.println("Endereco = " + end.get(0).getCidade());

	}

}
