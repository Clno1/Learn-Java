package inheritance;

public class Manager extends Employee {
	private double bonus;	//经理的奖金
	
	public Manager(String name,double salary,int year,int month,int day) {
		super(name,salary,year,month,day);	//用super调用父类的构造函数
		bonus=0;
	}
	
	public double getsalary() {	//重写父类方法
		double basesalary=super.getsalary();	//super调用父类方法
		return basesalary+this.bonus;
	}
	
	public void setbonus(double bonus) {
		this.bonus=bonus;
	}
}
