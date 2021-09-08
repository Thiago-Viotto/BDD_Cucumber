package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Conta {
	
	WebDriver driver = new ChromeDriver();

	@Dado("que estou acessando a aplicação")
	public void queEstouAcessandoAAplicação() {
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/login");
	}

	@Quando("informo o usuário {string}")
	public void informoOUsuário(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("a senha {string}")
	public void aSenha(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("seleciono entrar")
	public void selecionoEntrar() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Então("visualizo a página inicial")
	public void visualizoAPáginaInicial() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("seleciono Contas")
	public void selecionoContas() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("seleciono Adicionar")
	public void selecionoAdicionar() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("informo a conta {string}")
	public void informoAConta(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("seleciono Salvar")
	public void selecionoSalvar() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Então("a conta é inserida com sucesso")
	public void aContaÉInseridaComSucesso() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
