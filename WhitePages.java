import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WhitePages {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> canyon = new ArrayList<Integer>();
        while(s.hasNextInt()){
        	int p = s.nextInt();
        	if(p==1000)
        		break;
            canyon.add(p);
        }
        int cur = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        while(cur<canyon.size()-1){
            if(canyon.get(cur)==0){
                System.out.println("failure");
            	return;
            }
            int i=cur+1, max = 0, ns=0;
            for(;i<=cur+canyon.get(cur); i++){
                if(i==canyon.size()){
                	for(int a: res)
                		System.out.print(a+", ");
                	System.out.println("out");
                	return;
                }
                if(i+canyon.get(i) > max){
                    max = i+canyon.get(i);
                    ns = i;
                }
            }
            cur = ns;
            res.add(ns);
        }
        for(int a: res)
            System.out.print(a+", ");
        System.out.println("out");
        return;
    }
}