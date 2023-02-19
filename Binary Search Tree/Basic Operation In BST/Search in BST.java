//Determine that the given val is present or not in BST

 public static boolean find(Node node, int data){
    //In BST, left are less and right are large

	  if(node==null){
		  return false;
	  }

	  if(data < node.data){
		  //search in left
		  return find(node.left, data);
	  }
	  else if(data > node.data){
		  //search in right
		  return find(node.right, data);
	  }
	  else{
		  return true;//dont need to search, val==node.data
	  }
  }  
