package abstractClasses;

/**
 * ������
 */
public abstract class Person {
	public abstract String getDescription();	//���󷽷�
	private String name;
	
	public Person(String name) {
		this.name=name;
	}
	
	public String getname() {
		return this.name;
	}
}
