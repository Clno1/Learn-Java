
public class StaticTest {
	public static void main(String args[]) {
		Employee staff[]=new Employee[3];
		
		staff[0]=new Employee("Aman",7000);
		staff[1]=new Employee("Bman",8000);
		staff[2]=new Employee("Cman",9000);
		
		for (Employee e:staff) {
			e.setid();
			System.out.println(e.getname()+"'s id is "+e.getid());
			System.out.println(e.getname()+"'s salary is "+e.getsalary());
		}
		
		int n=Employee.getnextID();
		System.out.println("nextID is "+n);
	}
}

class Employee
{
	private static int nextID=1;
	
	private String name;
	private double salary;
	private int id;
	
	public Employee(String aname,double asalary) {
		name=aname;
		salary=asalary;
		id=0;
	}
	
	/**
	 * ����public������private��������/�޸�Ȩ��
	 */
	public String getname() {
		return name;
	}
	public double getsalary() {
		return salary;
	}
	public int getid() {
		return id;
	}
	public void setid() {
		id=nextID;
		nextID++;
	}
	
	/**
	 * ���þ�̬���������ö��󼴿ɻ�� ��һ�������ID
	 */
	public static int getnextID() {
		return nextID;
	}
	
	/**
	 * �ڷ��ļ�������дmain���������ڵ�Ԫ����
	 * �˶δ���������StaticTestʱ�򲻻�����
	 */
	public static void main(String args[]) {
		Employee e=new Employee("UnitTest",10000);
		System.out.println(e.getname()+"'s salary is "+e.getsalary());
	}
}