import java.util.*;

public class Main {

    public static long DistinctCharacterSubstring(String s){
       HashSet<Character>hs = new HashSet<>();

		long cnt = 0;

		int st = 0;
		int end = 0;
		
		while(end<s.length()){
			char ch = s.charAt(end);

			//remove upto that if already present in set 
				while(hs.contains(ch)){
					hs.remove(s.charAt(st));
					st++;
				}

			//count/answer step
			cnt+=(end-st+1);

			//add 
			hs.add(ch);

			//update
			end++;
		}

		return cnt;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long ans = DistinctCharacterSubstring(s);
        System.out.println(ans);
    }
}
