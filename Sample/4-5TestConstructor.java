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
 * 构造函数运行顺序：
 * ① 初始化默认值
 * ② 按照类出现次序，执行所以域初始语句/块
 * ③ 执行构造其调用的构造器
 * ④ 最后执行构造函数
 */
class Employee
{
	private static int nextID;
	
	private int id;	//默认域初始化
	private String name="Noone";	//显示域初始化
	private double salary=3000.0;	//显示域初始化
	
	/**
	 * 静态初始块:用于静态域初始化
	 */
	static{
		Random generator=new Random();
		nextID=generator.nextInt(10000);
	}
	/**
	 * 对象初始块：在构造函数前运行
	 */
	{
		id=nextID;
		nextID++;
	}
	
	/**
	 * 三个不同的构造函数（参数不同）
	 */
	public Employee(String aname,double asalary) {
		name=aname;
		salary=asalary;
	}
	public Employee(double asalary) {
		this("Employee #"+nextID,asalary);	//用this调用Employee(aname,asalary)构造函数
	}
	public Employee() {	//默认构造函数
		
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