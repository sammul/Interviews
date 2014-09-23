import java.util.ArrayList;

public class JobServer{
	/*Return all possible assignments for jobs to servers in order that
	no adjacent jobs are assigned to the same server*/
	public static void main(String[] args){
		jobServer(5,4);
	}
	public static ArrayList<int[]> jobServer(int jn, int sn){
		ArrayList<int[]> res = new ArrayList<int[]>();
		int[] cur = new int[jn];
		findSolution(jn, sn, 0, res, cur);
		return res;
	}
	public static void findSolution(int jn, int sn, int jindex, ArrayList<int[]> res, int[] cur){
		if(jindex==jn){
			int[] nr = cur.clone();
			res.add(nr);
			return;
		}
		for(int i=0; i<sn; i++){
			if(jindex > 0 && cur[jindex-1]==i)
				continue;
			cur[jindex] = i;
			findSolution(jn,sn,jindex+1,res,cur);
		}
	}
}