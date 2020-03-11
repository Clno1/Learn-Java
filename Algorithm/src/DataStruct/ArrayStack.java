package DataStruct;

import java.util.Arrays;

public class ArrayStack {
	public static void main(String[] args) {
		MyStack myStack = new MyStack(3);
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);
		myStack.push(7);
		myStack.push(8);
		System.out.println(myStack.peek());//8
		System.out.println(myStack.size());//8
		for (int i = 0; i < 8; i++) {
		    System.out.println(myStack.pop());
		}
		System.out.println(myStack.isEmpty());//true
		myStack.pop();//报错：java.lang.IllegalArgumentException: Stack is empty.
	}
}

class MyStack {
	private int[] storage;	//栈的存储数据
	private int capacity;	//栈的容量
	private int count;	//栈中元素数量
	private static final int GROW_FACTOR=2;		//扩容因子，每次满了容量增大的倍数
	
	//无参构造器
	public MyStack() {
		this.capacity=8;
		this.storage=new int[8];
		this.count=0;
	}
	
	//有参数的构造器
	public MyStack(int initcap) {
		this.capacity=initcap;
		this.storage=new int[initcap];
		this.count=0;
	}
	
	//入队
	public void push(int value) {
		if (this.count==this.capacity) ensure_capacity();
		this.storage[this.count++]=value;
	}
	
	//扩容
	private void ensure_capacity() {
		int newCapacity=this.capacity*this.GROW_FACTOR;
		this.storage=Arrays.copyOf(this.storage, newCapacity);
		this.capacity=newCapacity;
	}
	
	//出栈并返回栈顶元素
	public int pop() {
		if (this.count==0) throw new IllegalArgumentException("Stack is empty.");
		return this.storage[--this.count];
	}
	
	//返回栈顶元素但不出栈
	public int peek() {
		if (this.count==0) throw new IllegalArgumentException("Stack is empty.");
		return this.storage[this.count-1];		
	}
	
	//判断栈是否为空
	public boolean isEmpty() {
		return (this.count==0);
	}
	
	//返回栈内元素个数
	public int size() {
		return this.count;
	}
}
