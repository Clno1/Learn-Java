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
		//���parts�����Ƿ�˳��
		System.out.println(parts);
		
		
		//NavigableSet��չ��SortedSet��ͨ��ʹ��һ�����ƵıȽ���������������Ϣ����
		NavigableSet<Item> sortByDescription=new TreeSet<> (
				Comparator.comparing(Item::getDescription));
		sortByDescription.addAll(parts);
		//���parts��sortByDescription�Ƚ�һ��
		System.out.println(sortByDescription);
	}
}
