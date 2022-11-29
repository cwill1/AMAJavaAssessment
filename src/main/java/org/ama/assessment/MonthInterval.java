package org.ama.assessment;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.*;



public class MonthInterval {
	public static String[] generateMonthsInInterval(LocalDate startDate, LocalDate endDate) {
        String[] monthNames = null;

        // ### TODO: add month names generation logic here ###
		Period period = Period.between(startDate, endDate);
		int years = period.getYears() * 12;
		int months = years + period.getMonths();

		monthNames = new String[months + 1];

		int start = startDate.getMonth().getValue();

		Map<Integer, String> monthMap = Stream.of(new Object[][]{
				{1, "January"},
				{2, "February"},
				{3, "March"},
				{4, "April"},
				{5, "May"},
				{6, "June"},
				{7, "July"},
				{8, "August"},
				{9, "September"},
				{10, "October"},
				{11, "November"},
				{12, "December"},
		}).collect(Collectors.toMap(month -> (Integer) month[0], month -> (String) month[1]));

		for (int i = 0; i <= months; i++){
			int value = start + i;
			if(value % 12 == 0){
				value = 12;
			}
			else if(value > 12){
				value = value % 12;
			}

			monthNames[i] = monthMap.get(value);
		}

        // ##########################################

		return monthNames;
	 }
}
