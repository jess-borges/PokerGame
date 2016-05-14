package gerenciamento;

import java.util.ArrayList;
import plano.Jogador;
import plano.Classificacao;
import plano.ClassificadorJogo;

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
		boolean desejaJogarNovaRodada = true;
		int i, pilha, idVencedor;
		String nome;
		
		InterfaceUsuario.printBoasVindas();
		pilha = InterfaceUsuario.getNumeroFichasPilha();
		this.numeroJogadores = InterfaceUsuario.getNumeroJogadores();
		
		for(i=0; i<this.numeroJogadores; i++) {
			nome = InterfaceUsuario.getNomeJogador(i+1);
			this.jogadores.add(new Jogador(nome, pilha));
		}
		
		
		while(desejaJogarNovaRodada) {
			this.novaRodada();
			for(i=0; i<6; i++) {
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
						idVencedor = this.selecionaVencedor(1);
						InterfaceUsuario.printShowDown(this.jogadores, idVencedor, this.getPoteTotal());
						break;
					}
					case 6: {
						idVencedor = this.selecionaVencedor(2);
						InterfaceUsuario.printShowDown(this.jogadores, idVencedor, this.getPoteTotal());
						this.estado ++;
					}
				}
				if(this.estado > 6)
					break;
			}
			//////////////////////////////////////Pergunta se quer jogar de novo
		}
	}
	
	public void novaRodada() {
		this.estado = 0;
		
		this.dealer++;
		this.dealer = this.dealer % this.numeroJogadores;
		
		int i;
		for(i=0; i<this.numeroJogadores; i++)
			this.jogadores.get(i).setPote(0);
	}
	
	public int getPoteTotal() {
		int i, pote = 0;
		
		for(i=0; i<this.numeroJogadores; i++) {
			pote += this.jogadores.get(i).getPote();
		}
		
		return pote;
	}
	
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
			jogador = this.jogadores.get((this.dealer + 3 + i) % this.numeroJogadores);
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
			jogador = this.jogadores.get((this.dealer + 3 + i ) % this.numeroJogadores);
			
			if(!jogador.getJogando() || jogador.getPote() == this.maiorAposta) { 
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
			jogador = this.jogadores.get((this.dealer + 1 + i) % this.numeroJogadores);
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
			jogador = this.jogadores.get((this.dealer + 1 + i) % this.numeroJogadores);
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
			jogador = this.jogadores.get((this.dealer + 1 + i ) % this.numeroJogadores);
			
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
			jogador = this.jogadores.get(i);
			if(jogador.getJogando())
				cnt++;
		}
		
		if(cnt >= 2)
			return true;
		
		return false;
	}
	
	private int selecionaVencedor(int tipo) {
		int i, idVencedor = -1;
		Classificacao score, maiorScore = Classificacao.DESCONHECIDA;
		Jogador jogador;
		ClassificadorJogo classificador = new ClassificadorJogo();
		
		if(tipo == 1) {
			for(i=0; i<this.numeroJogadores; i++) {
				jogador = this.jogadores.get(i);
				score = classificador.classifica(jogador.getMao());
				
				if(score.getPontuacao() > maiorScore.getPontuacao()) {
					maiorScore = score;
					idVencedor = i;
				}
			}
			///////////////////////////////////Passa de novo, pra ver se tem empate
		}
		if(tipo == 2) {
			for(i=0; i<this.numeroJogadores; i++) {
				jogador = this.jogadores.get(i);
				
				if(jogador.getJogando()) {
					idVencedor = i;
					break;
				}
			}
		}
		
		return idVencedor;
	}
}//////////////////////////////////////////////////////////////////////////////////verificar se existem fichas sufucientes na pilha para a aposta