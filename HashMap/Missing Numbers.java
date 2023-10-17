import java.util.*;

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {

		int cnt1[]=new int[10001];
		int cnt2[]=new int[10001];

		for(int i=0;i<n;i++)cnt1[arr[i]]++;
		for(int i=0;i<m;i++)cnt2[brr[i]]++;

		boolean found=false;
		for(int ele=1;ele<=10000;ele++){
			if(cnt2[ele]>0 && cnt1[ele]==0){
				System.out.print(ele+" ");
				found=true;
			}
			else if(cnt1[ele]>0 && cnt2[ele]>0 && cnt1[ele]!=cnt2[ele]){
				System.out.print(ele+" ");
				found=true;
			}
		}
		if(found==false){
			System.out.print(-1);
		}
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}
