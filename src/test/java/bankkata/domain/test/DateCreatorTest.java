package bankkata.domain.test;

import bankkata.builders.DateCreator;
import org.junit.Test;

import java.util.Date;

import static bankkata.matchers.DayMonthYearMatcher.hasDayMonthYear;
import static org.junit.Assert.assertThat;

public class DateCreatorTest {
	
	@Test
    public void
	should_create_a_date_from_string() {
		Date date = DateCreator.date("10/01/2012");
		
		assertThat(date, hasDayMonthYear(10, 1, 2012));
	}
	
}
