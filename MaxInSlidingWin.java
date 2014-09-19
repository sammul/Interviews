import java.util.LinkedList;
import java.util.ArrayList;

public class MaxInSlidingWin{
	public static void main(String[] args){
		int[] A = {3,4,1,8,6,4,3,6,8};
		maxSlidingWindow(A,3);
	}
    public static ArrayList<Integer> maxSlidingWindow(int[] A, int size){
    	LinkedList<Integer> ll = new LinkedList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i=0; i<A.length; i++){
            if(i>=size){
                res.add(A[ll.getFirst()]);
                if(i-ll.getFirst()>=size)
                    ll.removeFirst();
            }
            while(ll.size()!=0&&A[ll.getLast()]<A[i]){
                ll.removeLast();
            }
            ll.add(i);
        }
        res.add(A[ll.getFirst()]);
        return res;
    }
}