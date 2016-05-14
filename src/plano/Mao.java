package plano;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Mao {
	
	private ArrayList<Carta> cartas;
	public static final int tamanhoMao = 5;
	
	public Mao(){
		cartas = new ArrayList<Carta> ();
	}
	
	public void addCarta(Carta carta) { //SET///////////////////////////////////////////////////método adicionado
		if(this.cartas.size() < Mao.tamanhoMao) {
			this.cartas.add(carta);
		}
		/* Mantem as cartas dao mao ordenadas a partir do fim da distribuicao das cartas*/
		if (this.cartas.size() == Mao.tamanhoMao){ 
			Collections.sort(this.cartas);
		}
	}
	
	public Carta retiraCarta(int idCarta) { //GET///////////////////////////////////////////////método adicionado
		Carta carta = null;
		
		if(idCarta >= 0 && idCarta < this.cartas.size()) {
			carta = this.cartas.remove(idCarta);
		}
		
		return carta;
	}
	
	public int getIdentificadorCarta(int id){//////////////////////////////////////////////////método adicionado
		Carta carta;
		carta = cartas.get(id);
		return carta.getIdentificador();
	}
	
	public Naipe getNaipeCarta(int id){//////////////////////////////////////////////////método adicionado
		Carta carta;
		carta = cartas.get(id);
		return carta.getNaipe();
	}
	
	public Carta getCarta(int id){//////////////////////////////////////////////////método adicionado
		Carta carta;
		carta = cartas.get(id);
		return carta;
	}
	
	public boolean estaEmSequencia(){//////////////////////////////////////////////////método adicionado
		int i, atual, prox;
		boolean maiorSequencia;				
		
		/* Verifica se há a maior sequencia (10 J Q K A) */
		if (this.getMaiorCarta().getIdentificador() == CartaEspecial.A.getValor()){
			maiorSequencia = true;
			for (i = 1; i < Mao.tamanhoMao - 1; i++){
				/* a carta A fica sempre na primeira posicao da ordenacao, por verificamos sequencia a partir da segunda */
				atual = this.getCarta(i).getIdentificador();
				prox = this.getCarta(i+1).getIdentificador();
				if (atual != (prox - 1)){
					maiorSequencia = false;								
				}			
			}
			if (this.getCarta(Mao.tamanhoMao-1).getIdentificador() != CartaEspecial.K.getValor()){
				/* Verifica se A está sendo precedida de K, que é a unica possibilidade de sequencia quando A é tratada como se valesse 14 */
				maiorSequencia = false;
			}
			if (maiorSequencia){
				return true;
			}
		}
		/* Verifica se ha alguma sequencia */
		for (i = 0; i < Mao.tamanhoMao - 1; i++){
			atual = this.getCarta(i).getIdentificador();
			prox = this.getCarta(i+1).getIdentificador();			
			if (atual != (prox - 1)){			
				return false;								
			}			
		}
		return true;
	}
	
	public Carta getMenorCarta(){//////////////////////////////////////////////////método adicionado
		Carta carta = this.cartas.get(0);
		if (carta.getIdentificador() == CartaEspecial.A.getValor()){
			return this.cartas.get(1);
		}
		return carta;
	}
	public Carta getMaiorCarta(){//////////////////////////////////////////////////método adicionado
		Carta carta = this.cartas.get(0);
		if (carta.getIdentificador() == 1){ /* Se a menor carta na ordenacao for A, A é a maior carta no poker */
			return carta;
		}
		else{
			return this.cartas.get(Mao.tamanhoMao - 1);
		}
	}
	
	@Override
	public String toString(){//////////////////////////////////////////////////método adicionado
		String str = new String("Mao: ");
		Iterator <Carta>it = this.cartas.iterator();
		
		while(it.hasNext()){
			str = str.concat(it.next().toString());
			str = str.concat(", ");
		}
		return str;
	}
}