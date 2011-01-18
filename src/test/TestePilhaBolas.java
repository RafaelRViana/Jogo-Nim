import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cauirs.jogonim.core.PilhaBolas;
import br.com.cauirs.jogonim.excecoes.JogadaInvalida;


public class TestePilhaBolas {

	@Test(expected=RuntimeException.class)
	public void testeSeOcorreErroAoIniciarPilhaComMaisDeCemBolas()  
	{  
	     new PilhaBolas(150);   
	}
	
	@Test(expected=RuntimeException.class)
	public void testeSeOcorreErroAoIniciarPilhaComMenosDeDezBolas()  
	{  
	     new PilhaBolas(5);   
	}
	
	@Test(expected=RuntimeException.class)
	public void testeSeOcorreErroAoIniciarPilhaComNumeroNegativoDeBolas()  
	{  
	     new PilhaBolas(-50);   
	}
	
	@Test(expected=JogadaInvalida.class)  
	public void testeSeOcorreErroAoRetirarMenosDoQueUmaBola() throws JogadaInvalida  
	{  
	    PilhaBolas pilha = new PilhaBolas(50);  
	    pilha.retirarBola(0);
	}
	
	@Test(expected=JogadaInvalida.class)  
	public void testeSeOcorreErroAoRetirarMaisDoQueMetadeDoNumeroDeBolas() throws JogadaInvalida  
	{  
	    PilhaBolas pilha = new PilhaBolas(43);  //metade = 21
	    pilha.retirarBola(22);
	}
	
	@Test
	public void testeSeRetiraDezBolas() throws JogadaInvalida
	{
		PilhaBolas pilha = new PilhaBolas(50);
		pilha.retirarBola(10);
		assertEquals( 40, pilha.getNumeroBolas() );
	}
	
	@Test
	public void testeSeComDezBolasPossoRetirarNoMaximoCinco()
	{
		PilhaBolas pilha = new PilhaBolas(10);
		assertEquals(5, pilha.getJogadaMaxima());
	}
	
	@Test
	public void testeSeComUmBolaPossoRetirarNoMaximoUma() throws JogadaInvalida
	{
		//A pilha precisa iniciar com no minimo dez bolas
		PilhaBolas pilha = new PilhaBolas(10);
		
		//So posso retirar metade do numero de bolas
		pilha.retirarBola(5);
		pilha.retirarBola(2);
		pilha.retirarBola(1);
		pilha.retirarBola(1);
		
		assertEquals(1, pilha.getJogadaMaxima());
	}
}