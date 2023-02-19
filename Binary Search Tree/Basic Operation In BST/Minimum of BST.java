//Minimum node value in BST

public static int min(Node node) {
    //left leaf ele is minimum ele
	  //last leaf is min of all tree

	  if(node.left!=null){
      
		  return min(node.left);
	  }
	  else{
      //leaf node of left part
		  return node.data;
	  }
  }
