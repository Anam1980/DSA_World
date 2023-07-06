class MyStack {

    Queue<Integer>q1;
    Queue<Integer>q2;
    int peek;

    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();

    }
    
    public void push(int x) {
        q1.add(x);//O(1)
        peek=x;
    }
    
    public int pop() {
        if(q1.isEmpty())return -1;

        while(q1.size()>1){
            int rem = q1.poll();
            q2.add(rem);
            
        }

        int pop = q1.poll();

        while(q2.size()>0){
            int rem = q2.poll();
            q1.add(rem);
            peek=rem;
        }

        return pop;
    }
    
    public int top() {
        //peek
        return peek;
    }
    
    public boolean empty() {
        if(q1.isEmpty())return true;

        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
