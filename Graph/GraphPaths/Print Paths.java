import java.io.*;
import java.util.*;

public class Main {
  //Edge class
  
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
  //------------------------------------------------------------DFS APPROACH------------------------------------------------//
	public static void helper(ArrayList<Edge>[]graph ,int src, int dest, String psf, boolean[]visited){
    
		if(src==dest){
			//add to string if reach at destination
			String currpath=psf+src;
			//print path
			System.out.println(currpath);
			return;
		}

		//visited
		visited[src]=true;

		//explore to the nbr
		for(Edge v : graph[src]){
			if(visited[v.nbr]==true)continue;
			helper(graph, v.nbr, dest, psf+src, visited);
		}

		//again put not visited, as we have to find other paths
		visited[src]=false;
		
	}
   public static void printAllPath(ArrayList<Edge>[]graph , int src , int dest , int n){ 
	   boolean[]visited=new boolean[n];
     helper(graph, src, dest, "", visited);
   }
   
//------------------------------------------------------------INPUT SECTION-----------------------------------------------//
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      printAllPath(graph,src,dest,vtces);
   }


}
