/*You are provided with root of a valid Binary Search Tree and a target number k.

Your task is to return true if there exist two elements in the BST such that the sum is equal to the given target, Otherwise return false.

A Binary Search Tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

NOTE: You have to complete the function checkTarget. The input and output is already handled.

Input Format
First line contains two space separated integers n and k denoting the nodes in the BST and target sum respectively.
Second line contains n space-seprated integers denoting InOrder traversal of the tree*/

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
}

class Solution{
	static class Pair{
		Node node;
		int state;
		
		Pair(Node nn, int p){
			this.node=nn;
			this.state=p;
		}
	}

	static Node getNormalInorder(Stack<Pair>st){

		while(st.size()>0){
			Pair top=st.peek();
			if(top.state==1){
				//pre
				//push left if present
				//update state

				top.state++;
				if(top.node.left!=null){
					st.push(new Pair(top.node.left, 1));
				}
				
			}
			else if(top.state==2){
				//inorder
				top.state++;
				if(top.node.right!=null){
					st.push(new Pair(top.node.right, 1));
				}
				return top.node;
			}
			else{
				//post
				st.pop();
			}
		}
		return null;
	}
	static Node getReverseInorder(Stack<Pair>st){
		while(st.size()>0){
			Pair top=st.peek();
			if(top.state==1){
				//pre
				//push left if present
				//update state

				top.state++;
				if(top.node.right!=null){
					st.push(new Pair(top.node.right, 1));
				}
				
			}
			else if(top.state==2){
				//inorder
				top.state++;
				if(top.node.left!=null){
					st.push(new Pair(top.node.left, 1));
				}
				return top.node;
			}
			else{
				//pre
				st.pop();
			}
		}
		return null;
	}
    public static boolean checkTarget(Node root, int tar){
       Stack<Pair>ls=new Stack<>();
		
	   Stack<Pair>rs=new Stack<>();

		ls.push(new Pair(root, 1));
		rs.push(new Pair(root, 1));

	    Node left = getNormalInorder(ls);
		Node right = getReverseInorder(rs);

		while(left.val<right.val){
			if(left.val + right.val < tar){
				left = getNormalInorder(ls);
			}
			else if(left.val + right.val > tar){
				right = getReverseInorder(rs);
			}
			else{
				
				return true;
			}
		}
		return false;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt(); 
        }
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
        Solution A = new Solution();
        boolean ans = A.checkTarget(root,k);
        if(ans==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
