package com.example.Sindopan.model;

public class MonthModel {
	
	private String month;

    public void setMonth(String month) {
		System.out.println("set month "+month);
		this.month = month;
	}
	
	public String getMonth() {
		System.out.println("get month "+month);
		return month;
	}
}
