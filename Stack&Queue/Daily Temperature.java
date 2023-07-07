class Solution {
    public int[] dailyTemperatures(int[] temperature) {
        int n = temperature.length;
        int[] ans =new int[n];

        Stack<Integer>st = new Stack<>(); 

        //Traverse through whole array
        for(int i=0; i<n; i++){
            //want a greater element 
            while(!st.isEmpty() && temperature[i] > temperature[st.peek()]){
                int idx = st.pop();

                ans[idx] = i - idx;
            }
            st.push(i);
        }

        //all reamining values
        while(st.size()>0){
            int idx = st.pop();
            ans[idx] = 0;
        }

        return ans;
    }
}
