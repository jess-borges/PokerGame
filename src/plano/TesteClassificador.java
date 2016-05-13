package plano;

public class TesteClassificador {
	/* Apenas para testar */
	public static void main(String [ ] args){
		ClassificadorJogo classificador;
		Classificacao classificacao;
		Mao mao;
		Carta carta;
		
		mao = new Mao();
		classificador = new ClassificadorJogo();
		/* Royal Flush */
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.Q.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 10);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.K.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.J.getValor());
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		/*Straight Flush */
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		mao = new Mao();
		
		carta = new Carta(Naipe.ESPADAS, 9);
		mao.addCarta(carta);
		carta = new Carta(Naipe.ESPADAS, CartaEspecial.Q.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.ESPADAS, 10);
		mao.addCarta(carta);
		carta = new Carta(Naipe.ESPADAS, CartaEspecial.K.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.ESPADAS, CartaEspecial.J.getValor());
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		
		/*Straight */
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		mao = new Mao();
		
		carta = new Carta(Naipe.OUROS, 9);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.Q.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 10);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.K.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.J.getValor());
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());			
		
		/*Flush*/
		
		mao = new Mao();
		
		carta = new Carta(Naipe.COPAS, 9);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.Q.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 10);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 3);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.J.getValor());
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		/*Quadra*/
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		mao = new Mao();
		
		carta = new Carta(Naipe.COPAS, 9);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 9);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 10);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 9);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 9);
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		/*Quadra*/
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		mao = new Mao();
		
		carta = new Carta(Naipe.COPAS, 9);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 9);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 10);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 9);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 9);
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		/*Straight Flush*/
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		mao = new Mao();
		
		carta = new Carta(Naipe.COPAS, 2);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 5);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 4);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 3);
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		/*Full House*/
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		mao = new Mao();
		
		carta = new Carta(Naipe.COPAS, 2);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 2);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		/* Trinca */
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		mao = new Mao();
		
		carta = new Carta(Naipe.COPAS, 2);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 5);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		/* Dois pares */
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		mao = new Mao();
		
		carta = new Carta(Naipe.COPAS, 2);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 5);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 5);
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		/* Par */
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		mao = new Mao();
		
		carta = new Carta(Naipe.COPAS, 2);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 7);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 5);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 7);
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		/* High card */
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
		
		mao = new Mao();
		
		carta = new Carta(Naipe.OUROS, 2);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 7);
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, 5);
		mao.addCarta(carta);
		carta = new Carta(Naipe.ESPADAS, CartaEspecial.A.getValor());
		mao.addCarta(carta);
		carta = new Carta(Naipe.COPAS, CartaEspecial.K.getValor());
		mao.addCarta(carta);		
		
		classificacao = classificador.classifica(mao);
		
		System.out.println(classificacao.name());
		System.out.println(mao.toString());
	}
}
