package br.com.cauirs.jogonim;

import br.com.cauirs.jogonim.core.Jogador;
import br.com.cauirs.jogonim.core.Jogo;
import br.com.cauirs.jogonim.core.TipoJogador;
import br.com.cauirs.jogonim.excecoes.JogadaInvalida;

public class ControladorJogo {


	public static void main(String[] args) 
	{
		Jogador primeiroJogador = new Jogador("Jogador 1", TipoJogador.COMPUTADOR_INTELIGENTE);
		Jogador segundoJogador = new Jogador("Rafael", TipoJogador.HUMANO);
		
		Jogo jogo = new Jogo(primeiroJogador, segundoJogador);

		int turno = 1;
		int bolasRetiradas = 0;
		
		while( !jogo.chegouAoFim() )
		{
			System.out.printf("Turno: %d\n", turno);
			
			System.out.println("Jogador da Vez: " + jogo.getJogadorDaVez());
			System.out.println("Bolas na Pilha: " + jogo.getPilhaDeBolas().getNumeroBolas());
			System.out.println("Jogada Máxima: " + jogo.getPilhaDeBolas().getJogadaMaxima());
			
			try 
			{
				bolasRetiradas = jogo.jogar();
				
				jogo.passarAVez();
				turno++;
				System.out.printf("Retirou %d bolas.\n\n", bolasRetiradas);
				
			} 
			catch (JogadaInvalida jogada) 
			{
				System.out.printf("Jogada inválida: %s\n\n", jogada.getMensagemErro());
			}
		}
		
		System.out.printf("Vencedor: %s", jogo.getJogadorDaVez());
	}

}
