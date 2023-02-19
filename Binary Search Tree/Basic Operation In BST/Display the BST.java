//print Bst in Preorder traversal

 void print(Node root){
   //print
        System.out.print(root.val + " ");
   
   //go left
        if(root.left != null){
            print(root.left);
        }
   //go right
        if(root.right != null){
            print(root.right);
        }
    }

//print Bst in Inorder traversal

 void print(Node root){
   
   //go left
        if(root.left != null){
            print(root.left);
        }
   //print
        System.out.print(root.val + " ");
   
   //go right
        if(root.right != null){
            print(root.right);
        }
 }

//print Bst in Postorder traversal

 void print(Node root){
   
    //go left
        if(root.left != null){
            print(root.left);
        }
   
   //go right
        if(root.right != null){
            print(root.right);
        }
   
    //print
        System.out.print(root.val + " ");
     
 }
   
    
