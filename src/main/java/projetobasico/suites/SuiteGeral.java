package projetobasico.suites;

import org.junit.AfterClass;
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
	public static void inicializa() {
		page.acessarTelaInicial();
		
		page.setEmail("leonam@email.com");
		page.setSenha("654321");
		
		page.entrar();
	}

	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
}
