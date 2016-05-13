package gerenciamento;

import java.util.ArrayList;
import plano.Jogador;

public class Poker {
	
	private int numeroJogadores;
	private int estado;
	private int maiorAposta;
	private int dealer;
	private Baralho baralho;
	private ArrayList<Jogador> jogadores;
	
	public Poker(/*int numeroJogadores, ArrayList<String> nomesJogadores*/) {
		this.baralho = new Baralho();
	}
	
	public void jogar() {
		////////////////////////////////////////////////////////////////////////////////////ALterando!!!
		boolean desejaJogarNovaRodada = true;
		int i;
		
		while(desejaJogarNovaRodada) {
			this.novaRodada();
			for(i=0; i<7; i++) {
				switch(this.estado) {
					case 0: {
						this.blind();
						this.estado ++;
						break;
					}
					case 1: {
						this.distribuiCartas();
						this.estado ++;
						break;
					}
					case 2: {
						this.primeiraAposta();
						if(this.temPeloMenosDoisJogadores())
							this.estado ++;
						else
							this.estado = 6;
						break;
					}
					case 3: {
						this.draw();
						this.estado ++;
						break;
					}
					case 4: {
						this.segundaAposta();
						if(this.temPeloMenosDoisJogadores())
							this.estado ++;
						else
							this.estado = 6;
						break;
					}
					case 5: {
						//showdown
					}
					case 6: {
						//verifica vencedor
					}
				}
			}
		}
	}
	
	public void novaRodada() {
		this.estado = 0;
		this.dealer++;
		this.dealer = this.dealer % this.numeroJogadores;
	}
	
	/*
	private void identificaJogadores() {
		System.out.println("Quantos jogadores participarão? <2 - 6>:");
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		reader.close(); //conferir se é realmente assim
		
		if (n < 2)
			n = 2;
		if (n > 7)
			n = 7;
		
		this.numeroJogadores = n;
		
		int i;
		
		for(i=0; i<n; i++) {
			//lê e armazena os nomes dos jogadores
		}
	}
	*/
	
	private void distribuiCartas() {
		int i, j;
		Jogador auxJogador;
		
		for(i=0; i<this.numeroJogadores; i++) {
			auxJogador = this.jogadores.get(i);
			for(j=0; j<5; j++) {
				auxJogador.recebeCarta(this.baralho.pedeCarta());
			}
		}
	}
	
	private void blind() { //////////////////////////////////////////////mudei o nome//Anterior: iniciaApostas()
		Jogador smallBlind = jogadores.get((this.dealer + 1) % this.numeroJogadores);
		Jogador bigBlind = jogadores.get((this.dealer + 2) % this.numeroJogadores);
		
		smallBlind.aposta(5);
		bigBlind.aposta(10);
		
		this.maiorAposta = 10;
	}
	
	private void primeiraAposta() {
		int i, raise;
		Jogador jogador;
		Comando comando;
		
		for(i=0; i<this.numeroJogadores; i++) {
			jogador = jogadores.get((this.dealer + 3 + i) % this.numeroJogadores);
			comando = InterfaceUsuario.decifraComando(jogador);
			if(comando == Comando.FOLD) {
				jogador.setJogando(false);
				continue;
			}
			if(comando == Comando.CALL) {
				jogador.aposta(this.maiorAposta - jogador.getPote());
				continue;
			}
			if(comando == Comando.RAISE) {
				raise = InterfaceUsuario.getRaise();
				jogador.aposta(this.maiorAposta + raise);
				this.maiorAposta += raise;
			}
		}
		
		for(i=0; i<this.numeroJogadores; i++) {
			jogador = jogadores.get((this.dealer + 3 + i ) % this.numeroJogadores);
			
			if(!jogador.getJogando() || jogador.getPote() == this.maiorAposta) { ////colocar ISJOGANDO
				continue;
			}
			
			comando = InterfaceUsuario.decifraComando(jogador);
			
			if(comando == Comando.FOLD) {
				jogador.setJogando(false);
				continue;
			}
			if(comando == Comando.CALL) {
				jogador.aposta(this.maiorAposta - jogador.getPote());
				continue;
			}
			if(comando == Comando.RAISE) {
				/////////////////////////////////////Não Pode!
			}
		}
	}
	
	private void draw() {
		int i, j, idCarta;
		Jogador jogador;
		ArrayList<Integer> cartas;
		
		for(i=0; i<this.numeroJogadores; i++) {
			jogador = jogadores.get((this.dealer + 1 + i) % this.numeroJogadores);
			cartas = InterfaceUsuario.getCartasDraw();
			for(j=0; j<cartas.size(); j++) {
				idCarta = cartas.get(j).intValue();
				jogador.retiraCarta(idCarta);
				jogador.recebeCarta(this.baralho.pedeCarta());
			}
		}
	}
	
	private void segundaAposta() {
		int i, raise;
		Jogador jogador;
		Comando comando;
		
		for(i=0; i<this.numeroJogadores; i++) {
			jogador = jogadores.get((this.dealer + 1 + i) % this.numeroJogadores);
			comando = InterfaceUsuario.decifraComando(jogador);
			if(comando == Comando.FOLD) {
				jogador.setJogando(false);
				continue;
			}
			if(comando == Comando.CALL) {
				jogador.aposta(this.maiorAposta - jogador.getPote());
				continue;
			}
			if(comando == Comando.RAISE) {
				raise = InterfaceUsuario.getRaise();
				jogador.aposta(this.maiorAposta + raise);
				this.maiorAposta += raise;
			}
		}
		
		for(i=0; i<this.numeroJogadores; i++) {
			jogador = jogadores.get((this.dealer + 1 + i ) % this.numeroJogadores);
			
			if(!jogador.getJogando() || jogador.getPote() == this.maiorAposta) { ////colocar ISJOGANDO
				continue;
			}
			
			comando = InterfaceUsuario.decifraComando(jogador);
			
			if(comando == Comando.FOLD) {
				jogador.setJogando(false);
				continue;
			}
			if(comando == Comando.CALL) {
				jogador.aposta(this.maiorAposta - jogador.getPote());
				continue;
			}
			if(comando == Comando.RAISE) {
				/////////////////////////////////////Não Pode!
			}
		}
	}
	
	private boolean temPeloMenosDoisJogadores() {
		int i, cnt = 0;
		Jogador jogador;
		for(i=0; i<this.numeroJogadores; i++) {
			jogador = jogadores.get(i);
			if(jogador.getJogando())
				cnt++;
		}
		
		if(cnt >= 2)
			return true;
		
		return false;
	}
}//////////////////////////////////////////////////////////////////////////////////verificar se existem fichas sufucientes na pilha para a aposta