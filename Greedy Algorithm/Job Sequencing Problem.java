/*Job Sequencing Problem
Given a set of N jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note

Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.*/

import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String inputLine[] = br.readLine().trim().split(" ");
    
        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");
        
        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }
        
        Solution ob = new Solution();
        
        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);
    
    }
}

class Solution
{
    
    int[] solve(Job arr[], int n)
    {
        boolean[]days=new boolean[n+1];//to mark the visted days

		int cnt=0;
		int totalprofit=0;
		//sort in descending 
		Arrays.sort(arr, (a, b)->{return b.profit-a.profit;});

		for(int i=0; i<n; i++){
			//take deadline 
			int bestdays=arr[i].deadline;

			//find the days within the deadline
			while(bestdays>0 && days[bestdays]==true)bestdays--;

			//if it is 0 then there is no job on 0 day
			if(bestdays==0)continue;

			//mark that it is visited
			days[bestdays]=true;

			//count the bestdays
			cnt++;

			//add all the profits
			totalprofit += arr[i].profit;
		}

		//return the days and the profits
		int[]ans=new int[]{cnt, totalprofit};

		//return the array
		return ans;
    }
}
