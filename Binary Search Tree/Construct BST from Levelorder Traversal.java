/*Construct Bst From Levelorder Traversal

You are given an array representing the valid level order traversal of a BST. 
You are required to build the unique Binary Search Tree of which the level order traversal is provided.

A Binary Search Tree (BST) is a binary tree data structure that has the following properties -

The left subtree of a node contains only nodes with data less than the node’s data.
The right subtree of a node contains only nodes with data greater than the node’s data.
Both the left and right subtrees must also be binary search trees.
Note

You are required to return the root node of the BST and the printing will be taken care of in the main function.
Simply complete the function bstFromLevel which receives n and input array as parameters and returns the root node of the BST.

Input Format
First line of input contains n representing the number of nodes.
The second line contains the n space-separated nodes representing the level order of the BST.

Output Format
The single line of output contains the level order traversal of the BST.

Example 1
Input

6
3 2 5 1 6 7

        3
      /  \
    2     5
  /        \
1           6
             \
              7
Output

3 2 5 1 6 7*/

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution {
	 class Pair{
        Node parent;
        int lb;
        int ub;
        
        Pair(){
            this.parent = null;
            this.lb = Integer.MIN_VALUE;
            this.ub = Integer.MAX_VALUE;
        }
        
        Pair(Node nn, int lb, int ub){
            this.parent = nn;
            this.lb = lb;
            this.ub = ub;
        }
    }
    //Function to construct the BST from its given level order traversal.
    public Node bstFromLevel(int[] arr, int n)
    {
       int idx=0;//traverse arr upto length
       
       Node root=null;//contruct root and return
       
       Queue<Pair>que=new LinkedList<>();
       
       que.add(new Pair());//add parent as null amd lb & ub
       
       while(que.size()>0 && idx<n){
           
           Pair curr=que.poll();//remove parent
           
           int element=arr[idx];//get each ele
           
           if(element < curr.lb || element > curr.ub)continue;//if out of range 
           
           idx++;//update index
           
           Node node=new Node(element);//make a node
           
           if(curr.parent==null){
               //if node is first then update root
               root=node;
           }
           else{
               //if have parent
               //if node is less than parent the left node it is
               if(node.data < curr.parent.data){
                   curr.parent.left = node;
               }
               else{
                   curr.parent.right = node;
               }
               
           }
           
           //add parent as currNode and left range and right range for child
           que.add(new Pair(node, curr.lb, node.data));
           que.add(new Pair(node, node.data, curr.ub));
           
       }
       
       return root;
    }
}
