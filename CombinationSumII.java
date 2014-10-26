public class CombinationSumII{
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if(num==null||num.length==0)
            return null;
        Arrays.sort(num);
        boolean[] used = new boolean[num.length];
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        combine(num,target,0,used,cur,res);
        return res;
    }
    public void combine(int[] num, int target, int step, boolean[] used, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res){
        if(target==0){
            res.add(cur);
            return;
        }
        if(target<0 || step==num.length) //important
            return;
        ArrayList<Integer> ncur = new ArrayList<Integer>(cur);
        combine(num,target,step+1,used,cur,res);
        if(step>0 && num[step]==num[step-1] && !used[step-1])
            return;
        ncur.add(num[step]);
        used[step]=true;
        combine(num,target-num[step],step+1,used,ncur,res);
        used[step]=false;
    }
}