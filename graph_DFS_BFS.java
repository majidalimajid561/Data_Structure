import java.util.*;
class Triplet{
    int row;
    int col;
    int time;
    Triplet(int row , int col , int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Edge {
	int dist;
	int src;
	Edge(int src,int dist) {
		this.dist=dist;
		this.src=src;
	}
}
class Pair {
	int row;
	int col;
	Pair(int row,int col) {
		this.row=row;
		this.col=col;
	}
}

public class Main
{
	static void graph() {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter vertex");
		int vertex=sc.nextInt();
		System.out.println("enter Edge");
		int edge=sc.nextInt();
		//crearing empty lists
		ArrayList<Integer>[] list=new  ArrayList[vertex];
		for(int i=0; i<vertex; i++) {
			list[i]= new ArrayList<>();
		}
		// making connections
		for(int i=0; i<edge; i++) {
			int src=sc.nextInt();
			int dist=sc.nextInt();
			list[src].add(dist);
			list[dist].add(src);
		}
		// printg all connections
		for(int i=0; i<vertex; i++) {
			ArrayList<Integer> li =list[i];
			System.out.print(i+"->");
			for(int j =0; j<li.size(); j++) {
				System.out.print(li.get(j)+" ");
			}
			System.out.println();
		}
	}
	static void creating(ArrayList<Edge>[] graph) {
		for(int i=0; i<graph.length; i++) {
			graph[i]=new ArrayList<>();
		}
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,2));
		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,1));
// 		graph[0].add(new Edge(0,1));
// 		graph[0].add(new Edge(0,2));

// 		graph[1].add(new Edge(1,0));
// 		graph[1].add(new Edge(1,3));

// 		graph[2].add(new Edge(2,0));
// 		graph[2].add(new Edge(2,4));

// 		graph[3].add(new Edge(3,5));
// 		graph[3].add(new Edge(3,1));
// 		graph[3].add(new Edge(3,4));

// 		graph[4].add(new Edge(4,5));
// 		graph[4].add(new Edge(4,2));
// 		graph[4].add(new Edge(4,3));

// 		graph[5].add(new Edge(5,4));
// 		graph[5].add(new Edge(5,6));
// 		graph[5].add(new Edge(5,3));

// 		graph[6].add(new Edge(6,5));
	}

// 	static  void BFS(ArrayList<Edge>[] graph) {
// 		Queue<Integer> q=new LinkedList<>();
// 		q.add(0);
// 		boolean[] vis =new boolean[graph.length];
// 		while(q.size()!=0) {
// 			int currListidx = q.remove();
// 			if(vis[currListidx]==false) {
// 				System.out.print(currListidx+" ");
// 				vis[currListidx]=true;
// 				for(int i=0; i<graph[currListidx].size(); i++) {
// 					Edge e = graph[currListidx].get(i);
// 					q.add(e.dist);
// 				}
// 			}
// 		}
// 	}

