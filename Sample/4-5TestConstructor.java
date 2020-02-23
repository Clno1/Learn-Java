import java.util.Random;

public class TestConstructor {
	public static void main(String args[]) {
		Employee[] staff=new Employee[3];
		
		staff[0]=new Employee("Aman",7000);
		staff[1]=new Employee(8000);
		staff[2]=new Employee();
		
		for (Employee e:staff)
			System.out.println(e.getname()+"'s id is "+e.getid()+", salary is "+e.getsalary());
	}
}

/**
 * ���캯������˳��
 * �� ��ʼ��Ĭ��ֵ
 * �� ��������ִ���ִ���������ʼ���/��
 * �� ִ�й�������õĹ�����
 * �� ���ִ�й��캯��
 */
class Employee
{
	private static int nextID;
	
	private int id;	//Ĭ�����ʼ��
	private String name="Noone";	//��ʾ���ʼ��
	private double salary=3000.0;	//��ʾ���ʼ��
	
	/**
	 * ��̬��ʼ��:���ھ�̬���ʼ��
	 */
	static{
		Random generator=new Random();
		nextID=generator.nextInt(10000);
	}
	/**
	 * �����ʼ�飺�ڹ��캯��ǰ����
	 */
	{
		id=nextID;
		nextID++;
	}
	
	/**
	 * ������ͬ�Ĺ��캯����������ͬ��
	 */
	public Employee(String aname,double asalary) {
		name=aname;
		salary=asalary;
	}
	public Employee(double asalary) {
		this("Employee #"+nextID,asalary);	//��this����Employee(aname,asalary)���캯��
	}
	public Employee() {	//Ĭ�Ϲ��캯��
		
	}
	
	public String getname() {
		return name;
	}
	public double getsalary() {
		return salary;
	}
	public int getid() {
		return id;
	}
}