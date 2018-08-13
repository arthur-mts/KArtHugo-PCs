package services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.MontagemDeComputador;
import util.TransacionalCdi;

@ApplicationScoped
public class GerenciadorBD {
	
	@Inject
	private EntityManager em;

	public GerenciadorBD() {
		
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@TransacionalCdi
	public void salvar(Object obj) {
		em.persist(obj);
	}
	@TransacionalCdi
	public void removerPC(MontagemDeComputador pc) {
		//MontagemDeComputador pcf = em.find(MontagemDeComputador.class, pc);
		em.remove(pc);
		//em.close();

	}

	public void fecharTransicao() {
		em.close();
	}

	/*public MontagemDeComputador iniciarEdicaorPC(MontagemDeComputador pc) {
		em.getTransaction().begin();
		return null;
	}*/

	@TransacionalCdi
	public void editar(Object o) {
		em.merge(o);
		//
	}

	public List list(Class classe) {
		Query query = em.createQuery("from " + classe.getName());
		//em.close();
		return query.getResultList();
	}

}
