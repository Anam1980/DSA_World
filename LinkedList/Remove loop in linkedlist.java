class Solution{
    public static void removeLoop(Node node){
        Node low=node;
		Node high=node;

		while(low!=null && high!=null && high.next!=null){
			low=low.next;
			high=high.next.next;
			if(low==high){
				break;//loop detect
			}
		}

		//low=head
		if(low==node){
			while(high.next!=low){
			  high=high.next;
			}
			high.next=null;
		}
		else if(low==high){
			low=node;
			while(low.next!=high.next){
				low=low.next;
				high=high.next;
			}

			high.next=null;
			
		}

		

    }
    
}
