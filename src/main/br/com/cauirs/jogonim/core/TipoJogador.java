package br.com.cauirs.jogonim.core;

import static br.com.cauirs.jogonim.core.Utilitarios.isPotenciaDeDoisMenosUm;

import java.util.Scanner;

import br.com.cauirs.jogonim.excecoes.JogadaInvalida;

public enum TipoJogador {
	
	HUMANO {
		@Override
		public int retirarDa( PilhaBolas pilhaDeBolas ) throws JogadaInvalida 
		{
			Scanner leitor = new Scanner(System.in);
	
			System.out.print("Quantidade de Bolas que voce quer retirar: ");
			int bolasRetiradas = leitor.nextInt();
		
			pilhaDeBolas.retirarBola( bolasRetiradas );
			
			return bolasRetiradas;
		}
	}, COMPUTADOR_BURRO {
		
		@Override
		public int retirarDa( PilhaBolas pilhaDeBolas ) throws JogadaInvalida 
		{		
			Jogada jogada = new Jogada( pilhaDeBolas.getJogadaMaxima() );
			
			int bolasRetiradas = jogada.retirarNumeroAleatorio();
			
			pilhaDeBolas.retirarBola( bolasRetiradas );
			
			return bolasRetiradas;
		}
		
	}, COMPUTADOR_INTELIGENTE {
		
		//Ele deve jogar 1, 3, 7, 15, 31 ou 63
		@Override
		public int retirarDa( PilhaBolas pilhaDeBolas ) throws JogadaInvalida 
		{
			Jogada jogada = new Jogada(pilhaDeBolas.getJogadaMaxima());
			
			int bolasRetiradas;
				
			//Se a quantidade de bolas � igual a uma potencia de dois menos um o computador inteligente faz um movimento aleat�rio
			if( isPotenciaDeDoisMenosUm(pilhaDeBolas.getNumeroBolas()) )
				bolasRetiradas = jogada.retirarNumeroAleatorio();
			
			//Se a quantidade n�o � potencia de dois menos um. Eu retiro uma quantidade de bolas igual a alguma potencia de dois menos um
			else
			{
				bolasRetiradas = jogada.retirarPotenciaDeDoisMenosUm();
			}
			
			pilhaDeBolas.retirarBola( bolasRetiradas );
			
			return bolasRetiradas;
		}
	};

	public abstract int retirarDa( PilhaBolas pilhaDeBolas ) throws JogadaInvalida;
	
}