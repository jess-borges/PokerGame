package plano;

public class Jogador {
	
	private String nome;
	private boolean jogando;
	private int fichas;
	private int pote;
	private Mao mao;
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean getJogando() {
		return this.jogando;
	}
	
	public int getFichas() {
		return this.fichas;
	}
	
	public int getPote() {
		return this.pote;
	}
	
	

}
