import java.io.*;
import java.util.*;
  class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
class Solution{
    public static void GetComponents(int n,  ArrayList<Edge>[] graph){
      //get components of every connectes edges of unidirected graph
		ArrayList<ArrayList<Integer>>comps=new ArrayList<>();
		
		boolean[]vis=new boolean[n];
		//traverse through loop and get each list of connected nodes , add the to final list
		for(int i=0; i<n; i++){
			if(vis[i]==false){
				ArrayList<Integer>eachComp=new ArrayList<>();
				drawTreeandGenerate(i, eachComp, vis, graph);
				comps.add(eachComp);
			}
		}
      System.out.print(comps);
   }
	public static void drawTreeandGenerate(int i, ArrayList<Integer>eachComp, boolean[]vis, ArrayList<Edge>[] graph){
		//visite
		vis[i]=true;
		//add to list
		eachComp.add(i);

		//go to the neighbours recursively
		for(Edge e: graph[i]){
			if(vis[e.nbr]==true)continue;
			drawTreeandGenerate(e.nbr, eachComp, vis, graph);
		}
	}
}
public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      int vtces = n;
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = k;
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }
     Solution.GetComponents(n, graph);
   }

}
