package abstractClasses;

/**
 *�̳��Գ�����Person
 */
public class Student extends Person {
	private String major;
	
	public Student(String name,String major) {
		super(name);
		this.major=major;
	}
	
	public String getDescription() {	//����ʵ�ֳ����෽��getDescription
		//return this.name+"is a student,major is "+this.major;
		return super.getname()+"is a student,major is "+this.major;
	}
}
