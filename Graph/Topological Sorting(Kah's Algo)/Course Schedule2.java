import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
    
    public int[] canFinish(int n, int[][] prerequisites) {

		//make a topological list
		ArrayList<ArrayList<Integer>>topoList=new ArrayList<>();
		for(int i=0; i<n; i++){
			topoList.add(new ArrayList<>());
		}

		//make incoming edges count array
		int[]indegree=new int[n];

		//add course to connected list
		
		for(int[] course : prerequisites){
			int ai=course[0];
			int bi=course[1];

			//bi-->ai
			topoList.get(bi).add(ai);

			//increase incoming edges
			indegree[ai]++;
			
		}

		//make a res list
		int[]res=new int[n];
		//pointer for idxes
		int idx=0;
		
		//apply bfs

		Queue<Integer>que=new LinkedList<>();

		//add all 0 indgree to the que
		for(int i=0; i<n; i++){
			if(indegree[i]==0)que.add(i);
		}

		boolean[]visited=new boolean[n];

		while(que.size()>0){
			//remove
			int curr=que.poll();

			//mark*
			if(visited[curr])continue;
			visited[curr]=true;
			
			//work*
			//add 0 indgree to final list
			res[idx]=curr;
			idx++;

			//add 0 indegree
			for(int nbr : topoList.get(curr)){
				indegree[nbr]--;
				if(indegree[nbr]==0)que.add(nbr);
			}
		}
		

		if(idx<n)
			return new int[0];

		return res;
		
    }
}
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
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}
