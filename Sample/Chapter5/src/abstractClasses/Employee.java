package abstractClasses;

import java.time.*;

/**
 *继承自抽象类Person
 */
public class Employee extends Person{
	//private String name;	父类Person有了
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String name,double salary,int year,int month,int day) {
		super(name);
		this.salary=salary;
		this.hireDay=LocalDate.of(year,month,day);
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
	
	public String getDescription() {	//必须实现抽象类方法getDescription
		return super.getname()+"is a Employee,salary is "+this.getsalary();
	}
}
