public class MaxInterval{
	/* Input: Integer Array, window size k
	 * return the maximum of a window
	*/
	int findK(int[] arr, int k){
		if(arr==null || arr.length==0 || k<=0 || k>arr.length)
			return Integer.MIN_VALUE;
		int sum = 0, i=0;
		while(i<k)
			sum += arr[i++];
		int max = sum,j=0;
		while(i<arr.length){
			sum = sum+arr[i++]-arr[j++];
			max = Math.max(max,sum);
		}
		return max;
	}

	/*
 	 * Input: Integer array, index start, index end
 	 * return the maximum of a window between start and end
	*/
	int findKIndex(int[] arr, int k, int s, int e){
		if(e<s || arr==null || arr.length==0 || k<=0 || k>arr.length)
			return Integer.MIN_VALUE;
		int sum = 0, i=s;
		while(i<s+k)
			sum += arr[i++];
		int max = sum,j=s;
		while(i<e){
			sum = sum+arr[i++]-arr[j++];
			max = Math.max(max,sum);
		}
		return max;
	}	
	/*Input: Integer array, window size k, 
	 *Return the maximum of 2 intervals covering k elements
	*/

	int findK2(int[] arr, int k){
		if(arr==null || arr.length==0 || k<=0 || k>arr.length)
			return Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=1; i<k; i++){
			for(int j=i; j<=arr.length-(k-i); j++){
				max = Math.max(max,findKIndex(arr,i,0,j)+findKIndex(arr,k-i,j,arr.length));
			}
		}
		return max;
	}
}