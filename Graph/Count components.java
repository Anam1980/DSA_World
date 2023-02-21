//You are given an undirected graph with N vertices. You have to find the number of connected components in the graph.
//A set of vertices forms a connected component in an undirected graph if any vertex from the set of vertices can reach any other vertex by traversing edges.

//----------------------------------------------------------ADJACENCY MATRIX APPROACH----------------------------//
class Solution {
   public  int components(ArrayList<ArrayList<Integer>> graph, int N) {
     
		boolean[] visited = new boolean[N];
		int cnt = 0;
		//loop for rows 
		for(int i = 0;i<N;i++){
			if(visited[i]) continue;
			//cnt for each connections
			cnt++;

			//queue to store the connections
			Queue<Integer> q = new LinkedList<>();
			//add each node
			q.add(i);
			while(q.size()>0){
				//traverse upto the connected nodes
				//remove
				int front = q.remove();
				//mark*
				if(visited[front]) continue;
				visited[front] = true;

				//add unvisited but this is adjacency matrix so add the col contains 1 i.e true means it is connected 
				//loop for the each roww connections i.e.ADJACENCY MATRIX
				for(int ii = 0;ii<N;ii++){
					//if already visited
					if(ii==front) continue;

					//add non visited & having value 1
					if(!visited[ii] && graph.get(front).get(ii) == 1) q.add(ii);
				}
			}
			
		}
		return cnt;
    }
  
  //----------------------------------------------------------INPUT SECTION--------------------------------------------//
  
  class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        Solution ob = new Solution();
        System.out.println(ob.components(adj,N));
    }
}

/*Example 1
Input

3
1 1 0
1 1 0
0 0 1 
Output

2
Explanation

The graph has two components. [1, 2], and [3].*/
