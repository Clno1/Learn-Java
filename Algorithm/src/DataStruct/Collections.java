package DataStruct;

import java.util.*;

public class Collections {
	public static void main(String[] args) {
		int[] arr=new int[100];
		for (int i=0;i<10;i++) arr[i]=3;
		System.out.println(Arrays.binarySearch(arr,0,10, 3));
	
		HashMap<String,Integer> map=new HashMap<>();
		map.put("My", 11);
		map.put("You",22);
		map.put("His", 33);
		
		System.out.println(map.get("My"));
		System.out.println(map.get("OO"));
		
		map.put("33", 111);
		for (Map.Entry<String, Integer> entry:map.entrySet())
			System.out.println(entry.getKey()+" "+entry.getValue());
	}
}

class MyLink
{
	public int val;
	public MyLink left=null;
	public MyLink right=null;
	
	public MyLink(int val) {
			
	}
}