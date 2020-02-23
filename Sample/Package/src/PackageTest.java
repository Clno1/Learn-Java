import com.horstman.corejava.*;

import static java.lang.System.*;

public class PackageTest {
	public static void main(String[] args) {
		Employee Aman=new Employee("Aman",7000,2020,1,1);
		
		out.println(Aman.getname()+"'s salary is "+Aman.getsalary());
		
		Aman.raisesalary(10);
		
		out.println(Aman.getname()+"'s salary is "+Aman.getsalary());
	}
}
