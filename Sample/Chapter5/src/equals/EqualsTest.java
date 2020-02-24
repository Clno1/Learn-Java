package equals;

public class EqualsTest {
	public static void main(String args[]) {
		Employee Aman=new Employee("Aman",8000,2020,1,20);
		Employee Bman=Aman;
		Employee Cman=new Employee("Bman",8000,2020,1,20);
		Employee Dman=new Employee("Aman",8000,2020,1,20);
		
		System.out.println("Aman==Bman? "+(Aman==Bman));
		System.out.println("Aman==Cman? "+(Aman==Cman));
		System.out.println("Aman==Dman? "+(Aman==Dman));
		
		System.out.println();
		System.out.println("Aman.equals(Bman)? "+Aman.equals(Bman));
		System.out.println("Aman.equals(Cman)? "+Aman.equals(Cman));
		System.out.println("Aman.equals(Dman)? "+Aman.equals(Dman));
		
		System.out.println();
		System.out.println("Aman's hashCode="+Aman.hashCode());
		System.out.println("Bman's hashCode="+Bman.hashCode());
		System.out.println("Cman's hashCode="+Cman.hashCode());
		System.out.println("Dman's hashCode="+Dman.hashCode());
		
		System.out.println();
		System.out.println(Aman.toString());
		System.out.println(Bman.toString());
		System.out.println(Cman.toString());
		System.out.println(Dman.toString());
	}
}
