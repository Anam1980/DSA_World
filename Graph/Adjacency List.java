//Create Adjacency list of Undirected cyclic graph to represent a graph 
//its edges

public static void DFSTraversal(List<List<Integer>> edges, int n) {
  
   // Create an adjacency list to represent the graph
   List<List<Integer>> graph = new ArrayList<>();
  
  //create empty lists in a final list to add the all edges 
  
  for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
   // Add edges to the graph
  //as graph is undirected cyclic graph
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
  
  for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + ": ");
            for (int j : graph.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
  
}
  

//input
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
