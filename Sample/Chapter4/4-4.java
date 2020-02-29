
public class ParamTest {
	public static void main(String args[]) {
		/**
		 * 第一个测试：基本类型传参是不会改变的
		 */
		System.out.println("Test1:");
		double percent=10;
		System.out.println("percent's value is "+percent);
		test1(percent);
		System.out.println("percent's value is "+percent);
		
		/**
		 * 第二个测试：对象做传参是可以改变的
		 */
		System.out.println("\nTest2:");
		Employee e=new Employee("Test2",70000);
		System.out.println("Test2's salary is "+e.getsalary());
		test2(e);
		System.out.println("Test2's salary is "+e.getsalary());
	
		/**
		 * 第三个实验：通过swap证明其实Java的传参就是“值传参”
		 * 基本类型就直接copy
		 * 对象就是传引用
		 */
		System.out.println("\nTest3:");
		Employee Aman=new Employee("Aman",8000);
		Employee Bman=new Employee("Bman",9000);
		System.out.println("Aman's name is "+Aman.getname());
		System.out.println("Bman's name is "+Bman.getname());
		swap(Aman,Bman);
		System.out.println("Aman's name is "+Aman.getname());
		System.out.println("Bman's name is "+Bman.getname());
	}
	
	public static void test1(double x) {
		x=x*3;
		System.out.println("x's value is "+x);
	}
	
	public static void test2(Employee x) {
		x.raisesalary(10);
	}
	
	public static void swap(Employee a,Employee b) {
		Employee t=a; a=b; b=a;
	}
}

class Employee
{
	private String name;
	private double salary;
	
	public Employee(String aname,double asalary) {
		name=aname;
		salary=asalary;
	}
	
	public String getname() {
		return name;
	}
	public double getsalary() {
		return salary;
	}
	
	public void raisesalary(double byPercent) {
		double raise=salary*byPercent/100.0;
		salary+=raise;
	}
}