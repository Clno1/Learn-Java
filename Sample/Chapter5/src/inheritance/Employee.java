package inheritance;

import java.time.*;

public class Employee {
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String name,double salary,int year,int month,int day) {
		this.name=name;
		this.salary=salary;
		this.hireDay=LocalDate.of(year,month,day);
	}
	
	public String getname() {
		return name;
	}
	public double getsalary() {
		return salary;
	}
	public LocalDate gethireDay() {
		return hireDay;
	}
	
	public void raisesalary(double byPercent) {
		double raise=byPercent*this.salary/100.0;
		this.salary+=raise;
	}
}
