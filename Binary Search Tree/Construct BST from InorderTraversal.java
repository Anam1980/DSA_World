class Node{
  
  Node left;
  Node right;
  int data;
  
  Node(){
    this.left=null;
    this.right=null;
  }
  
  Node(int val){
    this.data=val;
    this.left=null;
    this.right=null;
  }
  
}
class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
      //by using binary search method
        if(start>end)
            return null;
      
        int mid=(start+end)/2;

      //if no node then create new node
        if(root==null)
            root=new Node(arr[mid]);

      //go left
        root.left=constructBST(arr,start,mid-1, root.left);
      //go right
        root.right=constructBST(arr,mid+1,end, root.right);

        return root;

    }
}
public void print(Node root){
  //inorder print
  print(root.left);
  System.out.print(root.data+" ");
  print(root.right);
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt(); 
        }

        Arrays.sort(arr);
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
        print(root);
    }
}
