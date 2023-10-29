import java.util.*;

public class Main {
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        //Write your code here
            // Return true or false
        //find the row in which element is present
        int c = mat.length;
        int r = mat[0].length;
        int low = 0;
        int high = c-1;

        int expRow = -1;
        
        while(low<=high){
            int mid = (low + high)/2;

            if(mat[mid][c-1]==x)return true;

            if(mat[mid][c-1]>x){
                expRow = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        if(expRow==-1)return false;

        low = 0;
        high = c-1;

        while(low<=high){
            int mid =(low+high)/2;

            if(mat[expRow][mid]==x)return true;

            if(mat[expRow][mid]>x){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
