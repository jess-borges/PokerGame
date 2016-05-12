package plano;

public class ClassificadorJogo {
	
	private Classificacao classificadorAnterior;
	private Classificacao classificadorPosterior;
	private Classificacao classificacao;
	private Carta cartaCorrente;
	private Mao mao;
	
	public ClassificadorJogo(){
		iniciaValores();
		this.mao = null;
	}
	
	private void iniciaValores(){
		this.classificadorAnterior = Classificacao.DESCONHECIDA;
		this.classificadorPosterior = Classificacao.PAR;
		this.classificacao = Classificacao.DESCONHECIDA;
		this.cartaCorrente = null;
	}
	public Classificacao classifica(Mao mao) {
		iniciaValores();
		this.mao = mao;
		chamaProxClassificador();
		return this.classificacao;
	}
	
	private void chamaProxClassificador() {
		switch(this.classificadorPosterior){
			case PAR:
				buscaPar();
				break;
			case TRINCA: 
				buscaTrinca();
				break;
			case FULL_HOUSE:
				buscaFullHouse();
				break;
			case QUADRA:
				buscaQuadra();
				break;
			case DOIS_PARES: 
				buscaDoisPares();
				break;
			case FLUSH:
				buscaFlush();
				break;
			case STRAIGHT:
				buscaStraight();
				break;
			case STRAIGHT_FLUSH:
				buscaStraightFlush();
				break;								
		}
	}
	
	private void buscaPar() {
		int i, j;
		for (i = 0; i < Mao.tamanhoMao; i++){
			this.cartaCorrente = mao.getCarta(i);
			for (j = i+1; j < Mao.tamanhoMao; j++){
				if (this.cartaCorrente.getIdentificador() == mao.getIdentificadorCarta(j)){
					this.classificadorAnterior = Classificacao.PAR;
					this.classificadorPosterior = Classificacao.TRINCA;
					chamaProxClassificador();
					return;
				}
			}
		}
		this.classificadorAnterior = Classificacao.PAR;
		this.classificadorPosterior = Classificacao.FLUSH;
		chamaProxClassificador();
	}
	
	private void buscaTrinca() {
		int i, j, k;
		
		/* Verifica se o par encontrado é, na verade, uma trinca */
		i = 0;
		for (j = 0; j < Mao.tamanhoMao; j ++){
			if (this.cartaCorrente.getIdentificador() == mao.getIdentificadorCarta(j)){
				j++;
			}			
		}
		if (j == 3){
			this.classificadorAnterior = Classificacao.TRINCA;
			this.classificadorPosterior = Classificacao.QUADRA;
			chamaProxClassificador();
			return;
		}
		
		/* Como o par encontrado nao é trinca, se se encontra uma trinca, tem-se um Full House */
		this.classificadorAnterior = Classificacao.TRINCA;
		this.classificadorPosterior = Classificador.FULL_HOUSE;
		chamaProxClassificador();
	}
	
	private void buscaFullHouse() {
		//
	}
	
	private void buscaQuadra() {
		//
	}
	
	private void buscaDoisPares() {
		//
	}
	
	private void buscaFlush() {
		//
	}
	
	private void buscaStraight() {
		//
	}
	
	private void buscaStraightFlush() {
		//
	}
}