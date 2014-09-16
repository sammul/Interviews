package qsort;

public class QuickSort {
	public static void main(String[] args){
		int[] A = {4,5,6,8,2,3,0,10,0};
		qsort(A,0,A.length-1);
	}
	public static int partition(int[] A, int left, int right){
		if(left==right)
			return left;
		//use the left element as the pivot
		//firstly swap left ele and right ele
		swap(A,left,right);
		int i=left, j=right-1;
		while(i<=j){
			if(A[i]<=A[right]){
				i++;
			}
			else{
				swap(A,i,j);
				j--;
			}
		}
		swap(A,i,right);
		return i;
		
	}
	public static void qsort(int[] A, int left, int right){
		if(left>=right)
			return;
		int p = partition(A,left,right);
		qsort(A,left,p-1);
		qsort(A,p+1,right);
	}
	public static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
