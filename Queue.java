import java.util.Stack;
public class Queue {
	private Stack<Integer> in;
	private Stack<Integer> out;
	Queue(){
		in = new Stack<Integer>();
		out = new Stack<Integer>();
	}
	void offer(int i){
		in.push(i);
	}
	int poll(){
		if(!out.empty())
			return out.pop();
		else{
			while(!in.empty()){
				out.push(in.pop());
			}
			if(out.empty())
				return Integer.MIN_VALUE;
			return out.pop();
		}
	}
    boolean empty(){
        return in.empty() && out.empty();
    }
    int size(){
        return in.size()+out.size();
    }
}
