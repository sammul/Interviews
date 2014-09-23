public class Largest1Square{
	public int largest(int[][] A){
		if(A.length < 1 || A[0].length < 1)
			return 0;
		int r = A.length, c = A[0].length;
		int[][] tmp = new int[r][c];
		for(int i=0; i<r; i++)
			tmp[i][0] = A[i][0];
		for(int i=0; i<c; i++)
			tmp[0][i] = A[0][i];
		for(int i=1; i<r; i++){
			for(int j=1; j<c; j++){
				if(A[i][j]==1)
					tmp[i][j] = 1+Math.min(Math.min(tmp[i-1][j-1],tmp[i][j-1]), tmp[i-1][j]);
				else
					tmp[i][j] = 0;
			}
		}
		int maxV=Integer.MIN_VALUE;;
		for(int i=1; i<r; i++){
			for(int j=1; j<c; j++){
				maxV = Math.max(maxV,tmp[i][j]);
			}
		}
		return maxV;
	}
}