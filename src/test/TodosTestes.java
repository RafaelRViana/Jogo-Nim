import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value=
	{
		TesteJogador.class,
		TesteJogo.class,
		TestePilhaBolas.class
	}
)
public class TodosTestes {

}
