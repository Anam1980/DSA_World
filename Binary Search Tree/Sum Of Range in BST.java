//sum of all values of node which is between the range
//TC:O(N) SC:O(h)
class Solution
{ 
	long sum=0;
    long rangeSum(Node root, int l, int r){ 

		if(root==null)return 0;
		
     //if data is greater than ranges,
      //move left of subtree
		if(l<root.data && r<root.data){
			rangeSum(root.left, l, r);
		}
      
    //if data is less than ranges,
      //move right of subtree
		else if(l>root.data && r>root.data){
			rangeSum(root.right, l, r);
		}
      
      //if within a range, then add to sum
      //go for next element in left and right
		else{
			sum+=root.data;
			rangeSum(root.left, l, r);
			rangeSum(root.right, l, r);
		}

		return sum;
    }  
}
