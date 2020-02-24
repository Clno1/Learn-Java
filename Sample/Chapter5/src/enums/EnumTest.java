package enums;

import java.util.*;

public class EnumTest {
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
		String input=in.next().toUpperCase();
		Size size=Enum.valueOf(Size.class, input);
		System.out.println("size="+size);
		System.out.println("abbr="+size.getabbr());
	}
}

enum Size
{
	SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
	
	private String abbr;
	
	private Size(String abbr) {
		this.abbr=abbr;
	}
	public String getabbr() {
		return this.abbr;
	}
}
