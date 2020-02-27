package PairTest;

import javax.util;

public class pair1 {
	public static void main(String[] args) {
		//System.out.println("Hello");
		String[] words= {"Cman","Aman","Dman","Bman"};
		Pair<String,String> ans=Arraylg.minmax(words);
		System.out.println("Min is "+ans.getfirst());
		System.out.println("Min is "+ans.getsecond());
	}
}

class Arraylg
{
	public static Pair<String,String> minmax(String[] a) {
		if (a==null || a.length==0) return null;
		String min=a[0];
		String max=a[0];
		for (int i=1;i<a.length;i++) {
			if (min.compareTo(a[i])>0) min=a[i];
			if (max.compareTo(a[i])<0) max=a[i];
		}
		return new Pair<String,String>(min,max);
	}
}