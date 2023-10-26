import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt(), q = sc.nextInt();
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            String s = sc.next();
            if (s.equals("GET"))
                s += " " + sc.nextInt();
            else
                s += " " + sc.nextInt() + " " + sc.nextInt();
            queries[i] = s;
        }
        sc.close();
        LRUCache lruCache = new LRUCache(cap);
        for (String s : queries) {
            String[] arr = s.split(" ");
            if (arr.length == 3)
                lruCache.set(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            else
                System.out.println(lruCache.get(Integer.parseInt(arr[1])));
        }
    }
}

class LRUCache {
    class Node{
		int key;
		int val;
		Node next;
		Node prev;

		Node(){
			this.next=null;
			this.prev=null;
			this.key=0;
			this.val=0;
		}

		Node(int k, int v){
			this.key=k;
			this.val=v;
			this.next=null;
			this.prev=null;
		}
	}

	void addNode(Node node){
		Node head_next=head.next;

		node.next=head_next;
		node.prev=head;
				
		head_next.prev=node;
		head.next=node;
	}

	void removeNode(Node node){
		Node node_prev=node.prev;
		Node node_next=node.next;

		node_prev.next=node_next;
		node_next.prev=node.prev;

		node.next=null;
		node.prev=null;
	}

	void moveTofront(Node node){
		removeNode(node);
		addNode(node);
	}
	
	Node head;
	Node tail;
	int maxCapacity;
	HashMap<Integer, Node>cache;
    public LRUCache(int capacity) {
        head=new Node();
		tail=new Node();
		head.next=tail;
		tail.prev=head;

		maxCapacity=capacity;
		cache=new HashMap<>();
    }

    public int get(int key) {
       if(cache.containsKey(key)==false){
		   return -1;
	   }
		Node read_app=cache.get(key);
		moveTofront(read_app);

		return read_app.val;
    }

    public void set(int key, int value) {
		Node new_app=new Node(key, value);
		//first node is most recent
		//last node least recent
       if(cache.containsKey(key)==true){
		   //update
		   //movefront
		   Node link_node=cache.get(key);
		   link_node.val=value;
		   moveTofront(link_node);
	   }
		else{
			//add fresh app
			//but if the size is full
			if(cache.size()==maxCapacity){
				Node LRU_app=tail.prev;
				cache.remove(LRU_app.key);
				removeNode(LRU_app);
			}
			//add to the first
			cache.put(key, new_app);
			addNode(new_app);	
		}
    }

}
