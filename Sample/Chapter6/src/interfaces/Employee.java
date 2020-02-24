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
	
//	//按姓名从小到大排序
//	public int compareTo(Employee other) {
//		return this.name.compareTo(other.name);
//	}
//	//按工资从小到大排序
//	public int compareTo(Employee other) {
//		return Double.compare(this.salary, other.salary);
//	}
	//按工资从大到小排序
	public int compareTo(Employee other) {
		return Double.compare(other.salary, this.salary);
	}
}
