
/*Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.*/
class Solution {
    public String reverse (String s){
        int n = s.length()-1;
        int i=0;

        while(i<n){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(n);

            char temp =ch1;
            ch1=ch2;
            ch2=temp;

            i++;
            n--;
        }

        return s;

        
    }
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>st = new Stack<>();

        String ans1="";
        String ans2="";

        int n1 = s.length();//length of both strings
        int n2 = t.length();

        int i=0;
        int j=0;

        while(i!=n1){
            char ch = s.charAt(i);

            if(ch=='#'){
                if(st.isEmpty()){

                }
                else{
                st.pop();
                }
            }
            else{
                st.push(ch);
            }
            i++;
        }

        while(st.isEmpty()==false){
            ans1+=st.pop();
        }

        String s1=reverse(ans1);

        while(j!=n2){
            char ch = t.charAt(j);

            if(ch=='#'){
                 if(st.isEmpty()){

                }
                else{
                st.pop();
                }
            }
        else{
                st.push(ch);
            }

            j++;
        }
         while(st.isEmpty()==false){
            ans2+=st.pop();
        }

        String s2=reverse(ans2);

        //check 
        if(s1.equals(s2))return true;

        return false;


    }
}
