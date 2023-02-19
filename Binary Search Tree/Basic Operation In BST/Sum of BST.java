//SUm of all nodes in BST

 public static int sum(Node node) {

	  if(node==null)return 0;
   
     //go left 
	  int ls=sum(node.left);
   
   //go right
	  int rs=sum(node.right);

   //add curr + left + right val
	  int Sum=ls+rs+node.data;

   //return final sum
	  return Sum;
  }
