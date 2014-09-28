public class maxProductArray {
    public int maxProduct(int[] A) {
        int max = 1, min = 1, res = Integer.MIN_VALUE;
        for(int i=A.length-1; i>=0; i--){
            int nmax = Math.max(Math.max(A[i]*max,A[i]*min),A[i]);
            res = Math.max(res,nmax);
            int nmin = Math.min(Math.min(A[i]*max,A[i]*min),A[i]);
            max = nmax;
            min = nmin;
        }
        return res;
    }
}