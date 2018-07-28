package beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import entities.MontagemDeComputador;
import entities.Peca;
import services.GerenciadorBD;

@ApplicationScoped
@ManagedBean(name = "computadorService")
public class ComputadorBean {
	// Gerencia pecas
	private List<MontagemDeComputador> pcs = new ArrayList<MontagemDeComputador>();
	private MontagemDeComputador pcBuscado = new MontagemDeComputador();
	private MontagemDeComputador pcEditado;
	private MontagemDeComputador pc = new MontagemDeComputador();
	private int idPc;
	private GerenciadorBD gbd;
	private static int cont = 0;
	private boolean renderPanelGridPcBuscado;
	private int qntRam;
	private int qntVideo;
	private int qntHd;
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
		gbd = new GerenciadorBD();
		pecas = gbd.list(Peca.class);
		pcs = gbd.list(MontagemDeComputador.class);
		//pecas.add(new Peca("Placa Mae Gigabyte", "placaMae", 80));
		//pecas.add(new Peca("Hyper Fury 4gb", "ram", 50));
		//pecas.add(new Peca("Intel Core I5", "cpu", 300));
		//pecas.add(new Peca("Nividia GEForce 1080", "video", 500));
		//pecas.add(new Peca("FOnte 500w", "fonte", 200));
		//pecas.add(new Peca("Hd 1 terabyte", "hd", 100));
		setRenderPanelGridPcBuscado(false);
	}

	public void editarPC() throws IOException {
		setPcEditado(getPcBuscado());
		//gbd.iniciarEdicaorPC(pcBuscado);
		setPcBuscado(new MontagemDeComputador());
		setRenderPanelGridPcBuscado(false);
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

	public void removerPC() {
		gbd.removerPC(pcBuscado);
		pcs = gbd.list(MontagemDeComputador.class);
		pcBuscado = new MontagemDeComputador();
		setRenderPanelGridPcBuscado(false);
	}

	public void salvarEdicao() throws IOException {
		gbd.editar(pcEditado);
		setPcEditado(new MontagemDeComputador());
		FacesContext.getCurrentInstance().getExternalContext().redirect("pcsMontados.xhtml");
	}

	public void salvarPc() {
		pc.setQuantRam(getQntRam());
		pc.setQuantHd(getQntHd());
		pc.setQuantVideo(getQntVideo());
		pc.setQuantCpu(1);
		pc.setQuantFonte(1);
		pc.setQuantPlaM(1);
		double precoTotal = (pc.getRam().getPreco() * pc.getQuantRam()) + (pc.getHd().getPreco() * pc.getQuantHd())
				+ (pc.getVideo().getPreco() * pc.getQuantVideo() + (pc.getCpu().getPreco()) + (pc.getFonte().getPreco())
						+ (pc.getPlacaMae().getPreco()));
		pc.setPrecoTotal(precoTotal);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("PC " + pc.getNome() + "Criado", "O preco total foi de " + pc.getPrecoTotal()));
		gbd.salvar(pc);
		pcs = gbd.list(MontagemDeComputador.class);
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

	public GerenciadorBD getGbd() {
		return gbd;
	}

	public void setGbd(GerenciadorBD gbd) {
		this.gbd = gbd;
	}

}