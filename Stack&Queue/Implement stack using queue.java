class MyStack {
    Queue<Integer>q1;
    Queue<Integer>q2;
    int front;

    public MyStack() {
       q1=new LinkedList<>();
       q2=new LinkedList<>();
       front=0;
    }
    
    public void push(int x) {
        q1.add(x);
        front=x;
    }
    
    public int pop() {
        if(q1.size()==0){
            return -1;
        }
        while(q1.size()!=1){
            q2.add(q1.poll());
        }
        int rem=q1.poll();

        while(q2.size()!=0){
            q1.add(q2.poll());
        }

        return rem;
    }
    
    public int top() {
         if(q1.size()==0){
            return -1;
        }
        while(q1.size()!=1){
            q2.add(q1.poll());
        }
        int rem=q1.poll();
        

        while(q2.size()!=0){
            q1.add(q2.poll());
        }
        q1.add(rem);

        return rem;
    }
    
    public boolean empty() {
        if(q1.size()==0)return true;

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
