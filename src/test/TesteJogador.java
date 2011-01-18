import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.cauirs.jogonim.core.Jogador;
import br.com.cauirs.jogonim.core.PilhaBolas;
import br.com.cauirs.jogonim.core.TipoJogador;
import br.com.cauirs.jogonim.excecoes.JogadaInvalida;
import static br.com.cauirs.jogonim.core.Utilitarios.isPotenciaDeDoisMenosUm;

public class TesteJogador {

	private PilhaBolas pilhaDeBolas;
	
	@Before
	public void setUp()
	{
		pilhaDeBolas = new PilhaBolas(60);
	}
	
	@Test
	public void testeSeComputadorInteligenteJogaPotenciaDeDoisMenosUm() throws JogadaInvalida
	{
		Jogador computadorInteligente = new Jogador("Jogador 1", TipoJogador.COMPUTADOR_INTELIGENTE);
		int bolasRetiradas = computadorInteligente.jogar(pilhaDeBolas);
		assertTrue( isPotenciaDeDoisMenosUm(bolasRetiradas) );
	}
	
	@Test
	public void testeSeComputadorBurroJogaUmNumeroMenorQueAMetadeMasMaiorQueUm() throws JogadaInvalida
	{
		Jogador computadorBurro = new Jogador("Jogador 1", TipoJogador.COMPUTADOR_BURRO);
		int bolasRetiradas = computadorBurro.jogar(pilhaDeBolas);
		assertTrue( bolasRetiradas > 1 && bolasRetiradas <= pilhaDeBolas.getJogadaMaxima() );
	}
	
	@Test
	public void testeSeJogadorBurroRetiraBolaDaPilha() throws JogadaInvalida
	{
		Jogador computadorBurro = new Jogador("Jogador 1", TipoJogador.COMPUTADOR_BURRO);
		
		int quantidadeAnterior = pilhaDeBolas.getNumeroBolas();
		int bolasRetiradas = computadorBurro.jogar(pilhaDeBolas);
		
		assertEquals( quantidadeAnterior - bolasRetiradas, pilhaDeBolas.getNumeroBolas() );
	}
	
	@Test
	public void testeSeJogadorInteligenteRetiraBolaDaPilha() throws JogadaInvalida
	{
		Jogador computadorInteligente = new Jogador("Jogador 1", TipoJogador.COMPUTADOR_INTELIGENTE);
		
		int quantidadeAnterior = pilhaDeBolas.getNumeroBolas();
		int bolasRetiradas = computadorInteligente.jogar(pilhaDeBolas);
		
		assertEquals( quantidadeAnterior - bolasRetiradas, pilhaDeBolas.getNumeroBolas() );
	}
	
}