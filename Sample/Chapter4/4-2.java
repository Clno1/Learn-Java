import java.time.*;

public class EmployeeTest
{
	public static void main(String[] args) {
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("A",8000,2020,1,1);
		staff[1]=new Employee("B",9000,2020,2,2);
		staff[2]=new Employee("C",10000,2020,3,3);
		
		for (Employee e:staff)
			System.out.println(e.getName()+"'s salary is "+e.getSalary());
		for (Employee e:staff)
			e.raiseSalary(10);
		for (Employee e:staff)
			System.out.println(e.getName()+"'s salary is "+e.getSalary());
	}
}

class Employee
{
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	//构造函数
	public Employee(String aname,double s,int year,int month,int day) {
		name=aname;
		salary=s;
		hireDay=LocalDate.of(year,month,day);
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	public LocalDate getHireDay( ) {
		return hireDay;
	}
	public void raiseSalary(double byPrecent) {
		double raise=salary*byPrecent/100;
		salary+=raise;
	}
}