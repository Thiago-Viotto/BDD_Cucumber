package steps;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import converters.DateConverter;
import io.cucumber.java.ParameterType;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Aprender_Cucumber_Step {

	Date entrega = new Date();

	@Dado("que a data da entrega é dia {}")
	public void queADataDaEntregaÉDia(String data) throws ParseException {
		DateConverter dateConverter = new DateConverter();
		entrega = dateConverter.dateConverter(data);
	}

	@Quando("passar {int} dias")
	public void passarDoisDias(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(entrega);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		entrega = calendar.getTime();
	}

	@Então("a data da entrega será dia {}")
	public void aDataDaEntregaSeráDia(String data) throws ParseException {
		Date dataAtualizadaFormatada = new Date();
		DateConverter dateConverter = new DateConverter();
		dataAtualizadaFormatada = dateConverter.dateConverter(data);

		Assert.assertEquals(dataAtualizadaFormatada, entrega);
	}

	@ParameterType("ticket|ticket especial") // regexp
	public String isTicketSpecial(String option) { // type, name (from method)
		return option;
	}
	
	@Dado("que o {isTicketSpecial} é {string}")
	public void que_o_ticket_é(String tipo, String ticketRecebido) {
		isTicketSpecial(tipo);
	}

	@Dado("que o valor da passagem é R$ {double}")
	public void que_o_valor_da_passagem_é_r$(Double valorPassagemRecebido) {
		System.out.println(valorPassagemRecebido);
	}

	@Dado("que o nome do passageiro é {string}")
	public void que_o_nome_do_passageiro_é(String nomePassageiroRecebido) {
		System.out.println(nomePassageiroRecebido);
	}

	@Dado("^que o telefone do passageiro é (\\d+)-(\\d+)$")
	public void queOTelefoneDoPassageiroÉ(int int1, int int2) {
		System.out.println(int1);
	}

}
