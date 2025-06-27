package projetobasico.tests;

import org.junit.Assert;
import org.junit.Test;
import projetobasico.core.BaseTest;
import projetobasico.core.Propriedades;
import projetobasico.pages.HomePage;
import projetobasico.pages.MenuPage;

public class SaldoTest extends BaseTest {
	
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();

	@Test
	public void deveTrazerSaldoConta() {
		menu.acessarTelaPrincipal();
		
		Assert.assertEquals("500.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}
}
