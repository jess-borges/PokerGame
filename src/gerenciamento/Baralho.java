package gerenciamento;

import plano.Carta;
import plano.Naipe;
import java.util.Random;

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
		Random gerador = new Random();
		int n = gerador.nextInt(52);
		
		while(this.cartas[n]) {
			n++;
		}
		
		return n;
	}
	
	private int getIndiceCarta(Carta carta) {
		int n = -1;
		
		if(carta.getNaipe() == Naipe.PAUS) {
			n = carta.getIdentificador() - 1;
		} else {
			if(carta.getNaipe() == Naipe.COPAS) {
				n = carta.getIdentificador() + 12;
			} else {
				if(carta.getNaipe() == Naipe.ESPADAS) {
					n = carta.getIdentificador() + 25;
				} else {
					if(carta.getNaipe() == Naipe.OUROS) {
						n = carta.getIdentificador() + 38;
					}
				}
			}
		}
		
		return n;
	}
	
	private Carta getObjetoCarta(int id) {
		Carta carta = new Carta();
		
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
					carta.setNaipe(Naipe.OUROS);
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