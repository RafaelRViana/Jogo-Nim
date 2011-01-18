import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.cauirs.jogonim.core.Jogador;
import br.com.cauirs.jogonim.core.Jogo;
import br.com.cauirs.jogonim.core.TipoJogador;
import br.com.cauirs.jogonim.excecoes.JogadaInvalida;


public class TesteJogo {

	private Jogo jogo;
	private Jogador primeiroJogador;
	private Jogador segundoJogador;
	
	@Before
	public void setUp()
	{
		primeiroJogador = new Jogador("Jogador 1", TipoJogador.HUMANO);
		segundoJogador = new Jogador("Jogador 2", TipoJogador.HUMANO);
		jogo = new Jogo(primeiroJogador, segundoJogador);
	}
	
	@Test
	public void testeSeAchaFimDeJogo() throws JogadaInvalida
	{
		assertFalse( jogo.chegouAoFim() );
		
		while( !jogo.chegouAoFim() )
			jogo.getPilhaDeBolas().retirarBola( jogo.getPilhaDeBolas().getJogadaMaxima() );
		
		//Essa asser��o ser� verdadeira, pois sai do while.
		//Mas, n�o achei outra maneira de testar esse m�todo.
		//Porque a pilha � inicializada com um valor aleat�rio.
		assertTrue( jogo.chegouAoFim() );
	}
	
	@Test  
	public void testeSePilhaCriadaTemEntreDezECemBolas()  
	{  
	     int quantidadeBolas = jogo.getPilhaDeBolas().getNumeroBolas();
	     assertTrue( quantidadeBolas > 10 );  
	     assertTrue( quantidadeBolas < 100 );  
	}  
	
	@Test
	public void testeSePassaAVez()
	{
		jogo.sortearQuemComecaOJogo();
		Jogador jogadorSelecionado = jogo.getJogadorDaVez();
		jogo.passarAVez();
		assertNotSame(jogadorSelecionado, jogo.getJogadorDaVez());
	}
	
	@Test
	public void testeSeSorteiaJogador()
	{
		jogo.sortearQuemComecaOJogo();
		assertNotNull(jogo.getJogadorDaVez());
	}
	
}