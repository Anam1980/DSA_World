//Code to create Ajacency matrix to represent the graph.

public class Graph {
    private int[][] adjMatrix;
    private int numVertices;

    public Graph(intn) {
        this.numVertices = n;
        this.adjMatrix = new int[n][n];
    }

  //true condition 
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // assuming an undirected graph
    }

  //false conditon
    public void removeEdge(int src, int dest) {
        adjMatrix[src][dest] = 0;
        adjMatrix[dest][src] = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                sb.append(adjMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
//--------------------------------------------------------------------INPUT----------------------------------------------//
Graph g = new Graph(4);
g.addEdge(0, 1);
g.addEdge(1, 2);
g.addEdge(2, 3);
System.out.println(g.toString());

//--------------------------------------------------------------------OUTPUT-------------------------------------------//

   0 1 2 3
0- 0 1 0 0 
1- 1 0 1 0 
2- 0 1 0 1 
3- 0 0 1 0 
