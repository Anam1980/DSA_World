/*Range Sum 2D
Given a 2D matrix matrix, your task is to handle the multiple queries of the following type.
Calculate the sum of the elements of the matrix inside the rectangle formed by its upper left corner (row1,col1) and lower right corner(row2,col2).
Your are given q queries of such type and you need to find the output for every query.
Input Format
The first line of input contains the number of rows and columns n and m, respectively.
The next n lines contains m space seperated seperated integers.
The next line contains the number of queries q.
The next q lines contains 4 space seperated integers row1,col1,row2,and col2 respectively.
Output Format
Return the sum for each query in new line.
Example 1
Input
5 5
3 0 1 4 2
5 6 3 2 1
1 2 0 1 5
4 1 0 1 7
1 0 3 0 5
3
2 1 4 3
1 1 2 2
1 2 2 4
Output
8
11
12*/

import java.util.*;

class Pair {
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {

	void build(int[][] matrix, int n, int m){

		for(int i=0; i<n; i++){
			for(int j=0; j<m ;j++){
				int A = matrix[i][j];
				int B = j-1>=0 ? matrix[i][j-1] : 0;
				int C = i-1>=0 ? matrix[i-1][j] : 0;
				int D = i-1>=0 && j-1>=0 ? matrix[i-1][j-1] : 0;

				matrix[i][j]=A + B + C - D;//sum of prefix
			}
		}
	}
    public List<Integer> solve(int matrix[][], Pair query[]) {
       List<Integer>ans=new ArrayList<>();

		int n=matrix.length;
		int m=matrix[0].length;

		build(matrix, n, m);
		
        for(int i=0; i<query.length; i++){
			int r1 = query[i].row1;
			int c1 = query[i].col1;
			int r2 = query[i].row2;
			int c2 = query[i].col2;

			int A = matrix[r2][c2];
			int B = c1-1>=0 ? matrix[r2][c1-1] : 0;
			int C = r1-1>=0 ? matrix[r1-1][c2] : 0;
			int D = r1-1>=0 && c1-1>=0 ? matrix[r1-1][c1-1] : 0;

			int sumOfRanges = A - B - C + D;//sum between range

			ans.add(sumOfRanges);
			
		}

		return ans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            matrix[i][j]=sc.nextInt();
        }
        int q = sc.nextInt();
        Pair query[] = new Pair[q];

        Solution obj = new Solution();
        for (int i = 0; i < q; i++) {
            Pair p=new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            query[i]=p;
        }
        List<Integer> ans = obj.solve(matrix, query);
        for(int x: ans)
        System.out.println(x);
        sc.close();
    }
}
