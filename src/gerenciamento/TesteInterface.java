package gerenciamento;

import java.util.ArrayList;

import plano.Jogador;

public class TesteInterface {
	/* Apenas para testar - apagar antes de enviar */
	public static void main(String [ ] args){
		int i, numJog, pilha;
		String nomeJogador;
		Jogador jogador;
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		/*InterfaceUsuario.printBoasVindas();
		numJog = InterfaceUsuario.getNumeroJogadores();
		for (i = 0; i < numJog; i++){
			nomeJogador = InterfaceUsuario.getNomeJogador(i+1);
			System.out.println("\nJogador: " + nomeJogador);
		}
		pilha = InterfaceUsuario.getNumeroFichasPilha();
		System.out.println("\nPilha: " + pilha);
		*/
		jogador = new Jogador("1", 50);
		jogador.aposta(10);		
		jogadores.add(jogador);
		
		jogador = new Jogador("2", 50);
		jogador.aposta(20);		
		jogadores.add(jogador);
		
		jogador = new Jogador("3", 50);
		jogador.aposta(15);		
		jogadores.add(jogador);
		
		jogador = new Jogador("4", 50);
		jogador.aposta(30);		
		jogadores.add(jogador);
		
		InterfaceUsuario.printApostas(30, jogadores, 3);
	}
}
