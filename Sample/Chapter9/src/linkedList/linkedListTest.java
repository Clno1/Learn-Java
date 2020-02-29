package linkedList;

import java.util.*;

public class linkedListTest {
	public static void main(String[] args) {
		List<String> a=new LinkedList<String>();
		a.add("Aman"); a.add("Cman"); a.add("Dman"); a.add("Bman");
		
		List<String> b=new LinkedList<String>();
		b.add("Awom"); b.add("Cwom"); b.add("Dwom"); b.add("Bwom");
		
		ListIterator<String> aIter=a.listIterator();
		Iterator<String> bIter=b.iterator();
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		//把b合并到a，交叉合并
		while (bIter.hasNext()) {
			if (aIter.hasNext()) aIter.next();
			aIter.add(bIter.next());
		}
		System.out.println(a.toString());
		
		//把b的偶数位去掉
		bIter=b.listIterator();
		while (bIter.hasNext()) {
			if (bIter.hasNext()) bIter.next(); else break;
			if (bIter.hasNext()) bIter.next(); else break;
			bIter.remove();
		}
		System.out.println(b.toString());
		
		//把a全部removeAll所有b的元素
		a.removeAll(b);
		System.out.println(a.toString());
	}
}
