package com.horstman.corejava;

import java.time.*;

public class Employee {
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String aname,double asalary,int ayear,int amonth,int aday) {
		this.name=aname;
		this.salary=asalary;
		this.hireDay=LocalDate.of(ayear, amonth, aday);
	}
	
	public String getname() {
		return this.name;
	}
	public double getsalary() {
		return this.salary;
	}
	public LocalDate gethireday() {
		return this.hireDay;
	}
	public void raisesalary(double byPercent) {
		double raise=this.salary*byPercent/100.0;
		this.salary+=raise;
	}
}
