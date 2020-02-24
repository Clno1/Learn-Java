package abstractClasses;

import java.time.*;

/**
 *�̳��Գ�����Person
 */
public class Employee extends Person{
	//private String name;	����Person����
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
	
	public String getDescription() {	//����ʵ�ֳ����෽��getDescription
		return super.getname()+"is a Employee,salary is "+this.getsalary();
	}
}
