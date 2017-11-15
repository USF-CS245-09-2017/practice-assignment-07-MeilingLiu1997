public class HashNode{
    String key;
    String value;
 
    // Reference to next node
    HashNode next;
 
    // Constructor
    public HashNode(String key, String value) {
        this.key = key;
        this.value = value;
		this.next = null;
    }
    
    public String key() {
		return this.key;
	}
	public String value() {
		return this.value;
	}
}
