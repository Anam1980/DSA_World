class MyQueue {
    Stack<Integer>s1;
    Stack<Integer>s2;

    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {

        if(s1.isEmpty()){
            return -1;
        }

        while(s1.size()!=1){
            int rem = s1.pop();
            s2.push(rem);
        }

        int pop = s1.pop();

        while(s2.size()!=0){
            int rem = s2.pop();
            s1.push(rem);
        }

        return pop;
    }
    
    public int peek() {

         while(s1.size()!=1){
            int rem = s1.pop();
            s2.push(rem);
        }

        int peek = s1.peek();

         while(s2.size()!=0){
            int rem = s2.pop();
            s1.push(rem);
        }

        return peek;
    }
    
    public boolean empty() {
        if(s1.isEmpty())return true;

        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
