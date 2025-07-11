package projetobasico.tests;

import org.junit.Assert;
import org.junit.Test;
import projetobasico.core.BaseTest;
import projetobasico.pages.HomePage;
import projetobasico.pages.MenuPage;

public class SaldoTest extends BaseTest {
	
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();

	@Test
	public void deveTrazerSaldoConta() {
		menu.acessarTelaPrincipal();
		
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}
}
