public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        int lb = search(A,target,true);
        int ub = search(A,target,false);
        int[] nA = new int[2];
        nA[0] = lb;
        nA[1] = ub;
        return nA;
    }
    public int search(int[] A, int target, boolean isLeft){
        int left = 0, right = A.length-1;
        while(left<right){
            if(isLeft){
                int mid = (left+right)/2;
                if(A[mid]<target)
                    left=mid+1;
                else
                    right=mid;
            }
            else{
                int mid = (left+right)%2==0 ? (left+right)/2 : (left+right)/2+1;
                if(A[mid]<=target)
                    left=mid;
                else
                    right=mid-1;
            }
        }
        return A[left]==target ? left : -1;
    }
    
    
    public int[] searchRangeN(int[] A, int target) {
        int left = searchLeft(A,target);
        int right = searchRight(A,target);
        int[] res = {left,right};
        return res;
    }
    public int searchRight(int[] A, int target){
        int start=0, end = A.length-1;
        while(start<end){
            int mid = (start+end)/2+(start+end)%2;
            if(A[mid]>target)
                end=mid-1;
            else
                start = mid;
        }
        return A[start]==target ? start : -1;
    }
    public int searchLeft(int[] A, int target){
        int start = 0, end = A.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(A[mid]<target)
                start = mid+1;
            else
                end = mid;
        }
        return A[start]==target ? start : -1;
    }
}
