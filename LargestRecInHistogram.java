public class LargestRecInHistogram {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        for(int i=0; i<=height.length;){
            int curh = (i==height.length) ? -1 : height[i];
            if(s.empty() || curh>height[s.peek()]){
                s.push(i);
                i++;
            }
            else{
                int t = s.pop();
                int width = s.empty() ? i : i-s.peek()-1;
                max = Math.max(max,width*height[t]);
            }
        }
        return max;
    }
}
