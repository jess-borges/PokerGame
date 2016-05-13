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
			case ROYAL_FLUSH:
				buscaRoyalFlush();
			default:
				break;								
		}
	}	
	
	private void buscaPar() {
		System.out.println("par");
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
	private Carta buscaPar(Carta cartaFora){//////////////////////////////////////////////////método adicionado
		System.out.println("buscaPar");
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
		System.out.println("trinca");
		int i, numOcorrencias;
		
		/* Verifica se o par encontrado é, na verade, uma trinca */
		numOcorrencias = 0;
		for (i = 0; i < Mao.tamanhoMao; i++){
			if (this.cartaCorrente.getIdentificador() == mao.getIdentificadorCarta(i)){
				numOcorrencias++;
			}			
		}
		System.out.println("Numero ocorrencias: " + numOcorrencias);
		if (numOcorrencias >= 3){			
			this.classificadorAnterior = Classificacao.TRINCA;
			this.classificadorPosterior = Classificacao.QUADRA;
			chamaProxClassificador();
			return;
		}
		
		/* Ainda nao verificamos se existe trinca, apenas que a classificacao nao é
		 * trinca, pois se existe par e existe trinca (com cartas diferentes), entao
		 * temos um full house */
		this.classificadorAnterior = Classificacao.TRINCA;
		this.classificadorPosterior = Classificacao.FULL_HOUSE;
		chamaProxClassificador();
		
	}
	
	private Carta buscaTrinca(Carta cartaFora){//////////////////////////////////////////////////método adicionado
		System.out.println("buscaTrinca");
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
		System.out.println("fullHouse");
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
			if (this.classificadorAnterior == Classificacao.QUADRA){
				this.classificacao = Classificacao.TRINCA;
			}
		}
	}
	
	private void buscaQuadra() {
		System.out.println("quadra");
		int i, numOcorrencias;
		
		/* Verifica se a trinca encontrada é, na verade, uma quadra */
		numOcorrencias = 0;
		for (i = 0; i < Mao.tamanhoMao; i++){
			if (this.cartaCorrente.getIdentificador() == mao.getIdentificadorCarta(i)){
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
		System.out.println("doisPares");
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
		System.out.println("flush");
		int i;
		boolean flush;
		Naipe naipe;
		
		flush = true;
		naipe = this.mao.getNaipeCarta(0);
		for (i = 1; i < Mao.tamanhoMao; i++){
			if (naipe != this.mao.getNaipeCarta(i)){
				flush = false;
			}
		}
		if (flush){
			this.classificadorAnterior = Classificacao.FLUSH;
			this.classificadorPosterior = Classificacao.STRAIGHT_FLUSH;
			chamaProxClassificador();
		}
		else{
			this.classificadorAnterior = Classificacao.FLUSH;
			this.classificadorPosterior = Classificacao.STRAIGHT;
			chamaProxClassificador();
		}
	}
	
	private void buscaStraight() {
		System.out.println("straight");
		boolean straight;
		
		straight = mao.estaEmSequencia();
		if (straight){
			this.classificacao = Classificacao.STRAIGHT;
		}
		else{
			this.classificacao = Classificacao.HIGH_CARD;
			this.cartaCorrente = mao.getMaiorCarta();
		}
	}
	
	private void buscaStraightFlush() {
		System.out.println("straightFlush");
		boolean straight;
		
		straight = mao.estaEmSequencia();
		if (straight){
			this.classificadorAnterior = Classificacao.STRAIGHT_FLUSH;
			this.classificadorPosterior = Classificacao.ROYAL_FLUSH;
			chamaProxClassificador();
		}
		else{
			this.classificacao = Classificacao.FLUSH;
		}
	}
	private void buscaRoyalFlush(){//////////////////////////////////////////////////método adicionado
		System.out.println("royalFlush");
		Carta maiorCarta, menorCarta;
		
		maiorCarta = mao.getMaiorCarta();
		menorCarta = mao.getMenorCarta();
		
		if (maiorCarta.getIdentificador() == CartaEspecial.A.getValor() && menorCarta.getIdentificador() == 10){
			this.classificacao = Classificacao.ROYAL_FLUSH;
		}
		else{
			this.classificacao = Classificacao.STRAIGHT_FLUSH;
		}
	}
}