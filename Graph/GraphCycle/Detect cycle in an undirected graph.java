//We know that cycle means starting node and ending node will same.
//So that to detect the cycle in undirected graph , if we iterate from each node and traverse to every connected node and if already visited node comes again then there is a cycle.


import java.io.*;
import java.util.*;

class Solution {

  //----------------------------BFS APPROACH-------------------------------------------------------//
  
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

	boolean[] visited=new boolean[V];
	for(int i=0; i<V; i++){
        if(visited[i]==true)continue;//if i is already visited, it must have been covered in prevous components

		Queue<Integer>que=new LinkedList<>();
		que.add(i);

		while(que.size()>0){
			//remove
			int curr=que.poll();
			if(visited[curr]==true)return true;// already visited and again trying to visit therefore cycle detecte
			//mark visited if not already visited	
			visited[curr]=true;

			//work*
			//add not visited
			for(int nbr : adj.get(curr)){
				if(!visited[nbr]){
				//add unvisited nbr
				que.add(nbr);
			}
		}
	    }		
        }
		return false;
    }
}

//----------------------------DFS APPROACH-------------------------------------------------------//
 public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

     boolean[] visited=new boolean[V];
     for(int i=0; i<V; i++){
	if(visited[i]==true)continue;//if i is already visited, it must have been covered in prevous components
      
      //here is the logic
      //we go to traverse in depth by storing the parent also ,
      //if any visited node during traversal from given start  has not same value as parent that means it is a cycle from that node
     if(hasCycle(i, visited, -1, adj){
          return true;
	}
     return false;
  }
           
   static boolean hasCycle(int v, boolean visited[], int parent, ArrayList<ArrayList<Integer>> adj){
     //visit the vertex
     visited[v]==true;
     
     //explore to the nbr
     for(int nbr : adj.get(v)){
       //if not visted then again explore
     if(visited[nbr]==false){
       hasCycle(nbr, visited, v, adj);
     }
       //if visted nd comes again the check that it is equal to parent or not
     else if(visited[nbr]==true){
       //if it is notequal and have different parent but again visited that means led by other so this is cycle ,
         if(nbr != parent){
           return true;
         }
      }
       
       return false;
   }

//----------------------------INPUT SECTION-------------------------------------------------------//
public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
