package equals;

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
	
	public boolean equals(Object other) {
		//首先调用父类的equals方法比较
		if (!super.equals(other)) return false;
		//接下来再强制类型转换来比较新增的域
		Manager m=(Manager)other;
		return bonus==m.bonus;
	}
	
	//先调用父类的hashCode
	public int hashCode() {
		return super.hashCode()+17*new Double(bonus).hashCode();
	}
	
	//先调用父类的toString
	public String toString() {
		return super.toString()+"[bonus="+bonus+"]";
	}
}
