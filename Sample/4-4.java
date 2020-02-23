
public class ParamTest {
	public static void main(String args[]) {
		/**
		 * ��һ�����ԣ��������ʹ����ǲ���ı��
		 */
		System.out.println("Test1:");
		double percent=10;
		System.out.println("percent's value is "+percent);
		test1(percent);
		System.out.println("percent's value is "+percent);
		
		/**
		 * �ڶ������ԣ������������ǿ��Ըı��
		 */
		System.out.println("\nTest2:");
		Employee e=new Employee("Test2",70000);
		System.out.println("Test2's salary is "+e.getsalary());
		test2(e);
		System.out.println("Test2's salary is "+e.getsalary());
	
		/**
		 * ������ʵ�飺ͨ��swap֤����ʵJava�Ĵ��ξ��ǡ�ֵ���Ρ�
		 * �������;�ֱ��copy
		 * ������Ǵ�����
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