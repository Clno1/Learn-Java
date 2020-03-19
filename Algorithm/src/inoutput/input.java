package inoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class input {
	public static void main(String[] args) throws IOException {
		//test1();
		test2();
		test3();
	}
	
	public static void test1() throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String st1=br.readLine();
		
		String[] st2=br.readLine().split(" ");
		
		System.out.println(st1);
		
		ArrayList<Integer> rd=new ArrayList<>();
		for (int i=0;i<st2.length;i++)
			rd.add(Integer.parseInt(st2[i]));
		
		for (Integer a:rd)  System.out.printf("%d ",a);
		System.out.println();
	}
	
	public static void test2() {
		System.out.println(Integer.parseInt("123"));
		System.out.println(String.valueOf(123));
	}
	
	public static void test3() {
		Scanner scanner=new Scanner(System.in);
		int rd=scanner.nextInt();
		System.out.println(rd);
	}
}
