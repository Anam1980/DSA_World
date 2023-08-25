import java.util.*;

class Accio {
    public static int solve(int[] a, int b) {
        int ans=count(a,b)-count(a,b-1);
        return ans;
    }

    public static int count(int[] a,int b)
    {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < a.length; ++j) {
            if (count.getOrDefault(a[j], 0) == 0) b--;
            count.put(a[j], count.getOrDefault(a[j], 0) + 1);
            while (b < 0) {
                count.put(a[i], count.get(a[i]) - 1);
                if (count.get(a[i]) == 0) b++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}

public class Main {  
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    int n = sc.nextInt();
		int[] a = new int[n];
    	for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		Accio Obj = new Accio();
        System.out.println(Obj.solve(a, b));
        sc.close();
	}
}
