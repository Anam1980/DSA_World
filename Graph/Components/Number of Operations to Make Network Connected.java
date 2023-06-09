class Solution {
    public void dfs(int curr, boolean[]vis, ArrayList<ArrayList<Integer>>adj){
        //mark
        vis[curr]=true;

        //work

        //explore

        for(int nbr : adj.get(curr)){
            if(vis[nbr])continue;
            dfs(nbr, vis, adj);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        //cpunt componenet by dfs

        //make adja.list

        //if connections size < n-1 then no cables avail. to connect
        if(connections.length <(n-1))return -1;

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<connections.length; i++){

            int u = connections[i][0];
            int v = connections[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int countcomponent=0;

        //mark array
        boolean[] vis =new boolean[n];

        for(int i=0; i<n; i++){
            if(vis[i])continue;

            dfs(i, vis, adj);

            countcomponent++;
        }

        return countcomponent-1;
    }
}
