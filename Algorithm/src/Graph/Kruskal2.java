package Graph;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kruskal2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str[] = reader.readLine().split(" ");
		int n=Integer.parseInt(str[0]),m=Integer.parseInt(str[1]);
		myMST2 tree=new myMST2(n,m);
		
		for (int i=1;i<=tree.m;i++) {
			str=reader.readLine().split(" ");
			tree.edges[i]=new edge2(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
		}
		
		int ans=tree.kruskal();
		System.out.println(ans==0 ? "orz" : ans);
	}
}

class myMST2
{
	final static int M=200000+10;
	public int n,m;
	public int[] fa;
	public edge2[] edges;
	
	public myMST2(int n,int m) {
		this.n=n;
		this.m=m;
		fa=new int[n+1];
		edges=new edge2[m+1];
		for (int i=1;i<=n;i++) this.fa[i]=i;
	}
	
	public int getfa(int x) {
		if (x==fa[x]) return x;
		else return this.fa[x]=getfa(this.fa[x]);
	}

	public int kruskal() {
		//在这里不用edge自带的CompareTo方法，自己实现Comparator接口的compare方法
//		Arrays.sort(this.edges,1,this.m+1,
//				new Comparator <edge2>() {
//					public int compare(edge2 t1,edge2 t2) {
//						return t1.z-t2.z;
//					}
//				});
		//这里使用lambda表达式代替
		Arrays.sort(this.edges,1,this.m+1,
					(t1,t2)->{ return t1.z-t2.z; }
				);
		
		int num=0,ret=0;
		for (int i=1;i<=m;i++) {
			int fx=this.getfa(this.edges[i].x);
			int fy=this.getfa(this.edges[i].y);
			if (fx==fy) continue;
			this.fa[fx]=this.fa[fy];
			num++; ret+=this.edges[i].z;
		}
		return num==n-1 ? ret : 0;
	}
}

class edge2 implements Comparable<edge2>
{
	public int x,y,z;
	
	public edge2(int x,int y,int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public int compareTo(edge2 other) {
		return Integer.compare(this.z, other.z);
	}
}