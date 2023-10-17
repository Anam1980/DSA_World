import java.io.*;
import java.util.*;

class Solution {

	public int solve(String ceo, Map<String, List<String>>mng, Map<String, Integer>ans){
		if(mng.containsKey(ceo)==false){
			ans.put(ceo, 0);
			return 1;
		}
		int cnt=0;
		for(String emp: mng.get(ceo)){
			cnt+=solve(emp, mng, ans);
		}

		ans.put(ceo, cnt);
		return cnt+1;
	}

    public void EmpUnderManager(Map<String, String> emp)//employee:manager
	{
		Map<String, List<String>>mng=new HashMap<>();//manager:employee

		String ceo="";
		for(String employee : emp.keySet()){
			String manager=emp.get(employee);
			if(manager.equals(employee)){
				ceo=manager;
				continue;
			}

			if(mng.containsKey(manager)){
				List<String>oldVal=mng.get(manager);
				oldVal.add(employee);
				mng.put(manager, oldVal);
			}
			else{
				List<String>nlist=new ArrayList<>();
				nlist.add(employee);
				mng.put(manager, nlist);
			}
		}

		Map<String, Integer>ans=new TreeMap<>();//for sorted order
		solve(ceo, mng, ans);

		for(String key:ans.keySet()){
			System.out.println(key+" "+ans.get(key));
		}
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
			emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp); 
    }
}
