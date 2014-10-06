public class MaxWaterContainer{
    public int maxArea(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int max = 0, i=0, j=height.length-1;
        //greedy algorithm.
        while(i<j){
            max = Math.max(Math.min(height[i],height[j])*(j-i),max);
            if(height[i]>height[j])
                j--;
            else
                i++;
        }
        return max;
    }
}