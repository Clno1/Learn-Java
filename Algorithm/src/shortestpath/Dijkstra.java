package shortestpath;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dijkstra {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str=reader.readLine().split(" ");
		int n=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		int s=Integer.parseInt(str[2]);
		
		Graph G=new Graph(n,m,s);
		for (int i=1;i<=m;i++) {
			str=reader.readLine().split(" ");
			int x=Integer.parseInt(str[0]);
			int y=Integer.parseInt(str[1]);
			int z=Integer.parseInt(str[2]);
			G.add_edge(x, y, z);
		}
		
		G.dijkstra();
	}
}

class Graph
{
	public int n,m,s;
	public int cnt=1;
	public int[] head,nxt,to,len;
	
	public Graph(int n,int m,int s) {
		this.n=n; this.m=m; this.s=s;
		head=new int[n+10];
		nxt=new int[m+10];
		to=new int[m+10];
		len=new int[m+10];
		for (int i=1;i<=n;i++) head[i]=0;
	}
	
	public void add_edge(int x,int y,int z) {
		this.nxt[++this.cnt]=this.head[x]; this.to[this.cnt]=y; this.len[this.cnt]=z;
		this.head[x]=this.cnt;
	}
	
	final static int INF=0x3f3f3f3f;
	public void dijkstra() {
		boolean[] vis=new boolean[n+10];
		int[] dis=new int[n+10];
		for (int i=1;i<=n;i++) {
			vis[i]=false; dis[i]=INF;
		}
		PriorityQueue<node> pq=new PriorityQueue<node>();
		dis[this.s]=0;
		pq.add(new node(this.s,0));
		while (!pq.isEmpty()) {
			node now=pq.remove();
			if (vis[now.x]) continue;
			vis[now.x]=true;
			for (int i=this.head[now.x];i>0;i=this.nxt[i]) {
				if (dis[now.x]+this.len[i]<dis[this.to[i]]) {
					dis[this.to[i]]=dis[now.x]+this.len[i];
					pq.add(new node(this.to[i],dis[this.to[i]]));
				}
			}
		}
		
		for (int i=1;i<=n;i++) 
			System.out.printf("%d ", dis[i]==INF ? ((1<<31)-1) : dis[i]);
	}
}

class node implements Comparable<node>{
	public int x,y;
	public node(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int compareTo(node other) {
		return Integer.compare(this.y, other.y);
	}
}