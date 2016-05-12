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
			default:
				break;								
		}
	}	
	
	private void buscaPar() {
		int i, j;
		Carta cartaNula, cartaCorrente;
		
		cartaNula = new Carta(Naipe.NULO, 0);
		cartaCorrente = buscaPar(cartaNula);
		
		if (cartaCorrente != null){
			this.classificadorAnterior = Classificacao.PAR;
			this.classificadorPosterior = Classificacao.TRINCA;
			this.cartaCorrente = cartaCorrente;
			chamaProxClassificador();
		}
		else{
			this.classificadorAnterior = Classificacao.PAR;
			this.classificadorPosterior = Classificacao.FLUSH;
			this.cartaCorrente = cartaCorrente;
			chamaProxClassificador();
		}
	}
	
	/* 
	 * @param cartaFora
	 * @return retorna carta que está em um par da mao e que é diferente de cartaFora 
	 */
	private Carta buscaPar(Carta cartaFora){
		int i, j;
		Carta carta;
		
		for (i = 0; i < Mao.tamanhoMao; i++){
			carta = mao.getCarta(i);
			if (carta.getIdentificador() != cartaFora.getIdentificador()){
				for (j = i+1; j < Mao.tamanhoMao; j++){
					if (carta.getIdentificador() == mao.getIdentificadorCarta(j)){						
						return carta;
					}
				}
			}
		}
		
		return null;		
	}
	
	private void buscaTrinca() {
		int i, numOcorrencias;
		
		/* Verifica se o par encontrado é, na verade, uma trinca */
		numOcorrencias = 0;
		for (i = 0; i < Mao.tamanhoMao; i++){
			if (this.cartaCorrente.getIdentificador() == mao.getIdentificadorCarta(i)){
				numOcorrencias++;
			}			
		}
		
		if (numOcorrencias == 3){
			this.classificadorAnterior = Classificacao.TRINCA;
			this.classificadorPosterior = Classificacao.QUADRA;
			return;
		}
		
		/* Ainda nao verificamos se existe trinca, apenas que a classificacao nao é
		 * trinca, pois se existe par e existe trinca (com cartas diferentes), entao
		 * temos um full house */
		this.classificadorAnterior = Classificacao.TRINCA;
		this.classificadorPosterior = Classificacao.FULL_HOUSE;
		chamaProxClassificador();
		
	}
	
	private Carta buscaTrinca(Carta cartaFora){
		int i, j, numOcorrencias;
		Carta carta;
		numOcorrencias = 0;
		
		for (i = 0; i < Mao.tamanhoMao; i++){
			carta = mao.getCarta(i);
			numOcorrencias = 0;
			
			if (carta.getIdentificador() != cartaFora.getIdentificador()){
				for (j = i+1; j < Mao.tamanhoMao; j++){
					if (carta.getIdentificador() == mao.getIdentificadorCarta(j)){						
						numOcorrencias++;
						if (numOcorrencias == 2){
							return carta;
						}
					}
				}
			}
		}
		
		return null;		
	}
	
	private void buscaFullHouse() {
		Carta carta, cartaAnterior;
		
		carta = null;
		cartaAnterior = this.cartaCorrente;
		
		/* Se veio da verificacao de quadra, é porque existe uma trinca
		 * e uma das cartas da trinca está salva em cartaCorrente */
		if (this.classificadorAnterior == Classificacao.QUADRA){
			carta = buscaPar(cartaAnterior); /* busca par que não tenha cartaAnterior */			
		}
		
		/* Se veio da verificacao de trinca, é porque existe um par
		 * e uma das cartas do par está salva em cartaCorrente */
		if (this.classificadorAnterior == Classificacao.TRINCA){
			carta = buscaTrinca(cartaAnterior); /* busca trinca que não tenha cartaAnterior */
		}
		
		
		if (carta != null){
			this.classificacao = Classificacao.FULL_HOUSE;
		}
		else {
			if (this.classificadorAnterior == Classificacao.TRINCA){
				this.classificadorAnterior = Classificacao.FULL_HOUSE;
				this.classificadorPosterior = Classificacao.DOIS_PARES;
				chamaProxClassificador();
			}
		}
	}
	
	private void buscaQuadra() {
		int i, numOcorrencias;
		
		/* Verifica se a trinca encontrada é, na verade, uma quadra */
		numOcorrencias = 0;
		for (i = 0; i < Mao.tamanhoMao; i++){
			if (this.cartaCorrente.getIdentificador() == mao.getIdentificadorCarta(j)){
				numOcorrencias++;
			}			
		}
		
		if (numOcorrencias == 4){
			this.classificacao = Classificacao.QUADRA;
		}
		else{
			/* Como a trinca encontrada nao é quadra, podemos ter um Full House ou uma única trinca */
			this.classificadorAnterior = Classificacao.QUADRA;
			this.classificadorPosterior = Classificacao.FULL_HOUSE;
			chamaProxClassificador();
		}
	}
	
	private void buscaDoisPares() {
		Carta carta, cartaAnterior;		
		
		cartaAnterior = this.cartaCorrente;
		carta = buscaPar(cartaAnterior);
		
		if (carta != null){
			this.classificacao = Classificacao.DOIS_PARES;
		}
		else{
			this.classificacao = Classificacao.PAR;
		}
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