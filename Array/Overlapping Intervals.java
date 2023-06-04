class Solution
{
   
    
    public int[][] overlappedInterval(int[][] Intervals)
    {
        //sort
        Arrays.sort(Intervals, (a, b)->(a[0]-b[0]));
        
        //take index
        int index=0;
        
        //Iterate
        for(int i=1; i<Intervals.length; i++){
            //merge if prev end > curr start
            if(Intervals[index][1] >= Intervals[i][0]){
                Intervals[index][1] = Math.max(Intervals[index][1], Intervals[i][1]);
            }
            else{
                index++;
                Intervals[index][0]=Intervals[i][0];
                Intervals[index][1]=Intervals[i][1];
                
            }
        }
        
        int[][]ans=new int[index+1][2];
        
        for(int i = 0 ; i <= index; i++){
            
            ans[i][0] = Intervals[i][0];
            ans[i][1] = Intervals[i][1];
        }
        
        return ans;
    }
}
