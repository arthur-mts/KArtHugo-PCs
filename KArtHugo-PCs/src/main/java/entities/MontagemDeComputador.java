package entities;

public class MontagemDeComputador {
	private Peca cpu;
	private Peca placaMae;
	private Peca ram;
	private Peca hd;
	private Peca video;
	private Peca fonte;
	private double precoTotal;
	private String nome;
	private int id;
	private int quantCpu;
	private int quantPlaM;
	private int quantRam;
	private int quantHd;
	private int quantVideo;
	private int quantFonte;
	private static int cont = 0;

	public Peca getCpu() {
		return cpu;
	}

	public void setCpu(Peca cpu) {
		this.cpu = cpu;
	}

	
	public Peca getRam() {
		return ram;
	}

	public void setRam(Peca ram) {
		this.ram = ram;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Peca getHd() {
		return hd;
	}

	public void setHd(Peca hd) {
		this.hd = hd;
	}

	public Peca getVideo() {
		return video;
	}

	public void setVideo(Peca video) {
		this.video = video;
	}

	public Peca getFonte() {
		return fonte;
	}

	public void setFonte(Peca fonte) {
		this.fonte = fonte;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getCont() {
		return cont;
	}

	public static void setCont(int cont) {
		MontagemDeComputador.cont = cont;
	}

	public MontagemDeComputador() {
		super();
		setId(cont++);
	}

	public Peca getPlacaMae() {
		return placaMae;
	}

	public void setPlacaMae(Peca placaMae) {
		this.placaMae = placaMae;
	}

	public int getQuantCpu() {
		return quantCpu;
	}

	public void setQuantCpu(int quantCpu) {
		this.quantCpu = quantCpu;
	}

	public int getQuantPlaM() {
		return quantPlaM;
	}

	public void setQuantPlaM(int quantPlaM) {
		this.quantPlaM = quantPlaM;
	}

	public int getQuantRam() {
		return quantRam;
	}

	public void setQuantRam(int quantRam) {
		this.quantRam = quantRam;
	}

	public int getQuantHd() {
		return quantHd;
	}

	public void setQuantHd(int quantHd) {
		this.quantHd = quantHd;
	}

	public int getQuantVideo() {
		return quantVideo;
	}

	public void setQuantVideo(int quantVideo) {
		this.quantVideo = quantVideo;
	}

	public int getQuantFonte() {
		return quantFonte;
	}

	public void setQuantFonte(int quantFonte) {
		this.quantFonte = quantFonte;
	}
}