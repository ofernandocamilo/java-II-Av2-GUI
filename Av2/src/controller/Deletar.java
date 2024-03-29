package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Contato;

public class Deletar {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		Contato contato = manager.find(Contato.class, 5L);
		
		manager.getTransaction().begin();
		manager.remove(contato);
		manager.getTransaction().commit();
		
		System.out.println("Contato com o ID 5 exclu�da!");
		
	}
	
	public static Contato deletarContato(Contato contato) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		contato = manager.find(Contato.class, contato.getId());
		
		manager.getTransaction().begin();
		manager.remove(contato);
		manager.getTransaction().commit();
		manager.close();
		return contato;
	}

}
