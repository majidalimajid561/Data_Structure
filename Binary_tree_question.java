import java.util.*;
class Node {
	int val;
	Node left;
	Node right;
	Node (int val) {
		this.val=val;
	}
}
class Pair {
	int level;
	Node node;
	Pair(Node node,int level) {
		this.level=level;
		this.node=node;
	}
}

public class Main
{
	static void orderWiseTraversal(Node root) {
		Queue<Pair> q =new LinkedList<>();
		// ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
		q.add(new Pair(root, 0));
		int Currlevel=0;
		while(q.size()>0) {
			Pair front=q.remove();
			if(front.level!=Currlevel) {
				System.out.println();
				Currlevel++;
			}
			System.out.print(front.node.val+" ");
			if(front.node.left!=null) q.add(new Pair(front.node.left, front.level+1));
			if(front.node.right!=null) q.add(new Pair(front.node.right, front.level+1));
		}
		System.out.println();
	}
	static ArrayList<ArrayList<Integer>> BFS(Node root) {
		Queue<Pair> q =new LinkedList<>();
		ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
		ArrayList<Integer> arr = new ArrayList<>();
		q.add(new Pair(root,0));
		int Currlevel=0;
		while(q.size()>0) {
			Pair front=q.remove();
			if(front.level!=Currlevel) {
// 			ArrayList<Integer> list =  new ArrayList<>();
// 			list.addAll(arr);
// 			ans.add(list);
				ans.add(new ArrayList<>(arr));
				arr.clear();
				Currlevel++;
			}
			arr.add(front.node.val);
			if(front.node.left!=null) q.add(new Pair(front.node.left, front.level+1));
			if(front.node.right!=null) q.add(new Pair(front.node.right, front.level+1));
		}
// 		ArrayList<Integer> list =  new ArrayList<>();
// 			list.addAll(arr);
// 			ans.add(list);
		ans.add(new ArrayList<>(arr));
		return ans;
	}
	static void info(Node root) {
		if(root==null) return;
		System.out.print(root.val+" ");
		info(root.left);
		info(root.right);
	}
	static int size(Node root) {
		if(root==null) {
			return 0;
		}
		return 1+size(root.left)+size(root.right);
	}

	static int sum(Node root) {
		if(root==null) {
			return 0;
		}
		return root.val+sum(root.left)+sum(root.right);
	}

	static int pro(Node root) {
		if(root==null) {
			return 1;
		}
		if(root.val>0)
			return root.val*pro(root.left)*pro(root.right);
		return 1;
	}
	static int level(Node root) {
		if(root==null) return 0;
		return 1+ Math.max(level(root.left),level(root.right));
	}
	static void kthLevel(Node root,int L,int k) {
		if(root==null) return;
		if(k==L) System.out.print(root.val+" ");
		kthLevel(root.left,L+1,k);
		kthLevel(root.right,L+1,k);
	}
	//line order traversal
	static void LOT(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(q.size()>0) {
			Node front = q.remove();
			System.out.print(front.val+" ");
			if(front.left!=null) q.add(front.left);
			if(front.right!=null) q.add(front.right);
		}
		System.out.println();
	}

	static ArrayList<ArrayList<Integer>> paths(Node root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> arr = new ArrayList<>();
		dsf(root,ans,arr);
		return ans;
	}
	
	static void dsf(Node root, ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> arr) {
		if(root==null) return;
		arr.add(root.val);
		if(root.left==null && root.right==null) {
			ArrayList<Integer> list =  new ArrayList<>();
			list.addAll(arr);
			ans.add(list);
		}
		dsf(root.left,ans,arr);
		dsf(root.right,ans,arr);
		arr.remove(arr.size()-1);

	}
	// root to leafs node lists
	static void help(Node root, ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> arr){
	    if(root==null) return;
	    arr.add(root.val);
	    if(root.left==null && root.right==null){
	        ans.add(new ArrayList<>(arr));
	    }
	    help(root.left,ans,arr);
	    help(root.right,ans,arr);
	    arr.remove(arr.size()-1);
	}
 	static ArrayList<ArrayList<Integer>> path(Node root) {
		ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		help(root,ans,list);
		return ans;
	}
	public static void main(String[] args) {
		//      3
		//    /   \
		//    4     2
		//  /  \   | \
		//  0  1   6  9
		//           / \
		//          10  11
		//          /
		//         12
		Node a = new Node(3);
		Node b = new Node(4);
		Node c = new Node(2);
		Node d = new Node(0);
		Node e = new Node(1);
		Node f = new Node(6);
		Node g = new Node(9);
		Node h = new Node (10);
		Node i = new Node (11);
		Node j = new Node (12);
		a.left=b;	a.right=c;
		b.left=d;
		b.right=e;
		c.left=f;
		c.right=g;
		g.left=h;
		g.right=i;
		h.left=j;
		orderWiseTraversal(a);
	}
}
