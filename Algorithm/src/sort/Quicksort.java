package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quicksort {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] st=reader.readLine().split(" ");
		int n=Integer.parseInt(st[0]);
		myArray Arr=new myArray(n);
		st=reader.readLine().split(" ");
		for (int i=1;i<=n;i++) Arr.a[i]=Integer.parseInt(st[i-1]);
		
		Arr.qsort(1, n);
		
		for (int i=1;i<=n;i++) System.out.printf("%d ", Arr.a[i]);
	}
}

class myArray 
{
	public int n;
	public int[] a;
	
	public myArray(int n) {
		this.n=n;
		a=new int[n+10];
	}
	
	public void qsort(int l,int r) {
		if (r-l<1) return;
		int std=this.a[r];
		int idx=l;
		
		for (int i=l;i<=r;i++) 
			if (this.a[i]<std) {
				int t=this.a[i]; this.a[i]=this.a[idx]; this.a[idx]=t;
				idx++;
			}
	
		int t=this.a[idx]; this.a[idx]=this.a[r]; this.a[r]=t;
		qsort(l,idx-1);
		qsort(idx+1,r);
	}
}
