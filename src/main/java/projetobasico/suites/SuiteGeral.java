package projetobasico.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import projetobasico.core.DriverFactory;
import projetobasico.pages.LoginPage;
import projetobasico.tests.ContaTest;
import projetobasico.tests.MovimentacaoTest;
import projetobasico.tests.RemoverMovimentacaoContaTest;
import projetobasico.tests.ResumoTest;
import projetobasico.tests.SaldoTest;

@RunWith(Suite.class)

@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})

public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		
		page.logar("leonam@email.com", "654321");
		
		page.resetar();
		
		DriverFactory.killDriver();
	}
}
