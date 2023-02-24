//LEETCODE 1373

/*Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //if valid-->add val to sum and calculate maxSum
 //no valid-->start from new sum
 //leaf node-->take nodeval as sum and maxSum
class Solution {
    class Pair{
        int max;
        int min;
        boolean isBST;
        int sum;
        Pair(int s, boolean tf){
            this.sum=s;
            this.isBST=tf;
        }
        Pair(int max, int min, boolean tf, int sum){
            this.max=max;
            this.min=min;
            this.isBST=tf;
            this.sum=sum;
        }
    }
    int maxSum;
    public Pair CalculateMaxSum(TreeNode node){
        //atlast
        if(node==null){
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        }

        //handle leaf nodes
        if(node.left==null && node.right==null){

            maxSum=Math.max(maxSum, node.val);

            return new Pair(node.val, node.val, true, node.val);
        }
        //to check BST or not we do post traversal with min & max of subtree

        //check left
        Pair left=CalculateMaxSum(node.left);

        //check right
        Pair right=CalculateMaxSum(node.right);

        //check me i.e valid or not
        if(node.val>left.max && node.val<right.min && left.isBST && right.isBST){
            //add to sum and calculate maxSum
            int currMax=Math.max(node.val, Math.max(left.max, right.max));
            int currMin=Math.min(node.val, Math.min(left.min, right.min));
            int currSum=node.val + left.sum + right.sum;
            boolean isNodeBST=true;

             maxSum=Math.max(maxSum, currSum);

            Pair currNodePair=new Pair(currMax, currMin, isNodeBST, currSum);

            return currNodePair;
        }
        //if not valid BSt
        else{
            //new sum starts
            
             Pair currNodePair=new Pair(node.val, false);
             
             return currNodePair;

        }
        
    }
    public int maxSumBST(TreeNode root) {
        //take a helper function and global variable maxSum
        maxSum=0;
        CalculateMaxSum(root);
        return maxSum;
    }
}
 



