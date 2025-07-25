package projetobasico.tests;

import static projetobasico.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import projetobasico.core.BaseTest;
import projetobasico.core.DriverFactory;
import projetobasico.pages.MenuPage;
import projetobasico.pages.ResumoPage;

public class ResumoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void deve1ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMesagemSucesso());
	}
	
	@Test
	public void deve2RetornarResumoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		resumoPage.selecionarAno("2024");
		resumoPage.buscarAno();
		
		List<WebElement> elementosEncontrados = DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		
		Assert.assertEquals(0, elementosEncontrados.size());
	}
}
