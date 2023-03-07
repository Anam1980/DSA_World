/*Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Your task is to complete the function serialize, which stores the binary search tree into an array A[], and deSerialize, which deserializes the array to the binary search tree and returns it.

Note

The structure of the tree must be maintained. Multiple nodes can have the same data.*/

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

    // Encodes a tree to a single string.
    static void  Encode(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }

        
        sb.append(root.val+",");

        Encode(root.left, sb);
        Encode(root.right, sb);

    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        //convert to string
        StringBuilder sb=new StringBuilder();
        Encode(root, sb);

        return sb.toString();
    }

    static int idx=0;
   static TreeNode Decode(String[] data){

        String st=data[idx];
        idx++;

        if(st.equals("null")==true){
            return null;
        }

        if(idx==data.length){
            return null;
        }
        
        int NodeVal=Integer.parseInt(st);

        TreeNode nn=new TreeNode(NodeVal);

        nn.left=Decode(data);
        nn.right=Decode(data);

        return nn;
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        String[] input=data.split(",");

        TreeNode ansNode=Decode(input);

        return ansNode;


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

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}
