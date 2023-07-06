class Solution
{
    public static boolean IsOperator(char ch){
        if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            return true;
        }
        
        return false;
    }
    public static int Evaluate(int s1, int s2, char ch){
        if(ch=='+')return s1+s2;
        else if (ch=='-')return s1-s2;
        else if(ch=='*')return s1*s2;
        else{
            return s1/s2;
        }
    }
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        //postfix-> ab+
        
        Stack<Integer>st = new Stack<>();
        
        //operand -> push 
        //operator -> pop two and evaluate and push the result
        
        //scan each one
        for(int i=0; i<S.length(); i++){
            
            char ch = S.charAt(i);
            
            if(IsOperator(ch)){
                int s2=st.pop();
                int s1=st.pop();
                
                int res = Evaluate(s1, s2, ch);
                
                st.push(res);
                
            }
            else{
                int num = ch -'0';
                
                st.push(num);
            }
            
        }
        
        return st.peek();
    }
}
