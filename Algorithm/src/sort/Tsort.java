package sort;

public class Tsort {
	public static void main(String[] args) {
		int minInteger=min(new Integer[] {3,1,2,4});
		double minDouble=min(new Double[] {0.6,13.4,0.5,6.6});
		//String minstr=min(new String[] {"aca","15","sd5"});
		System.out.println(minInteger+" "+minDouble);
	}

	private static <T extends Number & Comparable<? super T> > T min(T[] values) {
		if (values==null || values.length==0) return null;
		T min=values[0];
		for (int i=1;i<values.length;i++)
			if (min.compareTo(values[i])>0) min=values[i];
		return min;
	}
	
}