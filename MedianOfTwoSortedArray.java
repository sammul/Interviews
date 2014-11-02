public class MedianOfTwoSortedArray{
  public double findMedianSortedArrays(int A[], int B[]) {
    int l = A.length+B.length;
    if(l%2==0)
        return ((double)findKth(A,0,B,0,l/2)+(double)findKth(A,0,B,0,l/2+1))/2;
    else
        return (double)findKth(A,0,B,0,l/2+1);
  }
  public int findKth(int[] A, int sa, int[] B, int sb, int k){
    if(sa>=A.length)
        return B[sb+k-1];
    if(sb>=B.length)
        return A[sa+k-1];
    if(k==1)
        return Math.min(A[sa],B[sb]);
    int Akey = sa+k/2-1 >= A.length ? Integer.MAX_VALUE : A[sa+k/2-1];
    int Bkey = sb+k/2-1 >= B.length ? Integer.MAX_VALUE : B[sb+k/2-1];
    if(Akey > Bkey)
        return findKth(A,sa,B,sb+k/2,k-k/2);
    else
        return findKth(A,sa+k/2,B,sb,k-k/2);
  }
}
