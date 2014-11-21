public class OneEditAway{
	/*Detemine whether two strings are one edit away*/
	public boolean oneEditAway(String s1, String s2){
		if(s1==null||s2==null)
			return false;
		if(s1.length()==s2.length()){
			int count = 0;
			for(int i=0; i<s1.length(); i++){
				if(s1.charAt(i)!=s2.charAt(i)){
					count++;
					if(count>1)
						return false;
				}
			}
		}
		else{
			if(s1.length()<s2.length()){
				String tmp = s1;
				s1 = s2;
				s2 = tmp;
			}
			if(s1.length()-s2.length()>1)
				return false;
			int count = 0;
			for(int i=0, j=0; j<s2.length(); i++,j++){
				if(s1.charAt(i)!=s2.charAt(j)){
					count++;
					j--;
					if(count>1)
						return false;
				}
			}
		}
		return true;
	}
}
