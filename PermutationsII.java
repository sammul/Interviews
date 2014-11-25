public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        per(res,num,0);
        return res;
    }
    public void per(ArrayList<ArrayList<Integer>> res, int[] num, int i){
        if(i==num.length){
            ArrayList<Integer> nres = new ArrayList<Integer>();
            for(int a: num)
                nres.add(a);
            res.add(nres);
            return;
        }
        for(int start = i; start<num.length; start++){
            swap(start,i,num);
            per(res, num, i+1);
            swap(start,i,num);
        }
    }
    public void swap(int i, int j, int[] num){
        int tmp = num[i];
        num[i]=num[j];
        num[j]=tmp;
    }
}
