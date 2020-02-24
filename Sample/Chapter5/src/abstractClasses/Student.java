package abstractClasses;

/**
 *继承自抽象类Person
 */
public class Student extends Person {
	private String major;
	
	public Student(String name,String major) {
		super(name);
		this.major=major;
	}
	
	public String getDescription() {	//必须实现抽象类方法getDescription
		//return this.name+"is a student,major is "+this.major;
		return super.getname()+"is a student,major is "+this.major;
	}
}
