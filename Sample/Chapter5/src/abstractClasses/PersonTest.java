package abstractClasses;

public class PersonTest {
	public static void main(String[] args) {
		Person[] people=new Person[2];
		
		people[0]=new Employee("Aemployee",10000,2020,1,1);
		people[1]=new Student("Astudent","ComputerScience");
		
		for (Person e:people) {
			System.out.println(e.getDescription());
		}
	}
}
