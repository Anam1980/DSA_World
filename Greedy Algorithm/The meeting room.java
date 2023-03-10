/*The Meeting Room
A multinational company has a room where meetings are held. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.

What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note

Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(inputLine[0]);

		int start[] = new int[n];
		int end[] = new int[n];

		inputLine = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++)
			start[i] = Integer.parseInt(inputLine[i]);

		inputLine = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) 
			end[i] = Integer.parseInt(inputLine[i]);
			
		int ans = new Solution().maxMeetings(start, end, n);
		System.out.println(ans);
    }
}

class Solution 
{
    static class Meeting {
        int start;
        int end;
        int pos;
        
        Meeting(int st, int en, int i){
            this.start=st;
            this.end=en;
            this.pos=i;
        }
    }
    
    static class MeetsComparator implements Comparator<Meeting>{
        @Override
        
        public int compare(Meeting o1, Meeting o2){
            if(o1.end<o2.end){
                return -1;
            }
            else if(o1.end>o2.end){
                return 1;
            }
            else if(o1.pos<o2.pos){
                return -1;
            }
            return 1;
        }
    }    
        
    
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Meeting>meets=new ArrayList<>();
        
        for(int i=0; i<n; i++){
            meets.add((new Meeting(start[i], end[i], i+1)));
        }
        
        MeetsComparator mc=new MeetsComparator();
        
        //sort acc. to min ends cuz min end time meeting gives us maximum no. of meets in 1 room
        Collections.sort(meets, mc);
        
        
        
        int cnt=0;//we take 1 meeting in cnt
        
        int limit = 0;//limit acc to 1 meeting
        
        for(int i=0; i<n; i++){
            //check that start > limit then we take that meerting
            if(meets.get(i).start > limit){
                cnt++;
                //update limit by new end
                limit = meets.get(i).end;
            }
        }
        
        return cnt;
    }
}

/*Time Complexity: O(n) to iterate through every position and insert them in a data structure. 
O(n log n)  to sort the data structure in ascending order of end time. O(n)  to iterate through the positions and check which meeting can be performed.

Overall : O(n) +O(n log n) + O(n) ~O(n log n)

Space Complexity: O(n)  since we used an additional data structure for storing the start time, end time, and meeting no.*/
