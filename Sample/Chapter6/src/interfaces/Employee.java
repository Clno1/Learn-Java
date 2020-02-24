package interfaces;

public class Employee implements Comparable<Employee>
{
	private String name;
	private double salary;
	
	public Employee(String name,double salary) {
		this.name=name;
		this.salary=salary;
	}
	
	public String getname() {
		return this.name;
	}
	public double getsalary() {
		return this.salary;
	}
	
//	//��������С��������
//	public int compareTo(Employee other) {
//		return this.name.compareTo(other.name);
//	}
//	//�����ʴ�С��������
//	public int compareTo(Employee other) {
//		return Double.compare(this.salary, other.salary);
//	}
	//�����ʴӴ�С����
	public int compareTo(Employee other) {
		return Double.compare(other.salary, this.salary);
	}
}
