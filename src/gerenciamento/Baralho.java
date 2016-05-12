package gerenciamento;

import plano.Carta;
import plano.Naipe;

public class Baralho {
	
	boolean[] cartas = new boolean[52];
	
	public Baralho() {
		int i;
		for(i=0; i<52; i++) {
			cartas[i] = false;
		}
	}
	
	public Carta pedeCarta() {
		int n;
		n = this.escolheCarta();
		cartas[n] = true;
		
		Carta carta;
		carta = this.getObjetoCarta(n);
		
		return carta;
		
	}
	
	public void devolveCartaAoBaralho(Carta carta) {
		int n;
		n = this.getIndiceCarta(carta);
		
		carta = null; //referência passada por valor, mas como fazer?/////////////////////////////////////////////////////////////////
		
		cartas[n] = false;
	}
	
	private int escolheCarta() {
		//
	}
	
	private int getIndiceCarta(Carta carta) {
		int n;
		int naipe = carta.getNaipe(),
			identificador = carta.getIdentificador();
		
		switch (naipe) {
			case Naipe.PAUS: {
				n = identificador - 1;
				break;
			}
			case Naipe.COPAS: {
				n = identificador + 12;
				break;
			}
			case Naipe.ESPADAS: {
				n = identificador + 25;
				break;
			}
			case Naipe.OURO: {
				n = identificador + 38;
			}
		}
		
		return n;
	}
	
	private Carta getObjetoCarta(int id) {
		Carta carta;
		
		if(id < 13) {
			carta.setNaipe(Naipe.PAUS);
			carta.setIdentificador(id + 1);
		} else { 
			if(id < 26) {
				carta.setNaipe(Naipe.COPAS);
				carta.setIdentificador(id - 12);
			} else {
				if(id < 39) {
					carta.setNaipe(Naipe.ESPADAS);
					carta.setIdentificador(id - 25);
				} else {
					carta.setNaipe(Naipe.OURO);
					carta.setIdentificador(id - 38);
				}
			}
		}
		
		return carta;
	}

}

/*
 * Considerações:
 *  0 - 12 -> Paus
 * 13 - 25 -> Copas
 * 26 - 38 -> Espadas
 * 39 - 51 -> Ouro
 */