// 	static void BFS_2(ArrayList<Edge>[] graph,boolean[] vis, int start) {
// 		Queue<Integer> q =new LinkedList<>();
// 		q.add(start);
// 		while(q.size()!=0) {
// 			int currListidx = q.remove();
// 			if(vis[currListidx]==false) {
// 				System.out.print(currListidx+" ");
// 				vis[currListidx]=true;
// 				for(int i=0; i<graph[currListidx].size(); i++) {
// 					Edge e =graph[currListidx].get(i);
// 					q.add(e.dist);
// 				}
// 			}
// 		}
// 	}
// static void DFS(ArrayList<Edge>[] graph, int curr, boolean[] vis){
//     System.out.print(curr+" ");
//     vis[curr]=true;
//     for(int i=0;  i<graph[curr].size(); i++){
//     Edge e =graph[curr].get(i);
//     if(vis[e.dist]==false)
//     DFS(graph,e.dist,vis);
//     }
// }
	static void matrixGraph(int[][] matrix) {
		matrix[0][1]=1;
		matrix[1][0]=1;
		matrix[2][1]=1;
		matrix[1][2]=1;
		matrix[2][0]=1;
		matrix[0][2]=1;
	}

	static void DFS(int curr, int[][] mat,boolean[] vis) {
		System.out.print(curr+" ");
		vis[curr]=true;
		for(int i=0;  i<mat[curr].length; i++) {
			if(mat[curr][i]==1 &&vis[i]==false) {
				DFS(i,mat,vis);
			}
		}
	}
	static void BFS(int curr, boolean[] vis,  int[][] mat) {
		Queue<Integer>  q =new LinkedList<>();
		q.add(curr);
		while(q.size()>0) {
			int crow=q.remove();
			if(vis[crow]==false) {
				System.out.print(crow+" ");
				vis[crow]=true;
				for(int i=0; i<mat[crow].length; i++) {
					if(mat[crow][i]==1 && !vis[i]) q.add(i);
				}
			}
		}
	}
	static void  island_BFS(int i, int j, boolean[][]    vis,char[][] grid) {
		Queue<Pair> q =new LinkedList<>();
		int m=grid.length;
		int n=grid[0].length;
		q.add(new Pair(i,j));
		while(q.size()>0) {
			Pair front= q.remove();
			int row=front.row;
			int col=front.col;
			if(vis[row][col]==false) {
				vis[row][col]=true;
				// top=row-1,col
				if(row>0) {
					if(gird[row-1][col]=='1' &&vis[row-1][col]==false) {
						q.add(new Pair(row-1,col));
					}
				}
				//botom=row+1,col
				if(row+1<m) {
					if(gird[row+1][col]=='1' &&vis[row+1][col]==false) {
						q.add(new Pair(row+1,col));
					}
				}
				//left =row,col-1
				if(col>0) {
					if(gird[row][col-1]=='1' &&vis[row][col-1]==false) {
						q.add(new Pair(row,col-1));
					}
				}
				// right=row,col+1
				if(col+1<n) {
					if(gird[row][col+1]=='1' &&vis[row][col+1]==false) {
						q.add(new Pair(row,col+1));
					}
				}
			}
		}
	}
	int numisland(char[][] gird) {
		int count=0;
		int m=grid.length;
		int n=grid[0].length;
		boolean[][]    vis = new boolean[m][n];
		for(int i =0;  i<m; i++) {
			for(int j =0; j<n; j++) {
				if(grid[i][j]=='1' && vis[i][j==false) {
				island_BFS(i,j,vis,grid);
					count++;
				}
			}
		}
		return count;
	}

	static	void BFS_path(int src, int end,boolean[] vis, ArrayList<Integer>[] adj) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		while (q.size() > 0) {
			int curr = q.remove();
			if (vis[curr] == false) {
				vis[curr]=true;
				if (curr==end) return;
				for (int i = 0; i < adj[curr].size(); i++) {
					int nbr = adj[curr].get(i);
					q.add(nbr);
				}
			}
		}
	}
	static boolean validPath(int n, int[][] edges, int source, int destination) {
		ArrayList<Integer>[] list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int dis = edges[i][1];
			list[src].add(dis);
			list[dis].add(src);
		}
		boolean[] vis = new boolean[n];
		BFS_path(source,destination,vis, list);
		return vis[destination];
	}
	public void  isConnected_BFS(int[][] isConnected,int curr,boolean[] vis) {
		Queue<Integer> q =new LinkedList<>();
		q.add(curr);
		while(q.size()>0) {
			int curridx=q.remove();
			if(vis[curridx]==false) {
				vis[curridx]=true;
				for(int i=0; i<isConnected[curridx].length; i++) {
					if(isConnected[curridx][i]==1 && !vis[i]) {
						q.add(i);
					}
				}
			}
		}
	}
}
public static int findCircleNum(int[][] isConnected) {
	int count=0;
	boolean[] vis =new boolean[n];
	int n =isConnected.length;
	for(int i=0; i<n; i++) {
		if(!vis[i])	isConnected_BFS(isConnected,i,vis);
		count++;
	}
}
public static void  keys_BFS(int i,boolean[] vis, List<List<Integer>> rooms){
    Queue<Integer> q =new LinkedList<>();
    q.add(i);
    while(q.size>0){
        int curr =q.remove();
        if(vis[curr]==false){
            vis[curr]=true;
            for(int j=0; j<rooms.get(curr).size();  i++){
                q.add(rooms.get(curr).get(i));
            }
        }
    }
}
public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int v =rooms.size();
        boolean[] vis =new boolean[v];
        keys_BFS(0,vis,rooms);
        for( boolean ele:vis){
            if(ele==false) return false;
        }
        return true;
    }
    public static   int orangesRot(int[][] mat) {
        int n =mat.length;
        Queue<Triplet> q =new LinkedList<>();
        for (int i =0;  i<mat.length; i++){
            for (int j =0; j<mat[i].length; j++){
                if(mat[i][j]==2)
                q.add(new Triplet(i,j,0));
            }
        }
        int maxtime=0;
        while(q.size()>0)
    }
public static void main(String[] args) {

}
}
