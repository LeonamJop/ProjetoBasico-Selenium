package projetobasico.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import projetobasico.core.BaseTest;
import projetobasico.pages.MenuPage;
import projetobasico.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void deveInserirMovimentacao() {
		menuPage.acessarTelaListarMovimentacao();
		
		movPage.setDataMovimentacao("04/06/2025");
		movPage.setDataPagamento("04/06/2025");
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste Alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMesagemSucesso());
	}
	
	@Test
	public void deveValidarCamposObrigatorios() {
		menuPage.acessarTelaListarMovimentacao();
		
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		
		//Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0)); --Se mudar a ordem o teste falha
		
		//Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório")); --Teria que fazer uma linha para cada mensagem de erro
		
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número"
		)));
		
		Assert.assertEquals(6, erros.size());
	}
}
