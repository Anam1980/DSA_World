//BFS Implementation>>>>>
//Given a directed graph. The task is to do Breadth First Search of this graph.
//Note: Graph does not contain multiple edges and self loops.

//Input Format
//The First line of test case contains two integers N and E which denotes the no of vertices and no of edges respectively.

//The Second line of test case contains E space separated pairs u and v denoting that there is a edge from u to v .

//parent-->child 

import java.util.*;
import java.io.*;
 
class Graph {
    public int vertices;
    public ArrayList<Integer>[] adjList;
 
 //Constructor
    Graph(int v) {
        this.vertices = v+1;
        adjList = new ArrayList[v+1];
        
     //create empty list to add connected edges of each node
        for (int i = 0; i <= v; i++) adjList[i] = new ArrayList<Integer>();
    }
 
 //adding edges src-->des
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }
 
 //In BFS, we go level by level 
 // r m* w* a
   void BFS(int x) {
    
         boolean[] visited = new boolean[vertices];
    
        LinkedList<Integer> queue = new LinkedList<Integer>();
       
        queue.add(x);
        
        while(queue.size() != 0) {
         //Remove
            x = queue.poll();
         
         //Mark*
         visited[x] = true;
         
         //Work*
         System.out.print(x + " ");
            
         //Add not visited to que
         for(int i : adjList[x]) {
             if(!visited[i]) {
                visited[i] = true;
                  queue.add(i);                }
            }
        }
    }
}
 
//input section

public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(110);
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        g.BFS(0);
    }
}
