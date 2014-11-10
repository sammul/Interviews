import java.util.ArrayList;

public class KClosest{
	public ArrayList<Integer> kclosest(int[] arr, int k, int target){
		if(arr==null || arr.length==0)
			return null;
		ArrayList<Integer> res = new ArrayList<Integer>();
		int start = 0, end = arr.length-1;
		while(start < end-1){
			int mid = (start+end)/2;
			if(arr[mid] < target)
				start = mid;
			else
				end = mid;
		}
		int i=start-1, j=start+1, count = 1;
		res.add(arr[start]);
		while(count<k){
			if(i<0)
				res.add(arr[j++]);
			else if(j>=arr.length)
				res.add(arr[i--]);
			else if(Math.abs(arr[i]-target) < Math.abs(arr[j]-target))
				res.add(arr[i--]);
			else
				res.add(arr[j++]);
			count++;
		}
		return res;
	}
	public static void main(String[] args){
		int[] arr = {1,2,5,6,7,8,9,20,23};
		int target = 14, k = 3;
		KClosest r = new KClosest();
		ArrayList<Integer> p = r.kclosest(arr, k, target);
		for(int i: p)
			System.out.println(i);
	}
}