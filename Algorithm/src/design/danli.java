package design;

public class danli {
	public static void main(String[] args) {
		
	}
}

class ehan {
	private ehan() {
		
	}
	
	private static ehan danli=new ehan();
	
	public ehan get() {
		return danli;
	}
}

class lanhan {
	private lanhan() {}
	
	private static lanhan danli=null;
	
	public lanhan get() {
		if (danli==null) danli=new lanhan();
		return danli;
	}
}