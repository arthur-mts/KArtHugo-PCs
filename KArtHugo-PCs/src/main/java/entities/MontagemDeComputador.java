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



}