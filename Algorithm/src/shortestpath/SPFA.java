package shortestpath;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SPFA {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] str=reader.readLine().split(" ");
		int n=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		int s=Integer.parseInt(str[2]);
		
		Graph2 G=new Graph2(n,m,s);
		for (int i=1;i<=m;i++) {
			str=reader.readLine().split(" ");
			int x=Integer.parseInt(str[0]);
			int y=Integer.parseInt(str[1]);
			int z=Integer.parseInt(str[2]);
			G.add_edge(x, y, z);
		}
		
		G.SPFA();
	}
}

class Graph2
{
	public int n,m,s;
	public int cnt=1;
	public int[] head,nxt,to,len;
	
	public Graph2(int n,int m,int s) {
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
	public void SPFA() {
		Queue<Integer> q=new LinkedList<>();
		boolean[] inq=new boolean[n+10];
		int[] dis=new int[n+10];
		for (int i=1;i<=n;i++) {
			dis[i]=INF; inq[i]=false;
		}
		dis[this.s]=0;
		inq[this.s]=true;
		q.add(this.s);
		while (!q.isEmpty()) {
			int x=q.poll(); 
			for (int i=this.head[x];i>0;i=this.nxt[i]) {
				int y=this.to[i]; 
				if (dis[x]+this.len[i]<dis[y]) {
					dis[y]=dis[x]+this.len[i];
					if (!inq[y]) { q.add(y); inq[y]=true; }
				}
			}
			inq[x]=false;
		}
		
		for (int i=1;i<=n;i++)
			System.out.printf("%d ",dis[i]==INF ? ((1<<31)-1) : dis[i]);
	}
}
