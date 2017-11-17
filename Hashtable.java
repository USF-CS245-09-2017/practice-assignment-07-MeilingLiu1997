
public class Hashtable {	
	// data member
	private HashNode[] arr;
	private int size;
    
	// constructor -- Initializes capacity, size and empty chains.
	public Hashtable() {
		arr = new HashNode[314527];
		size = 0;
	}
	
	// method
	private int getIndex(String key){
		//https://www.tutorialspoint.com/java/lang/math_abs_int.htm
        int hashCode = Math.abs(key.hashCode());
        int index = 0;
        if (hashCode > 2027) {
        		index = hashCode % arr.length;
        }
        return index;
    }
	
	boolean containsKey (String key) {
		int pos = getIndex(key);
		if(arr[pos] != null) {
			HashNode tmp = arr[pos];
			while(tmp.next != null) {
				if(tmp.key().equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	public String get(String key) {
		int pos = getIndex(key);
		HashNode start = arr[pos];

		while(start != null) {
			if(start.key == key) {
				return start.value();
			}
			start = start.next;
		}
		return null;
	}

	public void put (String key, String value) {
		int pos = getIndex(key);
		HashNode head = arr[pos];
		HashNode start = new HashNode(key, value);
		start.next = head;
		arr[pos] = start;
		size++;
	}

	public String remove(String key) {
		int pos = getIndex(key);
		HashNode head = arr[pos];
		
		if(head == null) {
			return null;
		}
		if(head.key() == key) {
			arr[pos] = head.next;
			size--;
			return head.value();
		}
		
		HashNode prev = null;
		while(head != null) {
			if(head.key().equals(key)) {
				prev.next = head.next;
				size--;
				return head.value();
			}
			prev = head;
			head = head.next;
		}
		return head.value();
	}
    
}
