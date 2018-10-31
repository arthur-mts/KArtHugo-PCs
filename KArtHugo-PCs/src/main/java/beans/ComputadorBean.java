package beans;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import entities.MontagemDeComputador;
import entities.Peca;
import services.PcService;
import services.PecaService;

@SessionScoped
@Named
public class ComputadorBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Gerencia pecas
	private List<MontagemDeComputador> pcs = new ArrayList<MontagemDeComputador>();
	private MontagemDeComputador pcBuscado = new MontagemDeComputador();
	private MontagemDeComputador pcEditado = new MontagemDeComputador();
	private MontagemDeComputador pc = new MontagemDeComputador();
	private int idPc;
	private static int cont = 0;
	private boolean renderPanelGridPcBuscado;
	private int qntRam;
	private int qntVideo;
	private int qntHd;
	private List<Peca> pecas = new ArrayList<Peca>();
	private List<Peca> placas = new ArrayList<Peca>();
	private List<Peca> cpus = new ArrayList<Peca>();
	private List<Peca> rams = new ArrayList<Peca>();
	private List<Peca> hds = new ArrayList<Peca>();
	private List<Peca> fontes = new ArrayList<Peca>();
	private List<Peca> videos = new ArrayList<Peca>();
	private Long idPlacaMaeEdit;
	private Long idRamEdit;
	private Long idVideoEdit;
	private Long idFonteEdit;
	private Long idCpuEdit;
	private Long idHdEdit;

	public Long getIdPlacaMaeEdit() {
		return idPlacaMaeEdit;
	}

	public void setIdPlacaMaeEdit(Long idPlacaMaeEdit) {
		this.idPlacaMaeEdit = idPlacaMaeEdit;
	}

	public Long getIdRamEdit() {
		return idRamEdit;
	}

	public void setIdRamEdit(Long idRamEdit) {
		this.idRamEdit = idRamEdit;
	}

	public Long getIdVideoEdit() {
		return idVideoEdit;
	}

	public void setIdVideoEdit(Long idVideoEdit) {
		this.idVideoEdit = idVideoEdit;
	}

	public Long getIdFonteEdit() {
		return idFonteEdit;
	}

	public void setIdFonteEdit(Long idFonteEdit) {
		this.idFonteEdit = idFonteEdit;
	}

	public Long getIdCpuEdit() {
		return idCpuEdit;
	}

	public void setIdCpuEdit(Long idCpuEdit) {
		this.idCpuEdit = idCpuEdit;
	}

	public Long getIdHdEdit() {
		return idHdEdit;
	}

	public void setIdHdEdit(Long idHdEdit) {
		this.idHdEdit = idHdEdit;
	}

	@Inject
	private PecaService pecaService;

	@Inject
	private PcService pcService;

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
		pecas = pecaService.getAll();
		pcs = pcService.getAll();
		for (Peca p : pecas) {
			if (p.getCategoria().equals("cpu")) {
				cpus.add(p);

			} else if (p.getCategoria().equals("ram")) {
				rams.add(p);
			} else if (p.getCategoria().equals("video")) {
				videos.add(p);
			} else if (p.getCategoria().equals("fonte")) {
				fontes.add(p);
			} else if (p.getCategoria().equals("placa")) {
				placas.add(p);
			} else if (p.getCategoria().equals("hd")) {
				hds.add(p);
			}
		}

		setRenderPanelGridPcBuscado(false);
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public List<Peca> getPlacas() {
		return placas;
	}

	public void setPlacas(List<Peca> placas) {
		this.placas = placas;
	}

	public List<Peca> getCpus() {
		return cpus;
	}

	public void setCpus(List<Peca> cpus) {
		this.cpus = cpus;
	}

	public List<Peca> getRams() {
		return rams;
	}

	public void setRams(List<Peca> rams) {
		this.rams = rams;
	}

	public List<Peca> getHds() {
		return hds;
	}

	public void setHds(List<Peca> hds) {
		this.hds = hds;
	}

	public List<Peca> getFontes() {
		return fontes;
	}

	public void setFontes(List<Peca> fontes) {
		this.fontes = fontes;
	}

	public List<Peca> getVideos() {
		return videos;
	}

	public void setVideos(List<Peca> videos) {
		this.videos = videos;
	}

	public void editarPC() throws IOException {
		// gbd.iniciarEdicaorPC(pcBuscado);
		setPcEditado(pcBuscado);
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
			}
		}
		if (!encontrado) {
			FacesContext.getCurrentInstance().addMessage("ERROR",
					new FacesMessage("PC com id " + getIdPc() + " nao foi encontrado!"));
			setRenderPanelGridPcBuscado(false);
		}
	}

	public void removerPC() {
		// gbd.removerPC(pcBuscado);
		pcService.remove(pcBuscado);
		// pcs = gbd.list(MontagemDeComputador.class);
		pcs = pcService.getAll();
		pcBuscado = new MontagemDeComputador();
		setRenderPanelGridPcBuscado(false);
	}

	public void salvarEdicao() throws IOException {
		pcEditado.setCpu(pecaService.getByID(pcEditado.getCpu().getId()));
		pcEditado.setFonte(pecaService.getByID(pcEditado.getFonte().getId()));
		pcEditado.setHd(pecaService.getByID(pcEditado.getHd().getId()));
		pcEditado.setVideo(pecaService.getByID(pcEditado.getVideo().getId()));
		pcEditado.setRam(pecaService.getByID(pcEditado.getRam().getId()));
		pcService.update(pcEditado);
		pcs = pcService.getAll();
		setPcEditado(new MontagemDeComputador());
		FacesContext.getCurrentInstance().getExternalContext().redirect("pcsMontados.xhtml");
	}

	public void salvarPc() {
		pc.setPlacaMae(pecaService.getByID(pc.getPlacaMae().getId()));
		pc.setCpu(pecaService.getByID(pc.getPlacaMae().getId()));
		pc.setRam(pecaService.getByID(pc.getRam().getId()));
		pc.setVideo(pecaService.getByID(pc.getVideo().getId()));
		pc.setFonte(pecaService.getByID(pc.getFonte().getId()));
		pc.setHd(pecaService.getByID(pc.getHd().getId()));
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
		// gbd.salvar(pc);
		// pcs = gbd.list(MontagemDeComputador.class);
		pcService.save(pc);
		pcs = pcService.getAll();
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
	public PecaService getPecaService() {
		return pecaService;
	}

	public void setPecaService(PecaService pecaService) {
		this.pecaService = pecaService;
	}

	public PcService getPcService() {
		return pcService;
	}

	public void setPcService(PcService pcService) {
		this.pcService = pcService;
	}

}