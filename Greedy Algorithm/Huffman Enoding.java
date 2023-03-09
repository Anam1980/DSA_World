//User function Template for Java


class Solution {
    
    class Node{
        Node left;
        Node right;
        int freq;
        char ch;
        
        Node(char ch, int f){
            this.ch=ch;
            this.freq=f;
        }
    }
    
    void preOrderTraversal(ArrayList<String>anslist, Node tree, String bit){
        
        if(tree.left==null && tree.right==null){
            
            anslist.add(bit);
            return;
        }
        //add 0 when go left
        preOrderTraversal(anslist, tree.left, bit+'0');
        //add 1 when go right
        preOrderTraversal(anslist, tree.right, bit+'1');
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
      //we use priority queue to take min element as left
      PriorityQueue<Node>pq=new PriorityQueue<>((a, b)->{return a.freq<b.freq?-1:1;});
      
      //add all character with frequency
      for(int i=0; i<N; i++){
          pq.add(new Node(S.charAt(i), f[i]));
      }
      
      while(pq.size()>1){
          Node small = pq.poll();//first min
          Node large = pq.poll();//sec min
          
          //add both freq and make a newNode
          int sum = small.freq + large.freq;
          
          Node newNode=new Node('.', sum);
          
          //add left should be first min and right should be sec min
          newNode.left=small;
          newNode.right=large;
          
          
          //add the new Node to queue
          pq.add(newNode);
      }
      
      ArrayList<String>anslist=new ArrayList<>();
      
      Node huffmanTree = pq.poll();
      
      preOrderTraversal(anslist, huffmanTree, "");
      
      return anslist;
    }
}
