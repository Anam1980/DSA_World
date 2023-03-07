/*You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.

Your task is to recover the tree without changing its structure.

Note

You are Not Allowed To Use Extra Space.*/

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

	private static TreeNode prev=null;
	private static TreeNode first=null;
	private static TreeNode last=null;

	public static void dfs(TreeNode root) {
		if(root==null)return;

		dfs(root.left);

		if(prev!=null && prev.val>root.val){
		if(first==null){
			first=prev;
		}
			last=root;
			
		}

		prev=root;
		
		dfs(root.right);
		
	}
	
    public static void recoverTree(TreeNode root) {
        if(root==null)return;

		dfs(root);

		int tmp=first.val;
		first.val=last.val;
		last.val=tmp;

		return;
		
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
