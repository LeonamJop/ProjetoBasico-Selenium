package projetobasico.tests;

import org.junit.Assert;
import org.junit.Test;

import projetobasico.core.BaseTest;
import projetobasico.pages.HomePage;

public class SaldoTest extends BaseTest {
	
	HomePage homePage = new HomePage();

	@Test
	public void deveTrazerSaldoConta() {
		Assert.assertEquals("500.00", homePage.obterSaldoConta("Conta do Teste Alterada"));
	}
}
