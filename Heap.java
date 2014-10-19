//implement MaxHeap

public class Heap{
	int size;
	int capacity;
	int[] heap;
	
	Heap(int mcapa){
		this.size = 0;
		this.capacity = mcapa;
		this.heap = new int[mcapa];
	}
	
	int peek(){
		return size==0 ? -1 : heap[0];
	}
	
	void offer(int v){
		if(size==capacity){
			if(v>=heap[0])
				return;
			heap[0] = v;
			shiftDown(0);
		}
		else{
			heap[size] = v;
			shiftUp(size);
			size++;
		}
	}
	
	int poll(){
		if(size>0){
			int res=heap[0];
			heap[0] = heap[size-1];
			shiftDown(0);
			size--;
			return res;
		}
		else
			return Integer.MIN_VALUE;
	}
	
	void swap(int p1, int p2){
		int tmp = heap[p1];
		heap[p1] = heap[p2];
		heap[p2] = tmp;
	}
	
	int leftChild(int p){
		return p*2+1;
	}
	
	int rightChild(int p){
		return p*2+2;
	}
	
	int parent(int p){
		return (p-1)/2;
	}
	
	int getV(int p){
		if(p<size)
			return heap[p];
		else
			return Integer.MIN_VALUE;
	}
	void shiftUp(int p){
		while(p>0 && heap[p]>heap[parent(p)]){
			swap(p,parent(p));
			p = parent(p);
		}
	}
	void shiftDown(int p){
		if(2*p+1>=size||heap[p]>Math.max(heap[leftChild(p)],heap[rightChild(p)]))
			return;
		if(2*p+2<size){
			if(heap[leftChild(p)]>heap[rightChild(p)]){
				swap(p,leftChild(p));
				shiftDown(leftChild(p));
			}
			else{
				swap(p,rightChild(p));
				shiftDown(rightChild(p));
			}
		}
		else{
			swap(p,leftChild(p));
			shiftDown(leftChild(p));
		}
	}
	
	public static void main(String[] args){
		Heap heap = new Heap(5);
		heap.offer(5);
		heap.offer(1);
		heap.offer(2);
		heap.offer(20);
		heap.offer(10);
		heap.offer(7);
		heap.poll();
		heap.poll();
		heap.offer(9);
	}
}