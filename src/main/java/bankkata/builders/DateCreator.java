package bankkata.builders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCreator {
	
	public static Date date(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
