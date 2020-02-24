package inheritance;

public class Manager extends Employee {
	private double bonus;	//����Ľ���
	
	public Manager(String name,double salary,int year,int month,int day) {
		super(name,salary,year,month,day);	//��super���ø���Ĺ��캯��
		bonus=0;
	}
	
	public double getsalary() {	//��д���෽��
		double basesalary=super.getsalary();	//super���ø��෽��
		return basesalary+this.bonus;
	}
	
	public void setbonus(double bonus) {
		this.bonus=bonus;
	}
}
