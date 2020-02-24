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
		//��this��other�Ƿ�ͬһ����
		if (this==other) return true;
		
		//other�Ƿ�Ϊnull
		if (other==null) return false;
		
		//this��other�Ƿ� ��ͬһ����
		if (this.getClass()!=other.getClass()) return false;
		
		//this��other����this���࣬����ǿ������ת��
		Employee e=(Employee)other;
		
		//���һ����������Ҫ�Ƚϵ����бȽ�
		//ʹ��==�Ƚϻ������ͣ�ʹ��Objects.equals()�Ƚ϶�������
		return Objects.equals(this.name,e.name) && this.salary==e.salary
				&& Objects.equals(this.hireDay, e.hireDay);
	}
	
	//Objects.hash�Դ��������hashCodeȻ�������Щɢ��ֵ
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

