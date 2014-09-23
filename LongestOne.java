public class LongestOne{
	public static void main(String []args){
		int[] A = {0,0,0,0,0,1,1,1,0,1,1,1,1,1,0,0,0,1,0,1};
		System.out.println(longest(A));
	}
    public static int longest(int[] A){
		int count = 0, lmax = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++){
			if(A[i]==1)
				count++;
			else{
				lmax = Math.max(lmax,count);
    			count=0;
			}
		}
        lmax = Math.max(lmax,count);
		return lmax;
	}
}