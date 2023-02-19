//determine given tree is BST or not

//Approach 1
//TC:O(N), SC:O(N)
class Solution{
	class BSTPair{
		boolean isBst;
		int max;
		int min;

		BSTPair(){
			this.max=Integer.MIN_VALUE;
			this.min=Integer.MAX_VALUE;
			this.isBst=true;
		}
		BSTPair(boolean bst, int max, int min){
			this.max=max;
			this.min=min;
			this.isBst=bst;
		}
	}

	BSTPair valid(Node node){

		if(node==null){
			return new BSTPair();
		}
		//nodebst
		BSTPair leftpart=valid(node.left);
		BSTPair rightpart=valid(node.right);

		//treebst
		boolean isBST=leftpart.isBst && rightpart.isBst &&(node.data>leftpart.max && node.data<rightpart.min);
		int rmin = Math.min(node.data, Math.min(leftpart.min, rightpart.min));
		int lmax = Math.max(node.data, Math.max(leftpart.max, rightpart.max));

		return new BSTPair(isBST, lmax, rmin);
		
	}
    boolean isBST(Node node){
		
		BSTPair ans=valid(node);

		return ans.isBst;
		
    }
}

//Approach 2
//TC:O(N) SC:O(N)
boolean Inrange(Node node, int lb, int ub){
	if(node.data>ub || node.data<lb)return false;

	boolean leftpart=Inrange(node.left, lb, node.data);
	boolean rightpart=Inrange(node.right, node.data, ub);

	if(leftpart&&rightpart&& node.data>lb && node.data<ub){
		return true;
	}

	return false;
}

 boolean isBST(Node node){
		
	boolean ans=Inrange(node, Integer.MAX_VALUE, Integer.MIN_VALUE);

		return ans;
		
  }


//INput SEction

 public static void main (String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int t=Integer.parseInt(br.readLine());
          while(t > 0){
              String s = br.readLine();
            Node root = treeBuilder(s);
              Solution g = new Solution();
              if(g.isBST(root))
              System.out.println("true");
          else
              System.out.println("false");
                t--;
        }
    }
  
}
