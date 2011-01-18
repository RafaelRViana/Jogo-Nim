package br.com.cauirs.jogonim.core;
import java.util.Random;


public class Jogada 
{

	public Jogada( int quantidadeMaxima )
	{
		this.randonomico  = new Random();
		this.quantidadeMaxima = quantidadeMaxima;
	}
	
	private Random randonomico;
	private Integer quantidadeMaxima;
	
	public int retirarPotenciaDeDoisMenosUm()
	{
		int potencia = randonomico.nextInt(6) + 1;
		int quantidadeRetirada = (int) (Math.pow( 2, potencia ) - 1); //as seis primeiras potencias de dois - 1
		
		while( quantidadeRetirada > quantidadeMaxima )
		{
			potencia = randonomico.nextInt(6) + 1;
			quantidadeRetirada = (int) (Math.pow( 2, potencia ) - 1);
		}
		
		return quantidadeRetirada;
	}
	
	public int retirarNumeroAleatorio()
	{
		return (randonomico.nextInt(quantidadeMaxima) + 1);
	}
	
}