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
    public static int perfectStudents(int n,  ArrayList<Edge>[] graph){
      //get components of every student of same club
		ArrayList<ArrayList<Integer>>comps=new ArrayList<>();
		
		boolean[]vis=new boolean[n];
		//traverse through loop and get each list of connected student , add the to final list
		for(int i=0; i<n; i++){
			if(vis[i]==false){
				ArrayList<Integer>eachComp=new ArrayList<>();
				drawTreeandGenerate(i, eachComp, vis, graph);
				comps.add(eachComp);
			}
		}

		int pairs=0;
		//count pair , if c1 c2 c3 are club having same student then c1*c2 is the no. pair of diff set student
		for(int i=0; i<comps.size(); i++){
			for(int j=i+1; j<comps.size(); j++){
				//so count this pairs
				int cnt=(comps.get(i).size()*comps.get(j).size());
				pairs+=cnt;
			}
		}
		return pairs;
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
      System.out.println(Solution.perfectStudents(n, graph));
   }

}
