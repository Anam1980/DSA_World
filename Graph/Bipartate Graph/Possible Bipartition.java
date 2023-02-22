//A Bipartate Graph in which vertices distributed in a two set such that one set having the vertices are connected to the another set vertices.
//Basically, same set doesn't contain connected vertices.
//it is used to model customer and market, buyers and sellers, users and system.
//for ex. one set of tasks and another set of robot and edge between then is representes the compatibility between robots and task, such that which task allocated to which robo. task assign to that robot if there is a edge betn them.
//Used to model Allocation of Resources and Tasks to agent.



import java.util.*;

class Solution {
   
    public int possibleBipartition(int n, int[][] dislikes) {
		
       ArrayList<ArrayList<Integer>>graph=new ArrayList<>();

		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<>());
		}

		for(int[] per : dislikes){
			int ai=per[0];
			int bi=per[1];
          //Undirected ggraph
			graph.get(ai).add(bi);
			graph.get(bi).add(ai);
		}

		int[]visited=new int[n+1];
		
		for(int i=1; i<=n; i++){
		//apply dfs, if not having color
			if(visited[i]==0){
				boolean check=dfs(i, 1, graph, visited);
				if(!check)return 0;
			}
		}
		return 1;
	 }
    

	public boolean dfs(int node, int color,  ArrayList<ArrayList<Integer>>graph, int[]visited){

		//use alternate color method

		//visit by color 
		visited[node]=color;

		//color nbr alternatly
		int nbrcolor = (color == 1 ? 2 : 1);

		for(int nbr : graph.get(node)){

			//if visited nbr is of same color then not bipartate
			if(visited[nbr]==color)return false;

			//if not visited any color i.e 0
				 //then apply dfs 
			else if(visited[nbr]==0){
				boolean check=dfs(nbr, nbrcolor, graph, visited);
				if(!check)return false;
			}
		}

		return true;
	}
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}
