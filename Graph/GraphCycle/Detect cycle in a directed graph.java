//Cycle means where from u started ,u ended on that i.e.start==end
//to detect the cycle in directed graph, we go from each node in depth and search, if we viisted it again within a path then it is a cycle.
//traverse through each node searately by dfs i.e. apply dfs in each node.
//if we find the visited node in path return true.
//if not detect any cycle so we remove it from path.

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

  //-------------------------------------------------------DFS APPROACH-----------------------------------------------//
  
	public boolean dfs(int v, boolean[]visited, boolean[]Inpath, ArrayList<Integer>[] adj){
    
		//visit node and take in a path of cycle detection
		visited[v]=true;
		Inpath[v]=true;

		//Explore to nbr

		for(int nbr : adj[v]){
			//if ele is visited and in a detect path also thats mean it is cyclic path so that it comes again with path
			if(visited[nbr] && Inpath[nbr])return true;

			//if comes first time
			if(!visited[nbr]){
				boolean DetectCycle=dfs(nbr, visited, Inpath, adj);
				if( DetectCycle==true){
					return true;
				}
			}
		}
		//if we nt detect any cycle path with that node, so remove from path
		//if we have reached this line, this means that we are not able to detect any cycle
		//from here on, our visited will remain true which will symbolize our failure to detect a cycle
		// but path will become false as we will not be present in the path
		Inpath[v]=false;
		return false;
	}
  
  public boolean isCyclic(int V, ArrayList<Integer>[] adj) {
    boolean[]visited=new boolean[V];
	boolean[]Inpath=new boolean[V];

	//traverse from each vertex
	for(int i=0; i<V; i++){
		if(visited[i]==true)continue;
		if(dfs(i, visited, Inpath, adj)){
			return true;
		}
	}
	return false;
   }
}
  //-------------------------------------------------------INPUT SECTION-----------------------------------------------//
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
