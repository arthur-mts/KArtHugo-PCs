package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.Peca;
import services.PecaService;

/*@ManagedBean(name="pecasBean")
@ApplicationScoped*/
@SessionScoped
@Named
public class PecasBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6642130476738684774L;
	private List<Peca> pecas = new ArrayList<Peca>();
	private Peca peca = new Peca();
	private Peca pecaBuscada = new Peca();
	private String nomePeca;
	@Inject
	private PecaService service;
	
	public void salvarPeca() {
		service.save(peca);
		limpar();
	}
	@PostConstruct
	private void init() {
		limpar();
	}

	private void limpar() {
		peca = new Peca();
		pecas = service.getAll();
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public Peca getPecaBuscada() {
		return pecaBuscada;
	}

	public void setPecaBuscada(Peca pecaBuscada) {
		this.pecaBuscada = pecaBuscada;
	}

	public String getNomePeca() {
		return nomePeca;
	}

	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}

	public List<String> autoCompleteDescricaoPeca(String d) {
		if (service.getAll().isEmpty()) {
			return new ArrayList<String>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 4260511653374404171L;

				{
					add("Nividia");
					add("Intel");
					add("AMD");
					add("Razer");
					add("Gigabyte");
					add("HyperX");
				}

			};

		} else {
			ArrayList<String> cats = new ArrayList<String>();
			for (Peca p : service.getAll()) {
				if (!cats.contains(p.getCategoria())) {
					cats.add(p.getCategoria());
				}
			}
			return cats;
		}
	}

	public PecaService getService() {
		return service;
	}

	public void setService(PecaService service) {
		this.service = service;
	}

}