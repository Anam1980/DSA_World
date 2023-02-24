/*Construct BST From Preorder Traversal
You are given an array preOrder consisting of PreOrder Traversal of a valid Binary Search Tree.

Your task is to create a unique Binary Search Tree are return the head node of the tree.

A Binary Search Tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

NOTE

You just need to complete the CreateTree function and return the head node of the tree generated.

Input Format
First line contains an integer n denoting the nodes in the BST.
Second line contains n space-seprated integers denoting PreOrder traversal of the tree

Output Format
For each node in the array print the a line in folowing format:

Node.left.val->Node.val<-Node.right.val

If, Any node is null print ..

Example 1
Input

6
3 2 1 6 5 7
Output

2->3<-6
1->2<-.
.->1<-.
5->6<-7
.->5<-.
.->7<-.
Explanation

The Binary Search Tree for Following input would be

          3
        /   \
       2     6
      /     / \
     1     5   7


Hence the output shows the child nodes for each node.
*/
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

	 static int idx=0;
   static  TreeNode ListToTree(int[]pre, int n, int lb, int ub){
        //if limit not satistisfies so means null there
        if(idx>=n || pre[idx]>ub || pre[idx]<lb)return null;

        //creaet node , move indexto right
        TreeNode root= new TreeNode(pre[idx++]);

        //go left
        root.left=ListToTree(pre, n, lb, root.val);
        //go right
        root.right=ListToTree(pre, n, root.val, ub);

        return root;
    }
    public static TreeNode CreateTree(preorder.length, int[] preorder) {
        //as it is bst we have to build acc. rule of BST so take lower bound and upper bound i.e.limits
        return ListToTree(preorder, preorder.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = CreateTree(n,pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
