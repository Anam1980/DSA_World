// Computers and Data--
// A company has a collection of computers working together for sharing data with each other.
// There are total n computers and they are numbered from '0' to 'n-1'. 
// The arrangement of computers follows a hierarchy and information can only travel down the hierarchy.
// The main server is to spread an important information across all the computers of the company and each computer can send the information to the directly connected computers just below their hierarchy.
// An array represents integers where computer[i] is the direct upper level computer for the computer i.
// If the computer[i] = -1, then ith computer is the main server.
// The information starts spreading from the main server and an array reqTime stores the time required by the ith computer to spread information to each of it's directly connected computers one level down their hierarchy. 
// Find out the total time required to spread the information to all the computers in this architecture.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] computer = {-1, 0, 0, 1, 1};
        int[][] reqTime = {{1, 3}, {2}, {4, 5}, {6}, {7, 8}};
        int result = spreadInformationTime(n, computer, reqTime);
        System.out.println(result);
    }

    public static int spreadInformationTime(int n, int[] computer, int[][] reqTime) {
        int totalTime = 0;
        for (int i = 0; i < n; i++) {
            if (computer[i] == -1) {
                totalTime = Math.max(totalTime, dfs(i, computer, reqTime));
            }
        }
        return totalTime;
    }

    public static int dfs(int current, int[] computer, int[][] reqTime) {
        if (computer[current] == -1) {
            return 0;
        }
        
        int maxTime = 0;
        for (int i = 0; i < reqTime[current].length; i++) {
            int time = reqTime[current][i] + dfs(computer[current], computer, reqTime);
            maxTime = Math.max(maxTime, time);
        }
        
        return maxTime;
    }
}
