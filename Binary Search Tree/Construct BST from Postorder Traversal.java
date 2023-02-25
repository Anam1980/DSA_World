/*You are given an array postOrder consisting of PostOrder Traversal of a valid Binary Search Tree.

Your task is to create a unique Binary Search Tree are return the head node of the tree.

A Binary Search Tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, 
and any descendant of Node.right has a value strictly greater than Node.val.*/

import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

	private static int idx=0;
  
	static TreeNode constructTree(int[]post, int lb, int ub){

		if(idx<0 || post[idx]<lb || post[idx]>ub){
			return null;
		}
    
		TreeNode node=new TreeNode(post[idx--]);
		
		//go right because we iterating from right to left i.e.0<--n L R Root
		node.right=constructTree(post, node.val, ub);
		node.left=constructTree(post, lb, node.val);

		return node;
    
	}
  
    public static TreeNode CreateTree(int n,int[] postOrder) {
      
     idx=n-1;
    TreeNode ans=constructTree(postOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return ans;
      
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        TreeNode root = CreateTree(n,post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
