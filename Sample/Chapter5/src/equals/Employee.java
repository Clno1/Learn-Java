package equals;

import java.time.*;
import java.util.Objects;

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
	
	public boolean equals(Object other) {
		//①this和other是否同一对象
		if (this==other) return true;
		
		//other是否为null
		if (other==null) return false;
		
		//this和other是否 是同一个类
		if (this.getClass()!=other.getClass()) return false;
		
		//this和other都是this的类，可以强制类型转化
		Employee e=(Employee)other;
		
		//最后一步对所有需要比较的域经行比较
		//使用==比较基本类型，使用Objects.equals()比较对象类型
		return Objects.equals(this.name,e.name) && this.salary==e.salary
				&& Objects.equals(this.hireDay, e.hireDay);
	}
	
	//Objects.hash对传入参数做hashCode然后组合这些散列值
	public int hashCode() {
		return Objects.hash(name,salary,hireDay);
	}
	
	public String toString() {
		return this.getClass()+"[name="+this.name+",salary="+this.salary+",hireDay="+this.hireDay+"]";
	}
	
	public static void main(String args[]) {
		System.out.println("Test");
	}
}

