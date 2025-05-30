package projetobasico.pages;

import org.openqa.selenium.By;

import projetobasico.core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		escreve("nome", nome);
	}
	
	public void salvar() {
		clicaBotao(By.xpath("//button[.='Salvar']"));;
	}
	
	public String obterMesagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
}
