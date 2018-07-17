package beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.PrimeFacesContext;

import entities.MontagemDeComputador;
import entities.Peca;

@ApplicationScoped
@ManagedBean(name = "computadorService")
public class ComputadorBean {
	// Gerencia pecas
	private List<MontagemDeComputador> pcs = new ArrayList<MontagemDeComputador>();
	private MontagemDeComputador pcBuscado = new MontagemDeComputador();
	private MontagemDeComputador pcEditado;
	private MontagemDeComputador pc = new MontagemDeComputador();
	private int idPc;
	private static int cont = 0;
	private boolean renderPanelGridPcBuscado;
	private int qntRam;
	private int qntVideo;
	private int qntHd;
	/*private Peca placa;
	private Peca cpu;
	private Peca fonte;
	private Peca ram;
	private Peca hd;
	private Peca video;*/
	private List<Peca> pecas = new ArrayList<Peca>();

	public List<MontagemDeComputador> getPcs() {
		return pcs;
	}

	public void setPcs(List<MontagemDeComputador> pcs) {
		this.pcs = pcs;
	}

	public MontagemDeComputador getPc() {
		return pc;
	}

	public void setPc(MontagemDeComputador pc) {
		this.pc = pc;
	}

	public MontagemDeComputador getPcBuscado() {
		return pcBuscado;
	}

	public void setPcBuscado(MontagemDeComputador pcBuscado) {
		this.pcBuscado = pcBuscado;
	}

	public static int getCont() {
		return cont;
	}

	public static void setCont(int cont) {
		ComputadorBean.cont = cont;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public int getQntRam() {
		return qntRam;
	}

	public void setQntRam(int qntRam) {
		this.qntRam = qntRam;
	}

	public int getQntVideo() {
		return qntVideo;
	}

	public void setQntVideo(int qntVideo) {
		this.qntVideo = qntVideo;
	}

	public int getQntHd() {
		return qntHd;
	}

	public void setQntHd(int qntHd) {
		this.qntHd = qntHd;
	}

	public MontagemDeComputador getPcEditado() {
		return pcEditado;
	}

	public void setPcEditado(MontagemDeComputador pcEditado) {
		this.pcEditado = pcEditado;
	}

	@PostConstruct
	public void init() {
		pecas.add(new Peca("Placa Mae Gigabyte", "placaMae", 80, 1));
		pecas.add(new Peca("Hyper Fury 4gb", "ram", 50, 1));
		pecas.add(new Peca("Intel Core I5", "cpu", 300, 1));
		pecas.add(new Peca("Nividia GEForce 1080", "video", 500, 1));
		pecas.add(new Peca("FOnte 500w", "fonte", 200, 1));
		pecas.add(new Peca("Hd 1 terabyte", "hd", 100, 1));
		setRenderPanelGridPcBuscado(false);
	}

	public void editarPC() throws IOException {
		setPcEditado(getPcBuscado());
		setPcBuscado(new MontagemDeComputador());
		FacesContext.getCurrentInstance().getExternalContext().redirect("editarPc.xhtml");
	}

	public void buscarPC() {
		boolean encontrado = false;
		for (MontagemDeComputador buscaPC : pcs) {
			if (buscaPC.getId() == getIdPc()) {
				setPcBuscado(buscaPC);
				encontrado = true;
				setRenderPanelGridPcBuscado(true);
				setIdPc(0);
			}
		}
		if (!encontrado) {
			FacesContext.getCurrentInstance().addMessage("ERROR",
					new FacesMessage("PC com id " + getIdPc() + " nao foi encontrado"));
			setRenderPanelGridPcBuscado(false);
		}
	}
	
	public void salvarEdicao() {
		
	}

	public void salvarPc() {
		pc.getRam().setQuant(getQntRam());
		pc.getHd().setQuant(getQntHd());
		pc.getVideo().setQuant(getQntVideo());
		double precoTotal = (pc.getRam().getPreco() * pc.getRam().getQuant())
				+ (pc.getHd().getPreco() * pc.getHd().getQuant())
				+ (pc.getVideo().getPreco() * pc.getVideo().getQuant()) + (pc.getCpu().getPreco())
				+ (pc.getFonte().getPreco()) + (pc.getPlacaMae().getPreco());
		pc.setPrecoTotal(precoTotal);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("PC " + pc.getNome() + "Criado", "O preco total foi de " + pc.getPrecoTotal()));
		pcs.add(pc);
		pc = new MontagemDeComputador();
		setQntHd(0);
		setQntRam(0);
		setQntVideo(0);
		
	}
	
	

	public int getIdPc() {
		return idPc;
	}

	public void setIdPc(int idPc) {
		this.idPc = idPc;
	}

	public boolean isRenderPanelGridPcBuscado() {
		return renderPanelGridPcBuscado;
	}

	public void setRenderPanelGridPcBuscado(boolean renderPanelGridPcBuscado) {
		this.renderPanelGridPcBuscado = renderPanelGridPcBuscado;
	}

}