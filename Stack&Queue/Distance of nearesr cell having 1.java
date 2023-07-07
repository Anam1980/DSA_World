class Solution
{
    class Pair{
        int row;
        int col;
        int dist;
        
        Pair(int r, int c, int d){
            this.row=r;
            this.col=c;
            this.dist=d;
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
       Queue<Pair>que = new LinkedList<>();
       
       int n = grid.length;
       int m = grid[0].length;
       
       boolean visit[][]=new boolean[n][m];
       
       int[][]distance = new int[n][m];
       
       for(int i=0; i<n; i++){
           for(int j=0; j<m; j++){
               if(grid[i][j]==1){
                   que.add(new Pair(i, j, 0)); //add
                   visit[i][j] = true;//mark
               }
           }
       }
       
       while(!que.isEmpty()){
           //apply BFS
           //remove
           Pair curr = que.poll();
           
           int r = curr.row;
           int c = curr.col;
           int d = curr.dist;
           
           //work
           distance[r][c]=d;
           
           //explore
           
           if(r-1>=0 && visit[r-1][c]==false){
               que.add(new Pair(r-1, c, d+1));
               visit[r-1][c]=true;
           }
            if(c-1>=0 && visit[r][c-1]==false){
               que.add(new Pair(r, c-1, d+1));
               visit[r][c-1]=true;
           }
            if(r+1<n && visit[r+1][c]==false){
               que.add(new Pair(r+1, c, d+1));
               visit[r+1][c]=true;
           }
           if(c+1<m && visit[r][c+1]==false){
               que.add(new Pair(r, c+1, d+1));
               visit[r][c+1]=true;
           }
       }
       
       return distance;
       
    }
}
