package interfaces;

import java.util.*;

public class EmployeeSort 
{
	public static void main(String args[]) {
		Employee staff[]=new Employee[3];
		
		staff[0]=new Employee("Cman",8000);
		staff[1]=new Employee("Aman",9000);
		staff[2]=new Employee("Bman",7000);
		
		Arrays.sort(staff);
		
		for (Employee e:staff)
			System.out.println(e.getname()+"'s salary is "+e.getsalary());
	}
}
