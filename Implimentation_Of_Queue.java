import java.util.*;
 class Node {
	int val;
	Node next;
	Node(int val) {
	this.val=val;
	}
}

class Queue {
	int size=0;
	Node head;
	Node tail;
	void add(int val) {
		Node newNode=new Node(val);
		if(size==0)  head=tail=newNode;
		else{
		    tail.next=newNode ;
		    tail=newNode;
		}
		size++;
	}
	int  peek(){
	    if(head==null){ System.out.println("Queue is empty"); return -1;}
	    return head.val;
	}
	
	int size(){
	    return size;
	}
	int  remove(){
	     if(head==null) {
	         System.out.println("Queue is empty"); return -1;
	     }
	     int front=head.val;
	     head=head.next;
	     size--;
	     return front;
	}
	
	void show(){
	    Node temp = head;
	    while(temp!=null){
	        System.out.print(temp.val+" ");
	        temp=temp.next;
	    }
	    System.out.println();
	}
}
class Queue{
    int[] arr;
    int f=0; 
    int r=0;
    int size=0;
    Queue(){
        arr=new int[5];
    }
    void add(int val){
        if(size==arr.length) {
            System.out.println("Queue is Full");
            return;
        }
        arr[r++]=val;
        size++;
        if(r==arr.length) r=0;
    }
    
    int remove(){
        if(size==0){
            System.out.println("Queue is empty");
            return -1;
        }
       int  front=arr[f];
       f++;
       if(f==arr.length) f=0;
       size--;
       return front;
    }
    int peek(){
        if(size==0){
            System.out.println("Queue is empty");
            return -1;
        }
        return  arr[f];
    }
    void show(){
         if(size==0){
            System.out.println("Queue is empty");
            return ;
        }
        if(f<r){
            for(int i=f; i<r; i++){
            System.out.print(arr[i]+" ");    
            }
            System.out.println();
        }
        
        else{
            
            for(int i=f; i<arr.length; i++){
            System.out.print(arr[i]+" ");    
            }
            for(int i =0; i<r; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
public class Main
{
	static void print(Queue<Integer> q) {
		int n=q.size();
		for(int i=0; i<n; i++) {
			System.out.print(q.peek()+" ");
			q.add(q.remove());
		}
	}
	static void addAtindx(Queue<Integer> q, int idx,int val) {
		int n=q.size();
		for(int i=0; i<idx; i++) {
			q.add(q.remove());
		}
		q.add(val);
		for(int i=0; i<n-idx; i++) {
			q.add(q.remove());
		}
	}
	static void removeval(Queue<Integer> q,int idx) {
		int n=q.size();
		for(int i=0; i<idx; i++) {
			q.add(q.remove());
		}
		q.remove();
		n-=1;
		for(int i=0; i<n-idx; i++) {
			q.add(q.remove());
		}
	}
	static void reversek(Queue<Integer> q,int k) {
		int n=q.size();
		Stack<Integer> st =new Stack<>();
		for(int i=0; i<k; i++) {
			st.push(q.remove());
		}
		while(st.size()>0) q.add(st.pop());

		for(int i=0; i<n-k; i++) {
			q.add(q.remove());
		}
	}

	public static void main(String[] args) {
	    Queue q =new Queue();
	   
	}
}
