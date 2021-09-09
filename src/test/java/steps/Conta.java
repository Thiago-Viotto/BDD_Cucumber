package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import junit.framework.Assert;

public class Conta {

	WebDriver driver = new ChromeDriver();
	String contaEsperada;

	@Dado("que estou acessando a aplicação")
	public void queEstouAcessandoAAplicação() {
		driver.get("https://seubarriga.wcaquino.me/login");
	}

	@Quando("informo o usuário {string}")
	public void informoOUsuário(String string) {
		driver.findElement(By.id("email")).sendKeys(string);
	}

	@Quando("a senha {string}")
	public void aSenha(String string) {
		driver.findElement(By.id("senha")).sendKeys(string);
	}

	@Quando("seleciono entrar")
	public void selecionoEntrar() {
		driver.findElement(By.className("btn-primary")).click();
	}

	@Então("visualizo a página inicial")
	public void visualizoAPáginaInicial() {
		String alert = driver.findElement(By.className("alert-success")).getText();
		org.junit.Assert.assertEquals("Bem vindo, Thiago!", alert);
	}

	@Quando("seleciono Contas")
	public void selecionoContas() {
		driver.findElement(By.className("dropdown-toggle")).click();
	}

	@Quando("seleciono Adicionar")
	public void selecionoAdicionar() {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("informo a conta {string}")
	public void informoAConta(String string) {
		contaEsperada = string;
		driver.findElement(By.id("nome")).sendKeys(string);
	}

	@Quando("seleciono Salvar")
	public void selecionoSalvar() {
		driver.findElement(By.className("btn-primary")).click();
	}

	@Então("a conta é inserida com sucesso")
	public void aContaÉInseridaComSucesso() {
		String conta = driver.findElement(By.xpath("//td[text()='" + contaEsperada + "']")).getText();
		String alert = driver.findElement(By.className("alert-success")).getText();
		org.junit.Assert.assertEquals("Conta adicionada com sucesso!", alert);
		org.junit.Assert.assertEquals(contaEsperada, conta);
	}

	@Então("sou notificar que o nome da conta é obrigatório")
	public void souNotificarQueONomeDaContaÉObrigatório() {
		String alert = driver.findElement(By.className("alert-danger")).getText();
		org.junit.Assert.assertEquals("Informe o nome da conta", alert);

		// checa se o elemento não está visível
		org.junit.Assert.assertEquals(0, driver.findElements(By.id("tabelaContas")).size());
	}

	@Então("sou notificado que já existe uma conta com esse nome")
	public void souNotificadoQueJáExisteUmaContaComEsseNome() {
		String alert = driver.findElement(By.className("alert-danger")).getText();
		org.junit.Assert.assertEquals("Já existe uma conta com esse nome!", alert);
		org.junit.Assert.assertEquals(0, driver.findElements(By.id("tabelaContas")).size());
	}
	
	@After
	public void fechar() {
		driver.quit();
	}

}
