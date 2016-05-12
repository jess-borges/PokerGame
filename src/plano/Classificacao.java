package plano;

public enum Classificacao {
	DESCONHECIDA (0), 
	HIGH_CARD(1), 
	PAR(3), 
	DOIS_PARES(4), 
	TRINCA(5), 
	STRAIGHT(6), 
	FLUSH(7), 
	FULL_HOUSE(8), 
	QUADRA(9), 
	STRAIGHT_FLUSH(10), 
	ROYAL_FLUSH(11);
	
	private int pontuacao;
	
	private Classificacao(int pontuacao){
		this.pontuacao = pontuacao;
		
	}
	
	public int getPontuacao(){
		return this.pontuacao;
	}
	
}
