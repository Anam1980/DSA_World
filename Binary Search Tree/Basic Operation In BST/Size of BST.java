//Count of all nodes in BST

 public static int size(Node node) {
    if(node==null)return 0;

   //go left
	  int ls=size(node.left);
   
   //go right
	  int rs=size(node.right);
   
    //add left + right + 1 for curr node
	  int siz=ls + rs + 1;

	  return siz;
  }
