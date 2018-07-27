package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.MontagemDeComputador;

public class GerenciadorBD {
	private EntityManager em;

	public GerenciadorBD() {
		setEm(Persistence.createEntityManagerFactory("KArtHugo").createEntityManager());

	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void salvar(Object obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	public void removerPC(MontagemDeComputador pc) {
		MontagemDeComputador pcf = em.find(MontagemDeComputador.class, pc);
		em.getTransaction().begin();
		em.remove(pcf);
		em.getTransaction().commit();
		em.close();

	}

	public void fecharTransicao() {
		em.close();
	}

	public MontagemDeComputador iniciarEdicaorPC(MontagemDeComputador pc) {
		em.getTransaction().begin();
		return em.find(MontagemDeComputador.class, pc);
	}

	public void concluirEdicaoPC(MontagemDeComputador pc) {
		em.merge(pc);
		em.getTransaction().commit();
		em.close();
	}

	public List list(Class classe) {
		em.getTransaction().begin();
		Query query = em.createQuery("from " + classe.getName());
		em.getTransaction().commit();
		em.close();
		return query.getResultList();
	}

}
