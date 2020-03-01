package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mergesort {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] st=reader.readLine().split(" ");
		int n=Integer.parseInt(st[0]);
		myArray2 Arr=new myArray2(n);
		st=reader.readLine().split(" ");
		for (int i=1;i<=n;i++) Arr.a[i]=Integer.parseInt(st[i-1]);
		
		Arr.msort(1, n);
		
		for (int i=1;i<=n;i++) System.out.printf("%d ", Arr.a[i]);
	}
}

class myArray2 
{
	public int n;
	public int[] a;
	
	public myArray2(int n) {
		this.n=n;
		a=new int[n+10];
	}
	
	public void msort(int l,int r) {
		if (r-l<1) return;
		int mid=(l+r)/2;
		msort(l,mid); msort(mid+1,r);
		int idx=0,lidx=l,ridx=mid+1;
		int[] tmp=new int[r-l+5];
		while (lidx<=mid && ridx<=r) {
			if (ridx>r || (lidx<=mid && ridx<=r && this.a[lidx]<=this.a[ridx])) tmp[++idx]=this.a[lidx++];
			else tmp[++idx]=this.a[ridx++];
		}
		while (lidx<=mid) tmp[++idx]=this.a[lidx++];
		while (ridx<=r) tmp[++idx]=this.a[ridx++];
		
		for (int i=l;i<=r;i++) this.a[i]=tmp[i-l+1];
	}
}
