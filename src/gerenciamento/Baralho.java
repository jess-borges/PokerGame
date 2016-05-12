package gerenciamento;

import plano.Carta;

public class Baralho {
	
	boolean[] cartas = new boolean[52];
	
	public Baralho() {////////////////////////////////////////////////////////////método Adicionado
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
			case Paus: {
				n = identificador - 1;
				break;
			}
			case Copas: {
				n = identificador + 12;
				break;
			}
			case Espadas: {
				n = identificador + 25;
				break;
			}
			case Ouro: {
				n = identificador + 38;
			}
		}
		
		return n;
	}
	
	private Carta getObjetoCarta(int id) {
		Carta carta;
		
		if(id < 13) {
			carta.setNaipe(Paus);
			carta.setIdentificador(id + 1);
		}
		else { 
			if(id < 26) {
				carta.setNaipe(Copas);
				carta.setIdentificador(id - 12);
			} else {
				if(id < 39) {
					carta.setNaipe(Espadas);
					carta.setIdentificador(id - 25);
				} else {
					carta.setNaipe(Ouro);
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