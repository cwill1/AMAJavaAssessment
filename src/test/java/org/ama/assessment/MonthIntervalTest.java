package org.ama.assessment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class MonthIntervalTest {
	@Test
	public void testJanuary2017ToMarch2017ReturnsJanuaryThroughMarch() {
		LocalDate january2017= LocalDate.parse("2017-01-01");
		LocalDate march2017 = LocalDate.parse("2017-03-01");
        String[] expectedMonthNames = new String[] {"January", "February", "March"};

		String[] monthNames = MonthInterval.generateMonthsInInterval(january2017, march2017);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}

	@Test
	// expectedValue for this test should start with December
	public void testDecember2017ToJanuary2018ReturnsDecemberThroughJanuary() {
		LocalDate december2017= LocalDate.parse("2017-12-01");
		LocalDate january2018 = LocalDate.parse("2018-01-01");
		// String[] expectedMonthNames = new String[] {"January", "December"};
		// incorrect order, December 2017 should come before January 2018
		String[] expectedMonthNames = new String[] {"December", "January"};


		String[] monthNames = MonthInterval.generateMonthsInInterval(december2017, january2018);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}

	@Test
	public void testJanuary2017ToJanuary2018ReturnsJanuaryThroughDecember() {
		LocalDate january2017= LocalDate.parse("2017-01-01");
		// LocalDate january2018 = LocalDate.parse("2018-03-01");
		// above date is March 1, 2018 but original test says January2017ToJanuary2018
		LocalDate january2018 = LocalDate.parse("2018-01-01");
		// String[] expectedMonthNames = new String[] {
		// "January", "February", "March", "April", "May", "June",
		// "July", "August", "September", "October", "November", "December"};
		// this above array is missing January 2018
		String[] expectedMonthNames = new String[] {
				"January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December",
				"January"
		};

		String[] monthNames = MonthInterval.generateMonthsInInterval(january2017, january2018);
        for (String monthName : monthNames) {
            System.out.println(monthName);
        }
        System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}

	@Test
	@DisplayName("should print 2 years worth of months")
	public void shouldPrintMonthsFromJanuary2017ToJanuary2018() {
		LocalDate january2017= LocalDate.parse("2017-01-01");
		LocalDate january2018 = LocalDate.parse("2019-01-01");
		String[] expectedMonthNames = new String[] {
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December",
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December",
				"January"
		};

		String[] monthNames = MonthInterval.generateMonthsInInterval(january2017, january2018);
		for (String monthName : monthNames) {
			System.out.println(monthName);
		}
		System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}

	@Test
	@DisplayName("should print 1 month")
	public void shouldPrintMonthFromJanuary2017ToJanuary2017() {
		LocalDate january2017= LocalDate.parse("2017-01-01");
		LocalDate january2018 = LocalDate.parse("2017-01-01");
		String[] expectedMonthNames = new String[] {
				"January"
		};

		String[] monthNames = MonthInterval.generateMonthsInInterval(january2017, january2018);
		for (String monthName : monthNames) {
			System.out.println(monthName);
		}
		System.out.println();

		assertEquals(expectedMonthNames, monthNames);
	}

	@Test
	@DisplayName("should contain 121 months")
	public void shouldContainTheCorrectNumberOfMonthsForTenYears() {
		LocalDate january2017= LocalDate.parse("2017-01-01");
		LocalDate january2018 = LocalDate.parse("2027-01-01");
		String[] monthNames = MonthInterval.generateMonthsInInterval(january2017, january2018);

		assertEquals(121, monthNames.length);
	}

}
