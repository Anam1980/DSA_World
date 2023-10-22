import java.util.*;

public class Main {

    public static int longestkSubstr(int n, int k,String s){
        HashMap<Character, Integer>map = new HashMap<>();

		int inc = -1;
		int exc = -1;
		int maxlen =0;

		while(true){
			boolean f1 = false;
			boolean f2 = false;

			while(inc<n-1 && map.size()<=k){
				inc++;
				char val = s.charAt(inc);
				map.put(val, map.getOrDefault(val, 0)+1);

				if(map.size()==k){
					int total = 0;
					for(char ch: map.keySet()){
						total += map.get(ch);
					}

					maxlen = Math.max(maxlen, total);
				}

				f1 = true;
			}

			while(exc<inc && map.size()>k){
				exc++;
				char val = s.charAt(exc);
				map.put(val, map.getOrDefault(val, 0)-1);

				if(map.get(val)==0){
					map.remove(val);
				}

				f2 = true;
			}

			if(f1==false && f2== false){
				break;
			}
		}

		return maxlen==0?-1:maxlen;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = longestkSubstr(n,k,s);
        System.out.println(ans);
    }
}
