package DataStruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LRU {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		HashSet<Integer> set=new HashSet<>();
		LinkedList<Integer> lk=new LinkedList<>();
		
		for (int i=1;i<=n;i++) {
			int m=Integer.parseInt(br.readLine());
			if (!set.contains(m)) {
				set.add(m);
				lk.addFirst(m);
			} else {
				lk.remove(lk.indexOf(m));
				lk.addFirst(m);
			}
			
			if (lk.size()>3) {
				set.remove(lk.getLast());
				lk.removeLast();
			}
			
			for (Integer num:lk) System.out.printf("%d ",num);
			System.out.println();
		}
	}
	
}
