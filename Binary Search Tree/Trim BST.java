/*You are provided with root of a valid Binary Search Tree and and the lowest and highest boundaries as low and high.

Your task is to trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

A Binary Search Tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

NOTE: You have to complete the function trimTree. The input and output is already handled.*/

import java.util.*;

class Node {
    int val;
    Node left, right;
    public Node(int item){
        val = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)return null;
        int mid=(start+end)/2;
        if(root==null)root=new Node(arr[mid]);
        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);
        return root;
    }

    void printInorder(Node node){
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}

class Solution{
    public static Node trimTree(Node root, int low, int high){

		if(root==null)return null;
		
        if(root.val<low ){
			return trimTree(root.right, low, high);
		}
	    if(root.val>high){
			return trimTree(root.left, low, high);
		}
		
		root.left= trimTree(root.left, low, high);
		root.right=	trimTree(root.right, low, high);
	
		return root;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int low = sc.nextInt();
        int high = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt(); 
        }
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
        Solution A = new Solution();
        Node ans = A.trimTree(root,low,high);
        bst.printInorder(ans);
    }
}
