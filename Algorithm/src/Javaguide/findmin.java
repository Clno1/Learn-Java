package Javaguide;

public class findmin {
	public static void main(String[] args) {
		//int[] array=new int[] {4,5,1,2,3};
		System.out.println(aArray.minNumberInRotateArray(new int[] {4,5,1,2,3}));
	}
}

class aArray {
	
    public static int minNumberInRotateArray(int [] array) {
        if (array.length==0) return 0;
        return solve(0,array.length-1,array);
    }
    
    public static int solve(int l,int r,int[] a) {
        if (l==r || a[l]<a[r]) return a[l];
        int m=(l+r)/2;
        return Math.min(solve(l,m,a),solve(m+1,r,a));
    }
}
