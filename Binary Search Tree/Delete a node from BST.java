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
	private int minValue(Node root){
		int minVal = root.val;
		while(root.left != null){
			minVal  = root.left.val;
			root = root.left;
		}
		return minVal;
	}
    public Node deleteNode(Node root, int val){
        // WRITE YOUR CODE HERE
		if(root == null)return root;

		if(val < root.val){
			root.left = deleteNode(root.left, val);
		}
		else if(val > root.val){
			root.right = deleteNode(root.right, val);
		}
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else{
				root.val = minValue(root.right);
				root.right = deleteNode(root.right, root.val);
			}
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
        t.root= obj.deleteNode(t.root, k);
        t.print(t.root);
    }
}
