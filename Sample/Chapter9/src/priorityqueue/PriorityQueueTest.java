package priorityqueue;

import java.util.*;
import java.time.*;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<LocalDate> pq=new PriorityQueue<>();
		pq.add(LocalDate.of(1906, 12, 9));
		pq.add(LocalDate.of(1815, 12, 10));
		pq.add(LocalDate.of(2020, 1, 20));
		pq.add(LocalDate.of(1999, 4, 5));
		pq.add(LocalDate.of(1667, 8, 24));
		
		//迭代并不有序
		System.out.println("Iterating over elements:");
		
		for (LocalDate date:pq) System.out.println(date);
		
		//取队头是有序
		System.out.println("Removing elements:");
		
		while (!pq.isEmpty()) System.out.println(pq.remove());
	}
}
