public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if(A==null||A.length==0)
            return 1;
        int i=0;
        while(i<A.length){
            if(A[i]<=0 || A[i]>A.length || A[A[i]-1]==A[i]){
                i++;
            }
            //swap
            else{
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }
        
        for(i=0; i<A.length; i++){
            if(A[i]!=i+1)
                return i+1;
        }
        return A.length+1;
    }
}