/*Task>>>
You are a given a root node of partially constructed BST.
You are also given a value target , your task is to print all the nodes that add up to form the target value.
Make sure all pairs print the smaller value first and avoid duplicacies and also print the pairs in increasing order.*/

//Approach 1
//TC:O(N*H) SC:O(H)
//-------------------------------------------ComponentFind-----------------------------------------//

public void targetSum(Node root, Node node, int tar){
		if(root==null)return;

		//traverse in Inorder

		//go left
		targetSum(root, node.left, tar);

		//now calulate component
		int comp=tar-node.data;
		if(comp>node.data){
			//find in whole tree
			if(Find(root, comp)==true){
				System.out.print(node.data +" "+comp);
			}
		}

		//go right
		targetSum(root, node.right, tar);
	}

	public boolean Find(Node root, int target){

		if(root==null){
			return false;
		}
		
		if(root.data>target){
			return Find(root.left, target);
		}
		else if(root.data<target){
			return Find(root.right, target);
		}
		else{
			return true;
		}
//Approach 2

//TC:O(N) SC:O(N)

//----------------------------------------TreeToList---------------------------------------------//
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


//Approach 3

//TC:O(N)   SC:O(H)
//-----------------------------------------BST Iterator------------------------------------------------//

class Node {
    int val;
    Node left, right;
    public Node(int item){
        val = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)return null;
        int mid=(start+end)/2;
        if(root==null)root=new Node(arr[mid]);
        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);
        return root;
    }
}

class Solution{
	static class Pair{
		Node node;
		int state;
		
		Pair(Node nn, int p){
			this.node=nn;
			this.state=p;
		}
	}

	static Node getNormalInorder(Stack<Pair>st){

		while(st.size()>0){
			Pair top=st.peek();
			if(top.state==1){
				//pre
				//push left if present
				//update state

				top.state++;
				if(top.node.left!=null){
					st.push(new Pair(top.node.left, 1));
				}
				
			}
			else if(top.state==2){
				//inorder
				top.state++;
				if(top.node.right!=null){
					st.push(new Pair(top.node.right, 1));
				}
				return top.node;
			}
			else{
				//pre
				st.pop();
			}
		}
		return null;
	}
	static Node getReverseInorder(Stack<Pair>st){
		while(st.size()>0){
			Pair top=st.peek();
			if(top.state==1){
				//pre
				//push left if present
				//update state

				top.state++;
				if(top.node.right!=null){
					st.push(new Pair(top.node.right, 1));
				}
				
			}
			else if(top.state==2){
				//inorder
				top.state++;
				if(top.node.left!=null){
					st.push(new Pair(top.node.left, 1));
				}
				return top.node;
			}
			else{
				//pre
				st.pop();
			}
		}
		return null;
	}
    public static boolean checkTarget(Node root, int tar){
       Stack<Pair>ls=new Stack<>();
		
	   Stack<Pair>rs=new Stack<>();

		ls.push(new Pair(root, 1));
		rs.push(new Pair(root, 1));

	    Node left = getNormalInorder(ls);
		Node right = getReverseInorder(rs);

		while(left.val<right.val){
			if(left.val + right.val < tar){
				left = getNormalInorder(ls);
			}
			else if(left.val + right.val > tar){
				right = getReverseInorder(rs);
			}
			else{
				left = getNormalInorder(ls);
				right = getReverseInorder(rs);
				return true;
			}
		}
		return false;
    }
}

		
//-------------------------------------------------------INPUT SECTION-------------------------------------------//
		
public class Main {
	
    public static void main(String[] args) throws Throwable {
	    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt(); 
        }
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
        Solution A = new Solution();
        boolean ans = A.checkTarget(root,k);
        if(ans==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
