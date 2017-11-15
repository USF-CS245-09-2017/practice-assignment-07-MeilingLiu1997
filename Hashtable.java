package cs245.PA07;

public class Hashtable {	
	// data member
	private HashNode[] arr;
	private int size;
    
	// constructor -- Initializes capacity, size and empty chains.
	public Hashtable() {
		arr = new HashNode[10];
		size = 0;
	}
	
	// method
	private int getIndex(String key){
        int hashCode = key.hashCode();
        int index = hashCode % arr.length;
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
			return null;
		}
		HashNode prev = head;
		while(head != null) {
			if(head.key() == key) {
				prev.next = head.next;
				size--;
				return head.value();
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
    
}
