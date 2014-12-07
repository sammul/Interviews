/*

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

*/

public class PeakElement {
    public int findPeakElement(int[] num) {
        for(int i=0; i<num.length; i++){
            boolean t = true;
            if(i>0)
                t &= num[i]>num[i-1];
            if(i<num.length-1)
                t &= num[i]>num[i+1];
            if(t)
                return i;
        }
        return -1;
    }
}
