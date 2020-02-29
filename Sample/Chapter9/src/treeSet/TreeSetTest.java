package treeSet;

import java.util.*;

public class TreeSetTest {
	public static void main(String[] args) {
		SortedSet<Item> parts=new TreeSet<Item>();
		
		parts.add(new Item("Dman",6));
		parts.add(new Item("Bman",3));
		parts.add(new Item("Cman",1));
		parts.add(new Item("Bman",2));
		parts.add(new Item("Aman",6));
		//输出parts看看是否按顺序
		System.out.println(parts);
		
		
		//NavigableSet扩展于SortedSet，通过使用一个定制的比较器来按照描述信息排序
		NavigableSet<Item> sortByDescription=new TreeSet<> (
				Comparator.comparing(Item::getDescription));
		sortByDescription.addAll(parts);
		//输出parts和sortByDescription比较一下
		System.out.println(sortByDescription);
	}
}
