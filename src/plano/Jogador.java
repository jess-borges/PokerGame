package plano;

public class Jogador {
	
	private String nome;
	private boolean jogando;
	private int pilha;
	private int pote;
	private Mao mao;
	
	public Jogador(String nome, int pilha) {
		this.nome = nome;
		this.pilha = pilha;
		this.mao = new Mao();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean getJogando() {
		return this.jogando;
	}
	
	public int getPilha() {
		return this.pilha;
	}
	
	public int getPote() {
		return this.pote;
	}
	
	public Mao getMao() {
		return this.mao;
	}
	
	public void setJogando(boolean jogando) {
		this.jogando = jogando;
	}
	
	public void ganhador(int premio) { ////////////////////////////////////////////////////setPilha
		this.pilha += premio;
	}
	
	public void setPote(int pote) {
		this.pote = pote;
	}
	
	public void recebeCarta(Carta carta) { ///////////////////////////////////////////////////////
		this.mao.addCarta(carta);
	}
	
	public Carta retiraCarta(int idCarta) { //////////////////////////////////////////////////////
		Carta carta = this.mao.retiraCarta(idCarta);
		return carta;
	}
	
	public void aposta(int aposta) { ////////////////////////////////////////////////////////////
		this.pilha -= aposta;
		this.pote += aposta;
	}
}
