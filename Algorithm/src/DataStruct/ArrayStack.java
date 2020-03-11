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
		myStack.pop();//����java.lang.IllegalArgumentException: Stack is empty.
	}
}

class MyStack {
	private int[] storage;	//ջ�Ĵ洢����
	private int capacity;	//ջ������
	private int count;	//ջ��Ԫ������
	private static final int GROW_FACTOR=2;		//�������ӣ�ÿ��������������ı���
	
	//�޲ι�����
	public MyStack() {
		this.capacity=8;
		this.storage=new int[8];
		this.count=0;
	}
	
	//�в����Ĺ�����
	public MyStack(int initcap) {
		this.capacity=initcap;
		this.storage=new int[initcap];
		this.count=0;
	}
	
	//���
	public void push(int value) {
		if (this.count==this.capacity) ensure_capacity();
		this.storage[this.count++]=value;
	}
	
	//����
	private void ensure_capacity() {
		int newCapacity=this.capacity*this.GROW_FACTOR;
		this.storage=Arrays.copyOf(this.storage, newCapacity);
		this.capacity=newCapacity;
	}
	
	//��ջ������ջ��Ԫ��
	public int pop() {
		if (this.count==0) throw new IllegalArgumentException("Stack is empty.");
		return this.storage[--this.count];
	}
	
	//����ջ��Ԫ�ص�����ջ
	public int peek() {
		if (this.count==0) throw new IllegalArgumentException("Stack is empty.");
		return this.storage[this.count-1];		
	}
	
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return (this.count==0);
	}
	
	//����ջ��Ԫ�ظ���
	public int size() {
		return this.count;
	}
}
