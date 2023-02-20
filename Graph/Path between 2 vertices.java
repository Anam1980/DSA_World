import java.io.*;
import java.util.*;

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

class Solution {

	boolean hasPath(int u, int v, ArrayList<ArrayList<Integer>>graph,boolean[]visited ){

		Queue<Integer>que=new LinkedList<>();

		//visit
		visited[u-1]=true;
		que.add(u-1);

		while(que.size()>0){
			//remove
			int curr=que.poll();

			//work 
			if(curr == v-1)return true;
			//add
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
      ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
		for(int i=0; i<N; i++){
			graph.add(new ArrayList<>());
		}

		for(List<Integer> e : Edges){
			int u=e.get(0)-1;
			int v=e.get(1)-1;

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		boolean[]visited=new boolean[N];

		return hasPath(U, V, graph, visited);
       
    }
}
