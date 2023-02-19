//Maximum node value in BST

public static int max(Node node) {
   //In BST, all right element are maximum
//right leaf ele is max of all tree

	  if(node.right!=null){
		  //i m not leaf
		  return max(node.right);
	  }
	  else{
		  //i m leaf node
		  return node.data;
	  }
  }
