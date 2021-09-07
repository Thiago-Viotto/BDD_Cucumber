package converters;
import io.cucumber.java.ParameterType;

public class TicketConverter {

	@ParameterType("ticket|ticket especial") // regexp
	public String isTicketSpecial(String option) { // type, name (from method)
		return option;
	}
	
}
