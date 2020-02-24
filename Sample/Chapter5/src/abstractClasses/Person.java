package abstractClasses;

/**
 * 抽象类
 */
public abstract class Person {
	public abstract String getDescription();	//抽象方法
	private String name;
	
	public Person(String name) {
		this.name=name;
	}
	
	public String getname() {
		return this.name;
	}
}
