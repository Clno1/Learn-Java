package design;

public class factory {
	
}

interface Anaimalfac {
	Anaimalfac creat();
}
class CatFoc implements Anaimalfac {
	@Override
	public Anaimalfac creat() {
		// TODO Auto-generated method stub
		return null;
	}
}
class DogFac implements Anaimalfac {

	@Override
	public Anaimalfac creat() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

abstract class Anaimal{
	
}
class Dog extends Anaimal{
	
}
class Cat extends Anaimal{
	
}


class easyfac {
	public static Dog createdog() {
		return new Dog();
	}
	public static Cat createcat() {
		return new Cat();
	}
	
	public static Anaimal gets() {
		return createcat();
	}
}