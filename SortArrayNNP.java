public class SortArrayNNP{
    public static void main(String[] args){
    	int[] A = {0,0,0,5,0,-4,-5,1,2,3};
        sort(A);
        for(int a: A)
            System.out.println(a);
	}
	public static void sort(int[] A){
		int i=0, k=0, j=A.length-1;
		while(k<=j){
			if(A[k] > 0)
				swap(A,k,j--);
			else if(A[k]==0){
				k++;
			}
			else{
				swap(A,i++,k++);
			}
		}
	}
	public static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i]=A[j];
		A[j]=temp;
	}
}