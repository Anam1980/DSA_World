import java.util.*;
class Main{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int t=sc.nextInt();
			while(t>0){
				int n=sc.nextInt();
				int k=sc.nextInt();
				Solution ob =new Solution();
				String ans = ob.smallestNumber(n,k);
				System.out.println(ans);
				t--;
			}
		}
	}

}

class Solution{ 
    public String smallestNumber(int S, int D){
        if(S>9*D){
			return "-1";
		}

		StringBuilder sb=new StringBuilder();
		//sum>9-->add 9 update sum=sum-9
		int i=D-1;
		while(i>=0){
			if(S>9){
				sb.append("9");
				S=S-9;
			}
			else{
				//first digit
				if(i==0){
					sb.append(S);
				}
				else{
					sb.append(S-1);
					S=1;    //S-(S-1);
				}
			}
			i--;
		}
		sb.reverse();

		return sb.toString();
    }
}
