class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer>st = new Stack<>();

        int sum = 0;

        for(int curr : arr){
            //pop -> if peek<=curr
            //multiply it with min of(peek, curr)
            while(!st.isEmpty() && st.peek()<=curr){
                int sv = st.pop();//smallest value

                if(st.isEmpty()){
                    sum+= sv * curr;//if no peek available i.e. stack is empty

                }
                else{
                sum += sv * Math.min(st.peek(), curr);//multiply it with min of two big values
                }
            }
            st.push(curr);
        }

        while(st.size()>1){
            sum += st.pop() * st.peek();//all remaining are the larger nodes of left and right
        }

        return sum;
    }
}
