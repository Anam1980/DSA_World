/*Task>>>
You are a given a root node of partially constructed BST.
You are also given a value target , your task is to print all the nodes that add up to form the target value.
Make sure all pairs print the smaller value first and avoid duplicacies and also print the pairs in increasing order.*/


//Approach 1
//----------------------------------------TreeToList-----------------------------//
class Accio {
    //convert BST int inorder list
    void TreetoList(Node root, ArrayList<Integer>list){

		if(root==null){
			return ;
		}

     //Inorder Traversal
		TreetoList(root.left, list);
		list.add(root.data);
		TreetoList(root.right, list);	
	}
	
	
    public void targetSum(Node root, int tar)
    {
       ArrayList<Integer>a1=new ArrayList<>();//list to add all nodes in sorted manner

		TreetoList(root, a1);//call func

      //initialize variable 
      
		int st=0; //point to first index
		int end=a1.size()-1; //point to last

      //check for sum 
		boolean found=false;
		
      //by two pointer approach
		while(st<end){
      
		if(a1.get(st) + a1.get(end) == tar){
      //print ever pair
			System.out.println(a1.get(st)+" "+a1.get(end));
      //mark as found
			found=true;
      
      //go for more pairs
			st++;
			end--;
		}
      //if sum is less than target, move start
		else if(a1.get(st) + a1.get(end) < tar){
			st++;
		}
      //if sum is greater than target, move end
		else{
			end--;
		}
	}
      //if not found any pair
		if(found==false){
			System.out.print(-1);
		}
	}
}


//Approach 2
//-----------------------------------------BST Iterator------------------------------------------------//
