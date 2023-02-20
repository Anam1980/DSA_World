import java.io.*;
import java.util.*;
//-----------------------------------------------------------INPUT SECTION-------------------------------------------------//
class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        int U=sc.nextInt();
        int V=sc.nextInt();
        Solution ob = new Solution();
        if (ob.check(N, M, Edges,U,V)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

//if we consider 1st given node and find the another one if is present then it is true else false
//I use BFS to go through all nodes and find the node , bfs is easily find node at a time
//create adjacency list to store all edges and then apply bfs

class Solution {

	//-----------------------------------------------------------BFS APPROACH-------------------------------------------------//
	boolean hasPath(int u, int v, ArrayList<ArrayList<Integer>>graph,boolean[]visited ){

		Queue<Integer>que=new LinkedList<>();

		//visit
		visited[u]=true;
		
		//add 1st given ele
		que.add(u);

		while(que.size()>0){
			//remove
			int curr=que.poll();

			//work 
			//check for last
			if(curr == v)return true;
			
			//add not visited
			for(int nbr : graph.get(curr)){
				if(!(visited[nbr])){
					visited[nbr]=true;
					que.add(nbr);
				}
			}	
		}

		return false;
	}
	
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges,int U,int V) {
	    
	    //create empty lists
      ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
		for(int i=0; i<N+1; i++){
			graph.add(new ArrayList<>());
		}

	    //add all element vice-versa
		for(List<Integer> e : Edges){
			int u=e.get(0)-1;
			int v=e.get(1)-1;

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

	    //crete boolean array to mark
		boolean[]visited=new boolean[N+1];

	    //call the function
		return hasPath(U, V, graph, visited);
       
    }
}
