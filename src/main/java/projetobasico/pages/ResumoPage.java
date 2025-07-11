package projetobasico.pages;

import org.openqa.selenium.By;

import projetobasico.core.BasePage;

public class ResumoPage extends BasePage {

	public void excluirMovimentacao() {
		clicaBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMesagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void selecionarAno(String ano) {
		selecionarCombo("ano", ano);
	}
	
	public void buscarAno() {
		clicaBotao(By.xpath("//input[@value='Buscar']"));
	}
}
