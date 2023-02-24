//Kahn's is popular algorithm for topological sorting which is an operation on Directed Acyclic Graph(DAG) ,
//that arrange the all node in linear manner such that every nodes added before that all node which depend on it.//

import java.util.*;

class Solution {
 
  //---------------------------------------------------------KAHN'S ALGO--------------------------------------------//  
    public int canFinish(int n, int[][] prerequisites) {

		ArrayList<ArrayList<Integer>>topo=new ArrayList<>();

		for(int i=0; i<n; i++){
			topo.add(new ArrayList<>());
		}
		
        //find all inocoming edges
		int incoming[]=new int[n];

		//adding prople acc to condition bi-->ai
		for(int[] people : prerequisites){
			int ai = people[0];
			int bi = people[1];

			topo.get(bi).add(ai);
			incoming[ai]++;
		}
		
		//apply bfs
		Queue<Integer>que=new LinkedList<>();

		boolean[]visited=new boolean[n];

		//add 0 incoming edges node
		for(int i=0; i<n; i++){
			if(incoming[i]==0){
				que.add(i);
			}
		}

		//poniter to track the 0 incoming element
		int idx=0;
		
		while(que.size()>0){
			//remove
			int curr=que.poll();

			idx++;

			//mark
			if(visited[curr])continue;

			visited[curr]=true;

			//work
			for(int nbr : topo.get(curr)){
				incoming[nbr]--;
				if(incoming[nbr]==0)
					que.add(nbr);
				
			}
		}
		
		if(idx<n)return 0;

		return 1;
    }
}

//----------------------------------------------------------------INPUT SECTION------------------------------------//
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.canFinish(N,prerequisites));

    }
}
