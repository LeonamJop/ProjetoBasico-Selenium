package projetobasico.tests;

import static projetobasico.utils.DataUtils.obterDataComDiferencaDias;
import static projetobasico.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import projetobasico.core.BaseTest;
import projetobasico.pages.MenuPage;
import projetobasico.pages.MovimentacaoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void deve1InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste Alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMesagemSucesso());
	}
	
	@Test
	public void deve2ValidarCamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		
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
	
	@Test
	public void deve3RetornarErroAoIncluirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste Alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
			
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		
		Assert.assertEquals(1, erros.size());
	}
}
