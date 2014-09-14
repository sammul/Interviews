public class CountingInversions{
	public static void main(String[] args){
		int[] A = {5,4,3,2};
		System.out.println(count(A));
	}
	public static int count(int[] A){
		return countP(A,0,A.length-1);
	}
	public static int countP(int[] A, int s, int e){
		if(s==e)
			return 0;
		int m = (s+e)/2;
		int l = countP(A,s,m);
		int r = countP(A,m+1,e);
		int[] B = new int[e-s+1];
		int count=0, i=s, j=m+1, k=0;
		while(i<m+1 && j<=e){
			if(A[i] > A[j]){
				B[k] = A[j];
				count+=m-i+1;
				j++;
			}
			else{
				B[k] = A[i];
				i++;
			}
			k++;
		}
		while(i<m+1){
			B[k] = A[i];
			i++;
			k++;
		}
		while(j<=e){
			B[k] = A[j];
			j++;
			k++;
		}
		for(i=s,j=0; i<=e; i++,j++){
			A[i] = B[j];
		}
		return l+r+count;
	}
}