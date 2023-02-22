import java.util.*;

class Solution {
	 public static void dfsHelper(int node, List<List<Integer>> graph, boolean[] visited) {
        // Mark the current node as visited
        visited[node] = true;
        
        // Print the current node
        System.out.print(node + " ");
        
        // Traverse the adjacent nodes
         // Traverse the adjacent nodes in sorted order
        List<Integer> adjNodes = graph.get(node);
        Collections.sort(adjNodes);
        for (int adj : adjNodes) {
            if (!visited[adj]) {
                dfsHelper(adj, graph, visited);
            }
        }
    }
    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add edges to the graph
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // Initialize the visited array
        boolean[] visited = new boolean[n];
        
        // Perform DFS on each unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsHelper(i, graph, visited);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}
