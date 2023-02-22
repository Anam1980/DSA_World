

import java.io.*;
import java.util.*;
import java.lang.*;

//---------------------------------------------------DIJKSTRA ALGO------------------------------------//
public class Main {
	
	static class Pair{
		int node;
		int wgt;
		String psf;

		Pair(int n, int w, String p){
			this.node=n;
			this.wgt=w;
			this.psf=p;
		}
	}
	
  public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
  {
     //create a priority queue
	  PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{return a.wgt-b.wgt;});
	  
	  pq.add(new Pair(S, 0, ""+S));
	  
	  //make array to store visited nodes
	  int[]visited=new int[V];
	  Arrays.fill(visited, -1);

	  //apply bfs
	  while(pq.size()>0){
		  //remove
		  Pair curr=pq.poll();

		  int currnode=curr.node;
		  int currwgt=curr.wgt;
		  String currpsf=curr.psf;

		  //mark*
		  if(visited[currnode]!=-1)continue;

		  //work*
		  visited[currnode]=currwgt;

		  //add
		  for(ArrayList<Integer>edge : adj.get(currnode)){
			  int nbr=edge.get(0);
			  int weigh=edge.get(1);
			  
			  if(visited[nbr]!=-1)continue;

			  pq.add(new Pair(nbr, currwgt+weigh, currpsf+nbr));
		  }  
	  }
	   return visited;
  }
	
//--------------------------------------------INPUT SECTION------------------------------------------------//
	
  public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            int[] ptr = dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    

}
