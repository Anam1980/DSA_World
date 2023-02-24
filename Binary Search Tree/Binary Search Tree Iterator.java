/*Binary Search Tree Iterator
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.

boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.

int next() Moves the pointer to the right, then returns the number at the pointer.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

Note Complete the given function. The input and output would be handled by the driver code.*/



import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;

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

  public static class BSTIterator {
   
//create Stack to store node Left Print Right
    Stack<TreeNode>bst=new Stack<>();
    public BSTIterator(TreeNode root) {
        //first add all left
        while(root!=null){
            bst.push(root);
            root=root.left;//going left same as recursion upto null
        }
    }
    
    public int next() {
        //when we are end traversing left then now print 
        TreeNode curr=bst.peek();
        bst.pop();
        //now traverse right after print

        TreeNode rnode=curr.right;
        while(rnode!=null){
            bst.push(rnode);
            rnode=rnode.left;//after going to right again we are at left first so restart process, 
            //same as recursion, again function   call left
        }

        return curr.val;
    }
    
    public boolean hasNext() {
        //check elment is present or not
        if(bst.size()>0)return true;

        return false;
    }
  }

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

  public static TreeNode constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
      return null;
    int mid = (si + ei) / 2;
    TreeNode node = new TreeNode(in[mid]);
    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);
    return node;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
      in[i] = scn.nextInt();
    TreeNode root = constructFromInOrder_(in, 0, in.length - 1);
    BSTIterator itr = new BSTIterator(root);
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
