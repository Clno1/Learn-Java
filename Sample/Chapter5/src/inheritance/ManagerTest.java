package inheritance;

public class ManagerTest {
	public static void main(String args[]) {
		Manager boss=new Manager("Aboss",100000,2020,1,1);
		boss.setbonus(20000);
		
		Employee[] staff=new Employee[3];
		
		staff[0]=boss;
		staff[1]=new Employee("Aman",9000,2020,1,2);
		staff[2]=new Employee("Bman",8000,2020,1,2);
		
		for (Employee e:staff) {	//多态，不同对象通过employee调用同一方法
			System.out.println(e.getname()+"'s salary is "+e.getsalary());
		}
		
		for (Employee e:staff) e.raisesalary(10);
		
		System.out.println();
		for (Employee e:staff) {
			System.out.println(e.getname()+"'s salary is "+e.getsalary());
		}
	}
}
