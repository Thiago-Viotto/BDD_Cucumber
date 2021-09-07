package converters;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.java.ParameterType;

public class DateConverter {

	@ParameterType(".*") // regexp
	public Date dateConverter(String option) throws ParseException { // type, name (from method)
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date retorno = format.parse(option);
		return retorno;
	}

}
