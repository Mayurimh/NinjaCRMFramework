package com.ninjacrm.generic.javautilities;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class JavaUtilities {
	public int generateRandomValue(int range) {
		Random rd = new Random();
		int num = rd.nextInt(range);
		return num;
	}
	public String generateDate() {
		Date d =new Date();
		SimpleDateFormat sim =new SimpleDateFormat("MM-dd-yyyy");
		String date = sim.format(d);
		return date;
	}
	public String generateExpectedDate(int days) {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy");
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String date = sim.format(cal.getTime());
		return date;
	}
	
	
	public String randomData() {
		UUID uniqueNum = UUID.randomUUID();
		String data = uniqueNum.toString().replaceAll("[^a-zA-Z]", "");
		return data;
	}
}
