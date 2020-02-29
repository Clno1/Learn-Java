package treeSet;

import java.util.*;

public class Item implements Comparable<Item>{
	private String description;
	private int partNumber;
	
	public Item(String aDescription,int aPartNumber) {
		description=aDescription;
		partNumber=aPartNumber;
	}
	
	public String getDescription() {
		return this.description;
	}
	public String toString() {
		return "[description="+this.description+",partNumber="+this.partNumber+"]";
	}
	
	public boolean equals(Object other) {
		if (this==other) return true;
		if (other==null) return false;
		if (this.getClass()!=other.getClass()) return false;
		Item aItem=(Item)other;
		return Objects.equals(this.description, aItem.description) && this.partNumber==aItem.partNumber;
	}
	
	//继承了comparable接口必须实现compareTO方法
	//比较的第一关键字是编号num，第二关键字是描述disc
	public int compareTo(Item other) {
		int diff=Integer.compare(this.partNumber, other.partNumber);
		return diff!=0 ? diff : this.description.compareTo(other.description);
	}
}
