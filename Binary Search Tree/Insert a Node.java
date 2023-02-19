import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){
        
    }
    BST(Node root){
        root=root;
    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val == val)
            return root;
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    void print(Node root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

class Solution{
	//TC:O(N) SC:O(h)
    public Node insertNode(Node root, int val){

	    //create a node for val
		 Node nn=new Node(val);

	    //if root is null , default the first node is new one
		if(root==null)return nn;
	//if given val less than root data then insert node in left
       if(val<root.val){
	       Node nlft=insertNode(root.left, val);
	       root.left=nlft;	   
	   }
	    ////if given val greater than root data then insert node in left
	else if(val>root.val){
		Node nrgt=insertNode(root.right, val);
		root.right=nrgt;
	}

		return root;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        t.root= obj.insertNode(t.root, k);
        t.print(t.root);
    }
}
