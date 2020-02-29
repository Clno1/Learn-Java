package map;

import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		Map<String,Employee> staff=new HashMap<>();
		staff.put("144-25-5464",new Employee("Aman"));
		staff.put("567-24-2546",new Employee("Hman"));
		staff.put("157-62-7935",new Employee("Gman"));
		staff.put("456-62-5527",new Employee("Fman"));
		
		System.out.println(staff);
		
		staff.remove("567-24-2546");
		
		System.out.println(staff);
		
		//这个赋值会把之前的取代
		staff.put("456-62-5527",new Employee("FFman"));
		
		System.out.println(staff.get("456-62-5527"));
		System.out.println(staff);
		
		staff.forEach((k,v)->
			System.out.println("key="+k+",value="+v));
	}
}

class Employee
{
	private String name;
	public Employee(String name) {
		this.name=name;
	}
	
	public String getname() {
		return this.name;
	}
}
